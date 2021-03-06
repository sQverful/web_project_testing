package epam.testing_app.webControllers.command.AdminCommands;

import epam.testing_app.Path;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowAdminPageCommand extends Command {
    private static final long serialVersionUID = 2301284053697638542L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        router.setPage(Path.PAGE_ADMIN_MAIN);
        return router;
    }
}
