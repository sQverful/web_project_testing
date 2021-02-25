package epam.testing_app.webControllers;

import epam.testing_app.Path;

/**
 * The Router used in commands and controller to store the path
 * and transition types (FORWARD or REDIRECT)
 *
 * @author V.Dorosh
 */
public class Router {

    enum Type {
        FORWARD,
        REDIRECT
    }

    private Type type = Type.FORWARD;
    private String currentPage = Path.PAGE_LOGIN;

    public Router() {
    }

    public Router(String currentPage) {
        this.currentPage = currentPage;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setRedirect() {
        this.type = Type.REDIRECT;
    }

    public void setForward() {
        this.type = Type.FORWARD;
    }

    public String getPage() {
        return currentPage;
    }

    public void setPage(String page) {
        this.currentPage = page;
    }

    public static void main(String[] args) {
    }
}
