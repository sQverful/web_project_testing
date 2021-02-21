package epam.testing_app.webControllers.command.TestManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.database.entity.Test;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TestListCommand extends Command {

    private static final long serialVersionUID = -2289414468742201954L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Test> testList = new TestDao().findAllTests();
        List<Subject> subjectList = new SubjectDao().findAllSubjects();
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("testList", testList);
        String forward = Path.PAGE_ADMIN_TEST_LIST;
        return forward;
    }
}
