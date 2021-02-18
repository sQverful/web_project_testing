package epam.testing_app.webControllers.validator;

import epam.testing_app.database.DBManager;
import epam.testing_app.database.dao.DBFields;

import javax.servlet.http.HttpServletRequest;

public class SubjectDataValidator {

    private SubjectDataValidator() {
    }

    /**
     * Validates subject parameters
     *
     * @return the boolean
     */

    public static boolean isValidSubjectParameters(HttpServletRequest request) {
        boolean isValid = true;

        if (request.getParameter(DBFields.SUBJECT_DESCRIPTION_UA).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.SUBJECT_DESCRIPTION_EN).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.SUBJECT_NAME_UA).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.SUBJECT_NAME_EN).isEmpty()) {
            return false;
        }
        return isValid;
    }

}

