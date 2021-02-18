package epam.testing_app.webControllers.command.UserManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserCommand extends Command {
    private static final long serialVersionUID = -3031377563906528848L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String blockedStr = request.getParameter("blocked");
        boolean blocked = !(blockedStr.equals(null));
        int roleId = Integer.parseInt(request.getParameter("role_id"));

        User user = User.createUser(login, name, surname, email, password, blocked, roleId);
        user.setId(id);
        new UserDao().updateUser(user);

        return Path.COMMAND_USER_LIST;
    }
}
