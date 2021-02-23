package epam.testing_app.webControllers.command.QAManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.QuestionDao;
import epam.testing_app.database.entity.Question;
import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.validator.QADataValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewQuestionCommand extends Command {

    private static final long serialVersionUID = 6725782087719723190L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!QADataValidator.isValidQuestionParameters(request)) {
            return Path.PAGE_ERROR_PAGE;
        }

        int testID = Integer.parseInt(request.getParameter("test_id"));
        String questionUA = request.getParameter("question_ua");
        String questionEN = request.getParameter("question_en");
        Question question = Question.createQuestion(questionUA, questionEN, testID);
        new QuestionDao().insertQuestion(question);

        String forward = Path.COMMAND_QA_LIST + testID;

        return forward;
    }
}
