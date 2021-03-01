package epam.testing_app.webControllers.command;

import epam.testing_app.Path;
import epam.testing_app.database.dao.TestResultsDao;
import epam.testing_app.database.entity.TestResult;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NotificationPassCommand extends Command {

    private static final long serialVersionUID = -6559218235661566235L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();

        if (request.getParameter("registered") != null) {
            request.setAttribute("registrationSuccess", true);
        }

        if (request.getParameter("showResultNotification") != null && request.getParameter("testResult") != null) {
            request.setAttribute("showResultNotification", true);
            int testResultID = Integer.parseInt(request.getParameter("testResult"));
            TestResult testResult = new TestResultsDao().getTestResultByID(testResultID);
            User currentUser = (User) request.getSession().getAttribute("user");
            if (currentUser.getId() != testResult.getUserId()) {
                request.setAttribute("message", "permission error");
                request.setAttribute("code", "404");
                router.setPage(Path.PAGE_ERROR_PAGE);
                return router;
            }
            request.setAttribute("testResult", testResult);
        }

        if (request.getParameter("showResultNotificationFail") != null && request.getParameter("testResult") != null) {
            request.setAttribute("showResultNotificationFail", true);
            int testResultID = Integer.parseInt(request.getParameter("testResult"));
            TestResult testResult = new TestResultsDao().getTestResultByID(testResultID);
            User currentUser = (User) request.getSession().getAttribute("user");
            if (currentUser.getId() != testResult.getUserId()) {
                request.setAttribute("message", "permission error");
                request.setAttribute("code", "404");
                router.setPage(Path.PAGE_ERROR_PAGE);
                return router;
            }
            request.setAttribute("testResult", testResult);
        }

        router.setPage(Path.PAGE_NOTIFICATION);
        return router;
    }
}
