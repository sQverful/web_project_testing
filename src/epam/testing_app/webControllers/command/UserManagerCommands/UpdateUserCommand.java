package epam.testing_app.webControllers.command.UserManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserCommand extends Command {
    private static final long serialVersionUID = -3031377563906528848L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean blocked = false;
        if (request.getParameter("blocked") != null) {
            blocked = true;
        }
        int roleId = Integer.parseInt(request.getParameter("role_id"));

        User user = User.createUser(login, name, surname, email, password, blocked, roleId);
        user.setId(id);

        if (!new UserDao().updateUser(user)) {
            request.setAttribute("message", "cannot update user");
            request.setAttribute("code", "500");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        router.setPage(Path.COMMAND_USER_LIST);
        router.setRedirect();
        return router;
    }
}
