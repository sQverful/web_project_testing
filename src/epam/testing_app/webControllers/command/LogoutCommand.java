package epam.testing_app.webControllers.command;

import epam.testing_app.Path;
import epam.testing_app.webControllers.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutCommand extends Command {

    private static final long serialVersionUID = 7004311575799138598L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        router.setRedirect();
        return router;
    }
}
