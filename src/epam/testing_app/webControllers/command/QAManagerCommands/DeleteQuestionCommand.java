package epam.testing_app.webControllers.command.QAManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.QuestionDao;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteQuestionCommand extends Command {

    private static final long serialVersionUID = -1343407326222617797L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("question_id"));
        new QuestionDao().deleteQuestionById(id);


        String testID = request.getParameter("test_id");
        String forward = Path.COMMAND_QA_LIST + testID;

        return forward;
    }
}
