package epam.testing_app.webControllers;

import epam.testing_app.webControllers.command.Command;
import epam.testing_app.webControllers.command.CommandContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  The controller is only one main servlet that receives
 *  and processes all GET and POST requests.
 *
 *  Controller looks for available command in CommandContainer.
 *  After receiving command controller executes it and receives Router object.
 *  Depending on router data controller decides what action
 *  should be performed: redirect or forward.
 *
 * @author V.Dorosh
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = -3246927333131165893L;

//    private static final Logger log = Logger.getLogger(Controller.class);

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    /**
     * Main method of this controller.
     */
    private void process(HttpServletRequest request,
                         HttpServletResponse response) throws IOException, ServletException {

//        log.debug("Controller starts");

        // extract command name from the request
        String commandName = request.getParameter("command");
//        log.trace("Request parameter: command --> " + commandName);

        // obtain command object by its name
        Command command = CommandContainer.get(commandName);
//        log.trace("Obtained command --> " + command);

        // execute command and get forward address
        Router router = command.execute(request, response);
        String routerPage = router.getPage();

        if (router.getType() == Router.Type.FORWARD) {
            RequestDispatcher disp = request.getRequestDispatcher(routerPage);
            disp.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + routerPage);
        }

//        log.trace("Forward address --> " + forward);

//        log.debug("Controller finished, now go to forward address --> " + forward);


    }
}
