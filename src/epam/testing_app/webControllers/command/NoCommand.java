package epam.testing_app.webControllers.command;

import epam.testing_app.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCommand extends Command {

    private static final long serialVersionUID = 154168766068260071L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String errorMessage = "No such command";
        request.setAttribute("errorMessage", errorMessage);

        return Path.PAGE_ERROR_PAGE;
    }
}
