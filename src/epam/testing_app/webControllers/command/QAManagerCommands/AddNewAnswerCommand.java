package epam.testing_app.webControllers.command.QAManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.AnswerDao;
import epam.testing_app.database.entity.Answer;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.validator.QADataValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewAnswerCommand extends Command {
    private static final long serialVersionUID = -39541269029891741L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        if (!QADataValidator.isValidAnswerParameters(request)) {
            request.setAttribute("message", "invalid answer params");
            request.setAttribute("code", "404");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        String answerUA = request.getParameter("answer_ua");
        String answerEN = request.getParameter("answer_en");
        boolean correct = false;
        if (request.getParameter("correct") != null) {
            correct = true;
        }
        int questionId = Integer.parseInt(request.getParameter("question_id"));
        Answer answer = Answer.createAnswer(answerEN, answerUA, correct, questionId);

        if (!new AnswerDao().insertAnswer(answer)) {
            request.setAttribute("message", "cannot insert new answer");
            request.setAttribute("code", "500");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }


        String testID = request.getParameter("test_id");
        router.setPage(Path.COMMAND_QA_LIST + testID);
        router.setRedirect();
        return router;
    }
}
