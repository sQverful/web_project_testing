package epam.testing_app.webControllers.command.AdminCommands.SubjectManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteSubjectCommand extends Command {

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        int id = Integer.parseInt(request.getParameter("id"));
        SubjectDao subjectDao = new SubjectDao();
        if (!subjectDao.deleteSubjectById(id)) {
            request.setAttribute("message", "cannot delete such subject");
            request.setAttribute("code", "500");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }
        router.setPage(Path.COMMAND_SUBJECT_LIST);
        router.setRedirect();
        return router;
    }

}
