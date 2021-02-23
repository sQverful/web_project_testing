package epam.testing_app.webControllers.command.QAManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.AnswerDao;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetAnswerCorrectCommand extends Command {

    private static final long serialVersionUID = -559374341102477783L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int testID = Integer.parseInt(request.getParameter("test_id"));

        int answerId = Integer.parseInt(request.getParameter("answer_id"));
        String correct = request.getParameter("correct");
        boolean isCorrect;
        if (correct.equalsIgnoreCase("true")) {
            isCorrect = true;
            new AnswerDao().updateAnswerCorrect(answerId, isCorrect);
        }
        if (correct.equalsIgnoreCase("false")) {
            isCorrect = false;
            new AnswerDao().updateAnswerCorrect(answerId, isCorrect);
        }
        return Path.COMMAND_QA_LIST + testID;
    }

}
