package epam.testing_app.webControllers.command.QAManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.AnswerDao;
import epam.testing_app.database.entity.Answer;
import epam.testing_app.database.entity.Question;
import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.validator.QADataValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewAnswerCommand extends Command {
    private static final long serialVersionUID = -39541269029891741L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!QADataValidator.isValidAnswerParameters(request)) {
            return Path.PAGE_ERROR_PAGE;
        }

        String answerUA = request.getParameter("answer_ua");
        String answerEN = request.getParameter("answer_en");
        boolean correct = false;
        if (request.getParameter("correct") != null) {
            correct = true;
        }
        int questionId = Integer.parseInt(request.getParameter("question_id"));
        Answer answer = Answer.createAnswer(answerEN, answerUA, correct, questionId);
        new AnswerDao().insertAnswer(answer);


        String testID = request.getParameter("test_id");
        String forward = Path.COMMAND_QA_LIST + testID;

        return forward;
    }
}
