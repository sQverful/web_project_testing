package epam.testing_app.webControllers.command.ClientCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.validator.UpdateRegisterInfoValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateRegisterInfo extends Command {
    private static final long serialVersionUID = 5340455255999361930L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        HttpSession session = request.getSession();
        if (!UpdateRegisterInfoValidator.isValidRegisterInfoParameters(request)) {
            router.setPage(Path.NOTIFICATION_UPDATE_REGISTER_FAIL);
            router.setRedirect();
            return router;
        }

        User currentUser = (User) session.getAttribute("user");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // userForUpdate obj used for update operation and for replacing `user` attribute in current session
        User userForUpdate = User.createUser(currentUser.getLogin(), name, surname, email, password, currentUser.isBlocked(), currentUser.getRoleId());
        userForUpdate.setId(currentUser.getId());
        userForUpdate.setCreateTime(currentUser.getCreateTime());

        if (!new UserDao().updateUser(userForUpdate)) {
            router.setPage(Path.PAGE_ERROR_PAGE);
            request.setAttribute("message", "cannot update this user");
            request.setAttribute("code", "500");
        }

        router.setPage(Path.NOTIFICATION_UPDATE_REGISTER_SUCCESS);
        router.setRedirect();
        session.setAttribute("user", userForUpdate);
        return router;
    }
}

