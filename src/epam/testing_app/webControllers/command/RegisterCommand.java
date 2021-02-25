package epam.testing_app.webControllers.command;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.validator.UserDataValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterCommand extends Command {

    private static final long serialVersionUID = -514977755281738806L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();

        if (!UserDataValidator.isValidUserParameters(request)) {
            request.setAttribute("invalidInput", true);
            router.setPage(Path.PAGE_REGISTER);
            return router;
        }

        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean blocked = false;
        int roleID = Integer.parseInt(request.getParameter("role_id"));

        User user = User.createUser(login, name, surname, email, password, blocked, roleID);

        UserDao userDao = new UserDao();
        if (userDao.getUserByLogin(login) != null) {
            request.setAttribute("registrationIncorrectLogin", true);
            router.setPage(Path.PAGE_REGISTER);
            return router;
        }

        userDao.insertUser(user);
        request.setAttribute("registrationSuccess", true);
        router.setPage(Path.PAGE_NOTIFICATION);
        return router;
    }
}
