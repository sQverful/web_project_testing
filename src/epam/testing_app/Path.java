package epam.testing_app;

public class Path {

    // pages
    public static final String PAGE_LOGIN = "/login.jsp";
    public static final String PAGE_ADMIN_MAIN = "/admin/admin-main.jsp";
    public static final String PAGE_ADMIN_USER_LIST = "/admin/userManager.jsp";
    public static final String PAGE_ADMIN_USER_FORM_EDIT = "/admin/edit-user-form.jsp";

    public static final String PAGE_ADMIN_SUBJECT_FORM_EDIT = "/admin/edit-subject-form.jsp";
    public static final String PAGE_ADMIN_SUBJECT_LIST = "/admin/subjectManager.jsp";
    public static final String PAGE_MAIN = "/main.jsp";
    public static final String PAGE_ERROR_PAGE = "/WEB-INF/jsp/error_page.jsp";
    public static final String PAGE_LIST_MENU = "/WEB-INF/jsp/client/list_menu.jsp";
    public static final String PAGE_LIST_ORDERS = "/WEB-INF/jsp/admin/list_orders.jsp";
    public static final String PAGE_SETTINGS = "/WEB-INF/jsp/settings.jsp";

    public static final String PAGE_ADMIN_TEST_LIST = "/admin/testManager.jsp";
    public static final String PAGE_ADMIN_TEST_FORM_EDIT = "/admin/edit-test-form.jsp";

    public static final String PAGE_ADMIN_QUESTION_LIST = "/admin/questionManager.jsp";
    // commands
    public static final String COMMAND_USER_LIST = "/controller?command=userList";
    public static final String COMMAND_SUBJECT_LIST = "/controller?command=subjectList";
    public static final String COMMAND_TEST_LIST = "/controller?command=testList";
    public static final String COMMAND_QA_LIST = "/controller?command=QAList&id=";

}
