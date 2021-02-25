package epam.testing_app.webControllers.command.AdminCommands.UserManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowUserEditFormCommand extends Command {

    private static final long serialVersionUID = 8915230592171724381L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.getUserById(id);
        if (user == null) {
            request.setAttribute("message", "Cannot find user with such ID");
            request.setAttribute("code", "404");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }
        request.setAttribute("user", user);

        router.setPage(Path.PAGE_ADMIN_USER_FORM_EDIT);
        return router;
    }
}
