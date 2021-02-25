package epam.testing_app.webControllers.command.AdminCommands.UserManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.validator.UserDataValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewUserCommand extends Command {
    private static final long serialVersionUID = 4587586284500180711L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        if (!UserDataValidator.isValidUserParameters(request)) {
            request.setAttribute("message", "invalid parameters");
            request.setAttribute("code", "404");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

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
        UserDao userDao = new UserDao();
        if (userDao.getUserByLogin(login) != null) {
            request.setAttribute("registrationIncorrectLogin", true);
            router.setPage(Path.COMMAND_USER_LIST);
            router.setRedirect();
            return router;
        }
        if (!userDao.insertUser(user)) {
            request.setAttribute("message", "cannot insert user");
            request.setAttribute("code", "500");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        router.setPage(Path.COMMAND_USER_LIST);
        router.setRedirect();
        return router;
    }
}
