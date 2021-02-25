package epam.testing_app.webControllers.command.ClientCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowMainPageCommand extends Command {

    private static final long serialVersionUID = 2137612565250624491L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        SubjectDao subjectDao = new SubjectDao();
        List<Subject> subjectList = subjectDao.findAllSubjects();
        List<User> adminDetails = subjectDao.findAllAdminDetails();
        request.setAttribute("subjectList", subjectList);
        request.setAttribute("adminDetails", adminDetails);

        router.setPage(Path.PAGE_MAIN);
        return router;
    }
}
