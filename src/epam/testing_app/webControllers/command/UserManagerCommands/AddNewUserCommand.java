package epam.testing_app.webControllers.command.UserManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.validator.UserDataValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewUserCommand extends Command {
    private static final long serialVersionUID = 4587586284500180711L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!UserDataValidator.isValidUserParameters(request)) {
            return Path.PAGE_ERROR_PAGE;
        }

        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String blockedStr = request.getParameter("blocked");
        boolean blocked = !(blockedStr.equals(null));
        int roleId = Integer.parseInt(request.getParameter("role_id"));

        User user = User.createUser(login, name, surname, email, password, blocked, roleId);
        new UserDao().insertUser(user);

        return new UserListCommand().execute(request, response);
    }
}
