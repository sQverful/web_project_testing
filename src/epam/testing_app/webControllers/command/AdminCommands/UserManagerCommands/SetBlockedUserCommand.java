package epam.testing_app.webControllers.command.AdminCommands.UserManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetBlockedUserCommand extends Command {

    private static final long serialVersionUID = 1658332255662911629L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        int userID = Integer.parseInt(request.getParameter("id"));
        String blocked = request.getParameter("isBlocked");
        boolean isBlocked;
        if (blocked.equalsIgnoreCase("true")) {
            isBlocked = true;
            if (!new UserDao().updateUserBlocked(userID, isBlocked)) {
                router.setPage(Path.PAGE_ERROR_PAGE);
                request.setAttribute("message", "cannot change user blocked param");
                request.setAttribute("code", "500");
                return router;
            }
        }
        if (blocked.equalsIgnoreCase("false")) {
            isBlocked = false;
            if (!new UserDao().updateUserBlocked(userID, isBlocked)) {
                router.setPage(Path.PAGE_ERROR_PAGE);
                request.setAttribute("message", "cannot change user blocked param");
                request.setAttribute("code", "500");
                return router;
            }
        }
        router.setPage(Path.COMMAND_USER_LIST);
        router.setRedirect();
        return router;
    }
}
