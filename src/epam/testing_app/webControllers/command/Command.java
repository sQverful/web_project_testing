package epam.testing_app.webControllers.command;

import epam.testing_app.webControllers.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
/**
 * Main interface for the Command pattern implementation.
 *
 * @author V.Dorosh
 *
 */
public abstract class Command implements Serializable {
    private static final long serialVersionUID = -2207918863187725049L;

    /**
     * Execution method for command.
     * @return Address to go once the command is executed.
     */
    public abstract Router execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException;

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }

}
