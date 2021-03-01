package epam.testing_app.webControllers.filter;

import epam.testing_app.Path;
import epam.testing_app.database.entity.Role;
import epam.testing_app.webControllers.Router;
import epam.testing_app.webControllers.command.Command;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * The CommandAccessFilter is a security filter that
 * limits access to the commands.
 *
 * You can unable/disable this filter in web.xml by commenting filter.
 *
 */
public class CommandAccessFilter implements Filter {

    private static final long serialVersionUID = -3470228188120859356L;
    // commands access
    private static Map<Role, List<String>> accessMap = new HashMap<>();
    private static List<String> commons = new ArrayList<>();
    private static List<String> outOfControl = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        //roles
        accessMap.put(Role.ADMIN, asList(filterConfig.getInitParameter("admin")));
        accessMap.put(Role.STUDENT, asList(filterConfig.getInitParameter("client")));

        commons = asList(filterConfig.getInitParameter("common"));

        outOfControl = asList(filterConfig.getInitParameter("out-of-control"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (accessAllowed(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String message = "You do not have permission to access the requested resource";
            String code = "404";

            servletRequest.setAttribute("message", message);
            servletRequest.setAttribute("code", "401");

            servletRequest.getRequestDispatcher(Path.PAGE_ERROR_PAGE)
                    .forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        // do nothing
    }

    private boolean accessAllowed(ServletRequest request) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String commandName = request.getParameter("command");
        if (commandName == null || commandName.isEmpty())
            return false;

        if (outOfControl.contains(commandName))
            return true;

        HttpSession session = httpRequest.getSession(false);
        if (session == null)
            return false;

        Role userRole = (Role)session.getAttribute("userRole");
        if (userRole == null)
            return false;

        return accessMap.get(userRole).contains(commandName) || commons.contains(commandName);
    }

    /**
     * Extracts parameter values from string.
     *
     * @param str
     *            parameter values string.
     * @return list of parameter values.
     */
    private List<String> asList(String str) {
        List<String> list = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) list.add(st.nextToken());
        return list;
    }
}
