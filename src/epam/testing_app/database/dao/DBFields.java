package epam.testing_app.database.dao;

/**
 * Holder for fields names of DB tables and beans.
 *
 * @author V.Dorosh
 *
 */

public class DBFields {

    public static final String ENTITY_ID = "id";

    public static final String USER_LOGIN = "login";
    public static final String USER_NAME = "name";
    public static final String USER_SURNAME = "surname";
    public static final String USER_EMAIL = "email";
    public static final String USER_PASSWORD = "password";
    public static final String USER_CREATE_TIME = "create_time";
    public static final String USER_BLOCKED = "blocked";
    public static final String USER_ROLE_ID = "role_id";
    public static final int USER_ROLE_ADMIN = 1;
    public static final int USER_ROLE_STUDENT = 2;


    public static final String SUBJECT_NAME_UA = "name_ua";
    public static final String SUBJECT_NAME_EN = "name_en";
    public static final String SUBJECT_DESCRIPTION_UA = "description_ua";
    public static final String SUBJECT_DESCRIPTION_EN = "description_en";
    public static final String SUBJECT_ADMIN_ID = "admin_id";
    public static final String SUBJECT_CREATE_TIME = "create_time";

    public static final String TEST_NAME_UA = "name_ua";
    public static final String TEST_NAME_EN = "name_en";
    public static final String TEST_DESCRIPTION_UA = "description_ua";
    public static final String TEST_DESCRIPTION_EN = "description_en";
    public static final String TEST_COMPLEXITY = "complexity";
    public static final String TEST_REQUESTS_QUANTITY = "requests_quantity";
    public static final String TEST_BLOCKED = "blocked";
    public static final String TEST_TIMER = "timer";
    public static final String TEST_SUBJECT_ID = "subject_id";
    public static final String TEST_CREATE_TIME = "create_time";

    public static final String QUESTION_UA = "question_ua";
    public static final String QUESTION_EN = "question_en";
    public static final String QUESTION_TEST_ID = "test_id";

    public static final String ANSWER_UA = "answer_ua";
    public static final String ANSWER_EN = "answer_en";
    public static final String ANSWER_CORRECT = "correct";
    public static final String ANSWER_QUESTION_ID = "question_id";

    public static final String TEST_RESULT_RESULT = "result";
    public static final String TEST_RESULT_USER_ID = "user_id";
    public static final String TEST_RESULT_TEST_ID = "test_id";
    public static final String TEST_RESULT_CREATE_TIME = "create_time";



}
