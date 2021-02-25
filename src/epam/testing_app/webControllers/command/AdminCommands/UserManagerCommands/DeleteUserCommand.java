package epam.testing_app.webControllers.command.AdminCommands.UserManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserCommand extends Command {

    private static final long serialVersionUID = 3407501015079008069L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();

        if (!userDao.deleteUserById(id)) {
            request.setAttribute("message", "cannot delete such user");
            request.setAttribute("code", "500");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        router.setPage(Path.COMMAND_USER_LIST);
        router.setRedirect();
        return router;
    }

}
