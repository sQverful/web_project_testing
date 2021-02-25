package epam.testing_app.webControllers.command.AdminCommands.SubjectManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowSubjectEditFormCommand extends Command {


    private static final long serialVersionUID = 8341519942866377854L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        int id = Integer.parseInt(request.getParameter("id"));
        Subject subjectToEdit = new SubjectDao().getSubjectById(id);
        if (subjectToEdit == null) {
            request.setAttribute("message", "cannot find subject with such id");
            request.setAttribute("code", "404");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }
        request.setAttribute("subject", subjectToEdit);
        router.setPage(Path.PAGE_ADMIN_SUBJECT_FORM_EDIT);
        return router;
    }
}
