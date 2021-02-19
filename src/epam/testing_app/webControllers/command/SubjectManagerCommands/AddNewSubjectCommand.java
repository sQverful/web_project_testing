package epam.testing_app.webControllers.command.SubjectManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.validator.SubjectDataValidator;
import epam.testing_app.webControllers.validator.UserDataValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddNewSubjectCommand extends Command {

    private static final long serialVersionUID = 3518310435605301366L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!SubjectDataValidator.isValidSubjectParameters(request)) {
            return Path.PAGE_ERROR_PAGE;
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
        subjectDao.insertSubject(subject);

        return Path.COMMAND_SUBJECT_LIST;

    }

}


