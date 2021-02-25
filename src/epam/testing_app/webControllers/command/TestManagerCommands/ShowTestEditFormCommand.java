package epam.testing_app.webControllers.command.TestManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.database.entity.Test;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowTestEditFormCommand extends Command {
    private static final long serialVersionUID = -4799926291510803266L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Router router = new Router();
        int id = Integer.parseInt(request.getParameter("id"));
        SubjectDao subjectDao = new SubjectDao();
        TestDao testDao = new TestDao();
        Test test = testDao.getTestById(id);
        if (test == null) {
            request.setAttribute("message", "Cannot find test with such ID");
            request.setAttribute("code", "404");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        request.setAttribute("test", test);
        request.setAttribute("subjectList", subjectDao.findAllSubjects());

        router.setPage(Path.PAGE_ADMIN_TEST_FORM_EDIT);
        return router;
    }
}

