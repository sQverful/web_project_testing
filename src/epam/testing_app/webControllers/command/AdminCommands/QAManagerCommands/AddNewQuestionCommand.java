package epam.testing_app.webControllers.command.AdminCommands.QAManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.QuestionDao;
import epam.testing_app.database.entity.Question;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.validator.QADataValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewQuestionCommand extends Command {

    private static final long serialVersionUID = 6725782087719723190L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();

        if (!QADataValidator.isValidQuestionParameters(request)) {
            request.setAttribute("message", "invalid question params");
            request.setAttribute("code", "404");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        int testID = Integer.parseInt(request.getParameter("test_id"));
        String questionUA = request.getParameter("question_ua");
        String questionEN = request.getParameter("question_en");
        Question question = Question.createQuestion(questionUA, questionEN, testID);

        if (!new QuestionDao().insertQuestion(question)) {
            request.setAttribute("message", "cannot insert new question");
            request.setAttribute("code", "500");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        router.setPage(Path.COMMAND_QA_LIST + testID);
        router.setRedirect();
        return router;
    }
}
