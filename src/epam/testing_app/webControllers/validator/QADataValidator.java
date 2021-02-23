package epam.testing_app.webControllers.validator;

import epam.testing_app.database.dao.DBFields;

import javax.servlet.http.HttpServletRequest;

public class QADataValidator {

    private QADataValidator() {
    }

    private static final String ANY_DIGIT_REGEX = "[0-9]+";

    /**
     * Validates question parameters
     *
     * @return the boolean
     */

    public static boolean isValidQuestionParameters(HttpServletRequest request) {
        boolean isValid = true;

        if (request.getParameter(DBFields.QUESTION_EN).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.QUESTION_UA).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.QUESTION_TEST_ID).isEmpty()) {
            return false;
        }

        return isValid;
    }


    /**
     * Validates answer parameters
     *
     * @return the boolean
     */
    public static boolean isValidAnswerParameters(HttpServletRequest request) {
        boolean isValid = true;
        if (request.getParameter(DBFields.ANSWER_EN).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.ANSWER_UA).isEmpty()) {
            return false;
        }
        if (request.getParameter(DBFields.ANSWER_QUESTION_ID).isEmpty()) {
            return false;
        }

        return isValid;
    }
}
