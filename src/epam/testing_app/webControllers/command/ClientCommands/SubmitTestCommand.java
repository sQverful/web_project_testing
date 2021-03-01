package epam.testing_app.webControllers.command.ClientCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.AnswerDao;
import epam.testing_app.database.dao.QuestionDao;
import epam.testing_app.database.dao.TestResultsDao;
import epam.testing_app.database.entity.Answer;
import epam.testing_app.database.entity.TestResult;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SubmitTestCommand extends Command {

    private static final long serialVersionUID = -7713537641302542959L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Router router = new Router();

        // We use counter to get know how many answers do we have to read from user request
        int counter = Integer.parseInt(request.getParameter("counter"));
        int testID = Integer.parseInt(request.getParameter("test_id"));
        User currentUser = (User) request.getSession().getAttribute("user");

        // BUG-fix for case when user starts one test and changes link to another test id
        int timerID = (int) session.getAttribute("timerID");
        if (timerID != testID) {
            removeTestSessionAttributes(session);
            request.setAttribute("message", "invalid request");
            request.setAttribute("code", "404");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        List<Answer> userAnswersList = new ArrayList<>();
        int answerID = -1;
        AnswerDao answerDao = new AnswerDao();
        //Collecting all answers in tests
        List<Answer> answersInTests = answerDao.getAnswersListByQuestionList(new QuestionDao().findAllQuestionsByTestId(testID));

        //Collecting user answers
        for (int i = 1; i <= counter; i++) {
            if (request.getParameter("answer" + i) == null) {
                continue;
            }
            answerID = Integer.parseInt(request.getParameter("answer" + i));
            userAnswersList.add(answerDao.getAnswerById(answerID));
        }

        int result = (int) Math.round(calculateResult(answersInTests, userAnswersList));

        request.setAttribute("testResult", result);
        TestResult testResult = TestResult.createTestResult(result, currentUser.getId(), testID);
        TestResultsDao testResultsDao = new TestResultsDao();

        // if user submitted answers with expired timer, then result eq 0
        //user has 5 bonus for processing his result
        Timestamp currentTime = new Timestamp(System.currentTimeMillis() - 5_000);
        Timestamp timeEnd = (Timestamp) session.getAttribute("timeEnd");
        if (currentTime.after(timeEnd)) {
            result = 0;
            if (!testResultsDao.insertTestResult(testResult)) {
                request.setAttribute("message", "cannot insert subject");
                request.setAttribute("code", "500");
                router.setPage(Path.PAGE_ERROR_PAGE);
                return router;
            }
            router.setPage(Path.NOTIFICATION_TEST_SUBMITTED_FAIL + "&testResult=" + testResult.getId());
            router.setRedirect();
            return router;
        }

        //if timer is not expired, then just inserting new testResult in DB
        if (!testResultsDao.insertTestResult(testResult)) {
            request.setAttribute("message", "cannot insert subject");
            request.setAttribute("code", "500");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }
        //Deleting tmp attributes from session
        removeTestSessionAttributes(session);

        //Redirecting to the notification page
        router.setPage(Path.NOTIFICATION_TEST_SUBMITTED + "&testResult=" + testResult.getId());
        router.setRedirect();
        return router;
    }


    private double calculateResult(List<Answer> answersInTests, List<Answer> userAnswersList) {
        double correctAnsCoef = calculateCorrectCoef(answersInTests);
        double incorrectAnsCoef = calculateIncorrectCoef(answersInTests);
        double res = 0.;

        for (Answer a : userAnswersList) {
            if (a.getCorrect()) {
                res = res + correctAnsCoef;
            } else {
                res = res - incorrectAnsCoef;
            }
        }



        if (res < 0.) {
            res = 0.;
        }
        return res;
    }

    private double calculateIncorrectCoef(List<Answer> answersInTests) {
        double result;
        double counter = 0.;
        for (Answer a : answersInTests) {
            if (!a.getCorrect()) {
                counter++;
            }
        }

        return result = 100. / counter;
    }

    private double calculateCorrectCoef(List<Answer> answersInTests) {
        double result;

        double counter = 0.;
        for (Answer a : answersInTests) {
            if (a.getCorrect()) {
                counter++;
            }
        }

        return result = 100. / counter;
    }

    private void removeTestSessionAttributes(HttpSession session) {
        session.removeAttribute("timeStart");
        session.removeAttribute("timeEnd");
        session.removeAttribute("timerID");
    }
}
