package epam.testing_app.webControllers;

import epam.testing_app.Path;
import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.Role;
import epam.testing_app.database.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -8293753485077765575L;

    private void processData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        UserDao userDao = new UserDao();

        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userDao.getUserByLogin(login);

        RequestDispatcher rd;
        response.setCharacterEncoding("UTF-8");

        if (user == null || !password.equals(user.getPassword())) {

            rd = getServletContext().getRequestDispatcher("/login.jsp");
            out.println("<font color=red>Login or password is wrong</font>");
            rd.include(request, response);
        } else {
            Role role = Role.getRole(user);
            session.setAttribute("user", user);
            session.setAttribute("username", user.getLogin());
            session.setAttribute("userID", user.getId());
            session.setAttribute("role", role);
            if (role.getName().equalsIgnoreCase("admin")) {
                response.sendRedirect(request.getContextPath() + Path.PAGE_ADMIN_MAIN);
            } else {
                response.sendRedirect(request.getContextPath() + Path.PAGE_MAIN);
            }
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processData(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processData(req, resp);
    }
}
