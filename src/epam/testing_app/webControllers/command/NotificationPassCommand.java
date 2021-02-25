package epam.testing_app.webControllers.command;

import epam.testing_app.Path;
import epam.testing_app.webControllers.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NotificationPassCommand extends Command {

    private static final long serialVersionUID = -6559218235661566235L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();

        if (request.getParameter("registered") != null) {
            request.setAttribute("registrationSuccess", true);
        }

        router.setPage(Path.PAGE_NOTIFICATION);
        return router;
    }
}
