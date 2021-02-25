package epam.testing_app.webControllers.command.AdminCommands.QAManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.AnswerDao;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetAnswerCorrectCommand extends Command {

    private static final long serialVersionUID = -559374341102477783L;

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Router router = new Router();

        int testID = Integer.parseInt(request.getParameter("test_id"));
        int answerId = Integer.parseInt(request.getParameter("answer_id"));
        String correct = request.getParameter("correct");
        boolean isCorrect;
        if (correct.equalsIgnoreCase("true")) {
            isCorrect = true;
            if (!new AnswerDao().updateAnswerCorrect(answerId, isCorrect)) {
                router.setPage(Path.PAGE_ERROR_PAGE);
                request.setAttribute("message", "cannot change answer correct param");
                request.setAttribute("code", "500");
                return router;
            }
        }

        if (correct.equalsIgnoreCase("false")) {
            isCorrect = false;
            if (!new AnswerDao().updateAnswerCorrect(answerId, isCorrect)) {
                router.setPage(Path.PAGE_ERROR_PAGE);
                request.setAttribute("message", "cannot change answer correct param");
                request.setAttribute("code", "500");
                return router;
            }
        }

        router.setPage(Path.COMMAND_QA_LIST + testID);
        router.setRedirect();
        return router;
    }

}
