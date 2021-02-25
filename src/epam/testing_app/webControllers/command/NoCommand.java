package epam.testing_app.webControllers.command;

import epam.testing_app.Path;
import epam.testing_app.webControllers.Router;
import javafx.scene.transform.Rotate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * When command from request is not determined than this command is called.
 * Forwards to the error404 page.
 *
 */

public class NoCommand extends Command {

    private static final long serialVersionUID = 154168766068260071L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        String errorMessage = "No such command";
        request.setAttribute("errorMessage", errorMessage);
        request.setAttribute("message", "Sorry, the page you’re looking for cannot be accessed.\n" +
                "Either check the URL");
        request.setAttribute("code", "404");


        router.setPage(Path.PAGE_ERROR_404);
        return router;
    }
}
