package epam.testing_app.webControllers.command.QAManagerCommands;

import epam.testing_app.Path;
import epam.testing_app.database.dao.AnswerDao;
import epam.testing_app.database.dao.QuestionDao;
import epam.testing_app.database.dao.TestDao;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QAListCommand extends Command {

    private static final long serialVersionUID = 2273186620625203863L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("selectedTest", new TestDao().getTestById(id));
        request.setAttribute("questionList", new QuestionDao().findAllQuestionsByTestId(id));
        request.setAttribute("answerList", new AnswerDao().findAllAnswers());

        return Path.PAGE_ADMIN_QUESTION_LIST;
    }
}
