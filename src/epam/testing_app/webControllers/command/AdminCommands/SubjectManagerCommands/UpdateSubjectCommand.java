package epam.testing_app.webControllers.command.AdminCommands.SubjectManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.validator.SubjectDataValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateSubjectCommand extends Command {
    private static final long serialVersionUID = -3168296939177779340L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        if (!SubjectDataValidator.isValidSubjectParameters(request)) {
            request.setAttribute("message", "invalid user params");
            request.setAttribute("code", "404");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }
        HttpSession session = request.getSession();
        User adminUser = (User) session.getAttribute("user");

        int id = Integer.parseInt(request.getParameter("id"));
        String nameUA = request.getParameter("name_ua");
        String nameEN = request.getParameter("name_en");
        String descUA = request.getParameter("description_ua");
        String descEN = request.getParameter("description_en");

        Subject subjectToUpdate = Subject.createSubject(nameEN, nameUA, descEN, descUA, adminUser.getId());
        subjectToUpdate.setId(id);

        if (!new SubjectDao().updateSubject(subjectToUpdate)) {
            request.setAttribute("message", "cannot update subject");
            request.setAttribute("code", "500");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        router.setPage(Path.COMMAND_SUBJECT_LIST);
        router.setRedirect();
        return router;
    }
}
