package epam.testing_app.webControllers.command.ClientCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.database.dao.TestResultsDao;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.database.entity.Test;
import epam.testing_app.database.entity.TestResult;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserProfileCommand extends Command {
    private static final long serialVersionUID = 9130465065197396020L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();

        User currentUser = (User) request.getSession().getAttribute("user");
        List<TestResult> testResultList = new TestResultsDao().finaAllTestResultsByUserID(currentUser.getId());
        List<Subject> subjectList = new SubjectDao().findAllSubjects();
        List<Test> testsList = new TestDao().findAllTests();

        request.setAttribute("testResultList", testResultList);
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("testsList", testsList);

        router.setPage(Path.PAGE_USER_PROFILE);
        return router;
    }
}
