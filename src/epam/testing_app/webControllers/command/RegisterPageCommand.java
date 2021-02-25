package epam.testing_app.webControllers.command;

import epam.testing_app.Path;
import epam.testing_app.webControllers.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterPageCommand extends Command {

    private static final long serialVersionUID = 1668050553772125566L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        router.setPage(Path.PAGE_REGISTER);
        return router;
    }
}
