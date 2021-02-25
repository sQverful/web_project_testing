package epam.testing_app.webControllers.command.QAManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.AnswerDao;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAnswerCommand extends Command {
    private static final long serialVersionUID = -7031082598851224519L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();

        int id = Integer.parseInt(request.getParameter("answer_id"));
        if (!new AnswerDao().deleteAnswerById(id)) {
            request.setAttribute("message", "cannot delete such answer");
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
