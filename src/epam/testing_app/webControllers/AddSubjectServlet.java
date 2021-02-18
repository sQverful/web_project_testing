package epam.testing_app.webControllers;

import epam.testing_app.Path;
import epam.testing_app.database.dao.SubjectDao;
import epam.testing_app.database.entity.Role;
import epam.testing_app.database.entity.Subject;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.validator.SubjectDataValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addSubject")
public class AddSubjectServlet extends HttpServlet {

    private static final long serialVersionUID = -6101935406502866020L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processData(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processData(req, resp);
    }

    private void processData(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        User user = (User) session.getAttribute("user");

        if (Role.getRole(user) != Role.ADMIN) {
            resp.sendRedirect(req.getContextPath() + Path.PAGE_MAIN);
        }

        if (!SubjectDataValidator.isValidSubjectParameters(req)) {
            out.print("Error: input data is not valid!");
            return;
        }

        Subject subject = new Subject();
        SubjectDao subjectDao = new SubjectDao();

        subject.setAdminId(user.getId());
        subject.setDescriptionUA(req.getParameter("description_ua"));
        subject.setDescriptionEN(req.getParameter("description_en"));
        subject.setNameUA(req.getParameter("name_ua"));
        subject.setNameEN(req.getParameter("name_en"));

        if (subjectDao.insertSubject(subject)) {
            out.print("<div class=\"card text-white bg-success card-box\">" +
                    "<div class=\"card-header\">Success</div></div>");
        } else {
            out.print("<div class=\"card text-white bg-warning card-box\">" +
                    "<div class=\"card-header\">Failed</div></div>");
        }


    }
}
