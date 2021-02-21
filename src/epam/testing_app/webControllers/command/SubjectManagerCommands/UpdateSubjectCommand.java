package epam.testing_app.webControllers.command.SubjectManagerCommands;

import com.mysql.cj.Session;
import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.database.entity.User;
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
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!SubjectDataValidator.isValidSubjectParameters(request)) {
            return Path.PAGE_ERROR_PAGE;
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
        new SubjectDao().updateSubject(subjectToUpdate);
        return Path.COMMAND_SUBJECT_LIST;
    }
}
