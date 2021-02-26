package epam.testing_app.webControllers.command.ClientCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.database.entity.Test;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestPageCommand extends Command {

    private static final long serialVersionUID = 1774410822314899007L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();
        int testID = Integer.parseInt(request.getParameter("id"));
        Test test = new TestDao().getTestById(testID);
        if (test == null) {
            request.setAttribute("message", "Such test do not exists");
            request.setAttribute("code", "404");
            router.setPage(Path.PAGE_ERROR_PAGE);
            return router;
        }
        request.setAttribute("selectedTest", test);
        request.setAttribute("selectedSubject", new SubjectDao().getSubjectById(test.getSubjectId()));

        router.setPage(Path.PAGE_USER_TEST);
        return router;
    }
}
