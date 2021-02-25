package epam.testing_app.webControllers.command.UserManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.Role;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserListCommand extends Command {
    private static final long serialVersionUID = -1652184806021602282L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        List<User> userList = new UserDao().findAllUsers();
        request.setAttribute("userList", userList);

        router.setPage(Path.PAGE_ADMIN_USER_LIST);
        return router;
    }
}
