package epam.testing_app.webControllers.command.TestManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ShowTestEditFormCommand extends Command {
    private static final long serialVersionUID = -4799926291510803266L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        SubjectDao subjectDao = new SubjectDao();
        TestDao testDao = new TestDao();
        request.setAttribute("test", testDao.getTestById(id));
        request.setAttribute("subjectList", subjectDao.findAllSubjects());
        return Path.PAGE_ADMIN_TEST_FORM_EDIT;
    }
}

