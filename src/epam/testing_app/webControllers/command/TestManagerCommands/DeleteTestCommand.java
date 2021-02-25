package epam.testing_app.webControllers.command.TestManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTestCommand extends Command {
    private static final long serialVersionUID = -3089726117068377576L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        int id = Integer.parseInt(request.getParameter("id"));
        if (!new TestDao().deleteTestById(id)) {
            request.setAttribute("message", "cannot delete such subject");
            request.setAttribute("code", "500");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }
        request.setAttribute("isCommandExecuted", true);
        router.setPage(Path.COMMAND_TEST_LIST);
        router.setRedirect();
        return router;
    }
}
