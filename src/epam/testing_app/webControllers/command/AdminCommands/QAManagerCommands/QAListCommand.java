package epam.testing_app.webControllers.command.AdminCommands.QAManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.AnswerDao;
import epam.testing_app.database.dao.QuestionDao;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.database.entity.Test;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QAListCommand extends Command {

    private static final long serialVersionUID = 2273186620625203863L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();

        int testID = Integer.parseInt(request.getParameter("id"));
        TestDao testDao = new TestDao();
        Test selectedTest = testDao.getTestById(testID);
        if (selectedTest == null) {
            request.setAttribute("message", "cannot find test with such ID");
            request.setAttribute("code", "404");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        request.setAttribute("selectedTest", selectedTest);
        request.setAttribute("questionList", new QuestionDao().findAllQuestionsByTestId(testID));
        request.setAttribute("answerList", new AnswerDao().findAllAnswers());

        router.setPage(Path.PAGE_ADMIN_QUESTION_LIST);
        return router;
    }
}
