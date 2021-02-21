package epam.testing_app.webControllers.command.TestManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.database.entity.Test;
import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.validator.TestDataValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewTestCommand extends Command {
    private static final long serialVersionUID = -2847601411107789575L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (TestDataValidator.isValidTestParameters(request)) {
            return Path.PAGE_ERROR_PAGE;
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

        new TestDao().insertNewTest(test);
        return Path.COMMAND_TEST_LIST;
    }
}
