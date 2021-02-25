package epam.testing_app.webControllers.validator;

import epam.testing_app.database.dao.DBFields;

import javax.servlet.http.HttpServletRequest;

public class UserDataValidator {

    private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";

    private UserDataValidator() {
    }

    /**
     * Validates user parameters
     *
     * @return the boolean
     */

    public static boolean isValidUserParameters(HttpServletRequest request) {
        boolean isValid = true;

        if (request.getParameter(DBFields.USER_LOGIN).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.USER_NAME).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.USER_SURNAME).isEmpty()) {
            return false;
        }
        if (isValidEmail(request.getParameter(DBFields.USER_EMAIL))) {
            return false;
        }
        if (request.getParameter(DBFields.USER_PASSWORD).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.USER_ROLE_ID).isEmpty()) {
            return false;
        }
        return isValid;
    }

    private static boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

}
