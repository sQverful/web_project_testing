package epam.testing_app.webControllers.command.SubjectManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowSubjectEditFormCommand extends Command {


    private static final long serialVersionUID = 8341519942866377854L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Subject subjectToEdit = new SubjectDao().getSubjectById(id);
        request.setAttribute("subject", subjectToEdit);
        return Path.PAGE_ADMIN_SUBJECT_FORM_EDIT;
    }
}
