package epam.testing_app.webControllers.command;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.Role;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand extends Command {

    private static final long serialVersionUID = -7938064765536176850L;

//    private static final Logger log = Logger.getLogger(LoginCommand.class);

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
//        log.debug("Command starts");

        HttpSession session = request.getSession();

        //obtain login and pass from the request
        String login = request.getParameter("login");
//        log.trace("Request parameter: loging --> " + login);

        String password = request.getParameter("password");

        //error handler
        String errorMessage = null;
        router.setPage(Path.PAGE_ERROR_PAGE);

        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            errorMessage = "Login/password cannot be empty";
            request.setAttribute("errorMassage", errorMessage);
//            log.error("errorMessage --> " + errorMessage);
            return router;
        }

        User user = new UserDao().getUserByLogin(login);
//        log.trace("Found in DB: user -->" + user);


        if (user == null || !password.equals(user.getPassword())) {
            errorMessage = "Cannot find user with such login/password";
            request.setAttribute("errorMessage", errorMessage);
//            log.error("errorMessage --> " + errorMessage);
            return router;
        } else {
            Role userRole = Role.getRole(user);
//            log.trace("userRole --> " + userRole);

            if (userRole == Role.ADMIN) {
                router.setRedirect();
                router.setPage(Path.COMMAND_SHOW_ADMIN_PAGE);
            }

            if (userRole == Role.STUDENT) {
                router.setRedirect();
                router.setPage(Path.COMMAND_SHOW_MAIN_PAGE);
            }

            session.setAttribute("user", user);
//            log.trace("Set the session attribute: user --> " + user);

            session.setAttribute("userRole", userRole);
//            log.trace("Set the session attribute: userRole --> " + userRole);

//            log.info("User " + user + " logged as " + userRole.toString().toLowerCase());
            //TODO: work with Locale

        }

//        log.debug("Command finished");
        return router;
    }
}
