package epam.testing_app.webControllers;

import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.validator.UserDataValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

    @WebServlet("/userManager")
public class UserManagerServlet extends HttpServlet {
    private static final long serialVersionUID = -1328985194121967490L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processData(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processData(req, resp);
    }

    private void processData(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getServletPath();

        switch (action) {
            case "/addUser":
                addUser(req, resp);
                break;
            case "/deleteUser":
                break;
            case "/updateUser":
                break;
            default:
                try {
                    getUserList(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    private void getUserList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = new UserDao().findAllUsers();
        req.setAttribute("userList", userList);
        RequestDispatcher rd = req.getRequestDispatcher("userManager.jsp");
        rd.forward(req, resp);
    }
    private void addUser(HttpServletRequest req, HttpServletResponse resp) {
        if (!UserDataValidator.isValidUserParameters(req)) {
            return;
        }

        String login = req.getParameter("login");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String blockedStr = req.getParameter("blocked");
        boolean blocked = false;
        if (blockedStr.equalsIgnoreCase("on")) {
            blocked = true;
        }
        int roleId = Integer.parseInt(req.getParameter("role_id"));

        User user = User.createUser(login, name, surname, email, password, blocked, roleId);
        new UserDao().insertUser(user);
    }
}
