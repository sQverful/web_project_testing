package epam.testing_app.webControllers.command.UserManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowUserEditFormCommand extends Command {

    private static final long serialVersionUID = 8915230592171724381L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", new UserDao().getUserById(id));

        return Path.PAGE_ADMIN_USER_FORM_EDIT;
    }
}
