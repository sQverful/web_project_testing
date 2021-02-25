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

public class AddNewSubjectCommand extends Command {

    private static final long serialVersionUID = 3518310435605301366L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        if (!SubjectDataValidator.isValidSubjectParameters(request)) {
            request.setAttribute("code", "404");
            request.setAttribute("message", "invalid subject params!");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        HttpSession session = request.getSession();

        User adminUser = (User) session.getAttribute("user");

        Subject subject = new Subject();
        SubjectDao subjectDao = new SubjectDao();

        subject.setAdminId(adminUser.getId());
        subject.setDescriptionUA(request.getParameter("description_ua"));
        subject.setDescriptionEN(request.getParameter("description_en"));
        subject.setNameUA(request.getParameter("name_ua"));
        subject.setNameEN(request.getParameter("name_en"));
        if (!subjectDao.insertSubject(subject)) {
            request.setAttribute("message", "cannot insert new subject");
            request.setAttribute("code", "500");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }

        router.setPage(Path.COMMAND_SUBJECT_LIST);
        router.setRedirect();

        return router;

    }

}


