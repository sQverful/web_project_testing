package epam.testing_app.webControllers.command.AdminCommands.TestManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.database.entity.Test;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.validator.TestDataValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewTestCommand extends Command {
    private static final long serialVersionUID = -2847601411107789575L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();

        if (TestDataValidator.isValidTestParameters(request)) {
            request.setAttribute("message", "invalid test params");
            request.setAttribute("code", "404");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        String nameUA = request.getParameter("name_ua");
        String nameEN = request.getParameter("name_en");
        int complexity = Integer.parseInt(request.getParameter("complexity"));
        boolean blocked = false;
        if (request.getParameter("blocked") != null) {
            blocked = true;
        }
        int timer = Integer.parseInt(request.getParameter("timer"));
        String descriptionUA = request.getParameter("description_ua");
        String descriptionEN = request.getParameter("description_en");
        int subjectId = Integer.parseInt(request.getParameter("subject_id"));

        Test test = Test.createTest(nameEN, nameUA, descriptionEN, descriptionUA, subjectId, blocked, complexity, timer);

        if (new TestDao().insertNewTest(test)) {
            request.setAttribute("message", "cannot insert new test");
            request.setAttribute("code", "500");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }
        router.setPage(Path.COMMAND_TEST_LIST);
        router.setRedirect();
        return router;
    }
}
