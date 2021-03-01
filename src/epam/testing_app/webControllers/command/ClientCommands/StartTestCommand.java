package epam.testing_app.webControllers.command.ClientCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.AnswerDao;
import epam.testing_app.database.dao.QuestionDao;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.database.entity.Question;
import epam.testing_app.database.entity.Test;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class StartTestCommand extends Command {

    private static final long serialVersionUID = 1525494364885628960L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        int testID = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();

        TestDao testDao = new TestDao();
        Test selectedTest = testDao.getTestById(testID);

        List<Question> questionList = new QuestionDao().findAllQuestionsByTestId(testID);

        // in case if user tries to get blocked test he gets notification page
        if (selectedTest.isBlocked()) {
            router.setPage(Path.NOTIFICATION_TEST_BLOCKED);
            router.setRedirect();
            return router;
        }

        request.setAttribute("selectedTest", selectedTest);
        request.setAttribute("selectedSubject", new SubjectDao().getSubjectById(selectedTest.getSubjectId()));
        request.setAttribute("questionList", new QuestionDao().findAllQuestionsByTestId(testID));
        request.setAttribute("answerList", new AnswerDao().getAnswersListByQuestionList(questionList));
        request.setAttribute("isStarted", true);

        if (session.getAttribute("timeStart") == null || session.getAttribute("timeEnd") == null || session.getAttribute("timerID") == null) {
            session.setAttribute("timerID", testID);
            Timestamp timeStart = new Timestamp(System.currentTimeMillis());
            Timestamp timeEnd = new Timestamp(timeStart.getTime() + selectedTest.getTimer() * 60_000);
            session.setAttribute("timeStart", timeStart);
            session.setAttribute("timeEnd", timeEnd);
            testDao.addNewRequestQuantity();
        }

        if (!session.getAttribute("timerID").equals(testID)) {
            request.setAttribute("message", "you have another test launched");
            request.setAttribute("code", "403");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }
        router.setPage(Path.PAGE_USER_TEST);
        return router;
    }
}
