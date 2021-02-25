package epam.testing_app.webControllers.command.SubjectManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SubjectListCommand extends Command {

    private static final long serialVersionUID = -8077399498255448282L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        List<Subject> subjectList = new SubjectDao().findAllSubjects();
        request.setAttribute("subjectList", subjectList);
        router.setPage(Path.PAGE_ADMIN_SUBJECT_LIST);
        return router;
    }

}
