package epam.testing_app.webControllers.command.ClientCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.database.entity.Test;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SubjectPageCommand extends Command {
    private static final long serialVersionUID = 771109701539831502L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();

        int subjectID = Integer.parseInt(request.getParameter("id"));
        Subject selectedSubject = new SubjectDao().getSubjectById(subjectID);
        if (selectedSubject == null) {
            router.setPage(Path.PAGE_ERROR_PAGE);
            request.setAttribute("message", "unfortunately such subject don't exists");
            request.setAttribute("code", "404");
            return router;
        }
        request.setAttribute("selectedSubject", selectedSubject);

        List<Test> testList = new TestDao().findAllTestsBySubjectID(subjectID);
        if (testList.isEmpty()) {
            request.setAttribute("subjectHasTest", false);
        }

        request.setAttribute("subjectHasTest", true);
        request.setAttribute("testList", testList);

        //Admin data
        User adminDetails = new UserDao().getUserById(selectedSubject.getAdminId());
        request.setAttribute("adminDetails", adminDetails);

        router.setPage(Path.PAGE_USER_SUBJECT);
        return router;
    }
}
