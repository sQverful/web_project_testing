package epam.testing_app.webControllers.validator;

import epam.testing_app.database.dao.DBFields;

import javax.servlet.http.HttpServletRequest;

public class TestDataValidator {

    private static final String DIGITS_REGEX_COMPLEXITY = "[0-9]{0,2}|100"; // validates from 0 to 100
    private static final String DIGITS_REGEX_TIMER = "[0-9]{0,3}"; // validates from 0 to 999

    private TestDataValidator() {
    }

    /**
     * Validates test parameters
     *
     * @return the boolean
     */

    public static boolean isValidTestParameters(HttpServletRequest request) {
        boolean isValid = true;

        if (request.getParameter(DBFields.TEST_COMPLEXITY).isEmpty() || request.getParameter(DBFields.TEST_COMPLEXITY).matches(DIGITS_REGEX_COMPLEXITY)) {
            return false;
        }
        if (request.getParameter(DBFields.TEST_TIMER).isEmpty() || request.getParameter(DBFields.TEST_TIMER).matches(DIGITS_REGEX_TIMER)) {
            return false;
        }
        if (request.getParameter(DBFields.TEST_SUBJECT_ID).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.TEST_DESCRIPTION_UA).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.TEST_DESCRIPTION_EN).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.TEST_NAME_EN).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.TEST_NAME_UA).isEmpty()) {
            return false;
        }
        return isValid;
    }
}
