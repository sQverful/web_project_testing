package epam.testing_app.webControllers.command.UserManagerCommands;

import epam.testing_app.database.dao.UserDao;
import epam.testing_app.database.entity.User;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditUserCommand extends Command {

    private static final long serialVersionUID = -4413893149992352011L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        User userToEdit = userDao.getUserById(id);
        RequestDispatcher rd = request.getRequestDispatcher("userManager.jsp");
        request.setAttribute("userToEdit", userToEdit);
        return null;
    }

}
