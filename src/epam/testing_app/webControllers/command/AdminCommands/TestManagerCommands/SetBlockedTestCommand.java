package epam.testing_app.webControllers.command.AdminCommands.TestManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetBlockedTestCommand extends Command {

    private static final long serialVersionUID = -1317137826336105170L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        int testID = Integer.parseInt(request.getParameter("id"));
        String blocked = request.getParameter("isBlocked");
        boolean isBlocked;
        if (blocked.equalsIgnoreCase("true")) {
            isBlocked = true;
            if (!new TestDao().updateTestBlocked(testID, isBlocked)) {
                router.setPage(Path.PAGE_ERROR_PAGE);
                request.setAttribute("message", "cannot change test blocked param");
                request.setAttribute("code", "500");
                return router;
            }
        }
        if (blocked.equalsIgnoreCase("false")) {
            isBlocked = false;
            if (!new TestDao().updateTestBlocked(testID, isBlocked)) {
                router.setPage(Path.PAGE_ERROR_PAGE);
                request.setAttribute("message", "cannot change test blocked param");
                request.setAttribute("code", "500");
                return router;
            }
        }

        if (request.getParameter("questionPage") != null) {
            router.setPage(Path.COMMAND_QA_LIST + testID);
            router.setRedirect();
            return router;
        }

        router.setPage(Path.COMMAND_TEST_LIST);
        router.setRedirect();
        return router;
    }
}

