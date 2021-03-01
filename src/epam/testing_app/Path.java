package epam.testing_app;

public class Path {

    public static final String CONTEXT_PATH = "myApplication_war";
    // pages
    public static final String PAGE_LOGIN = "/login.jsp";
    public static final String PAGE_REGISTER = "/register.jsp";
    public static final String PAGE_NOTIFICATION = "/notification-page.jsp";
    public static final String PAGE_ADMIN_MAIN = "/admin/admin-main.jsp";
    public static final String PAGE_ADMIN_USER_LIST = "/admin/userManager.jsp";
    public static final String PAGE_ADMIN_USER_FORM_EDIT = "/admin/edit-user-form.jsp";

    public static final String PAGE_ADMIN_SUBJECT_FORM_EDIT = "/admin/edit-subject-form.jsp";
    public static final String PAGE_ADMIN_SUBJECT_LIST = "/admin/subjectManager.jsp";
    public static final String PAGE_MAIN = "/main-menu.jsp";

    public static final String PAGE_ERROR_PAGE = "/WEB-INF/jsp/error_page.jsp";
    public static final String PAGE_ERROR_404 = "/error/error404.jsp";
    public static final String PAGE_LIST_MENU = "/WEB-INF/jsp/client/list_menu.jsp";
    public static final String PAGE_LIST_ORDERS = "/WEB-INF/jsp/admin/list_orders.jsp";
    public static final String PAGE_SETTINGS = "/WEB-INF/jsp/settings.jsp";

    public static final String PAGE_ADMIN_TEST_LIST = "/admin/testManager.jsp";
    public static final String PAGE_ADMIN_TEST_FORM_EDIT = "/admin/edit-test-form.jsp";

    public static final String PAGE_ADMIN_QUESTION_LIST = "/admin/questionManager.jsp";

    //User Pages
    public static final String PAGE_USER_PROFILE = "/user-profile.jsp";
    public static final String PAGE_USER_SUBJECT = "/subject-page.jsp";
    public static final String PAGE_USER_TEST = "/test-page.jsp";



    // commands for admin
    public static final String COMMAND_SHOW_ADMIN_PAGE =  "/controller?command=adminPage";
    public static final String COMMAND_SHOW_MAIN_PAGE =  "/controller?command=showMainPage";
    public static final String COMMAND_USER_LIST =  "/controller?command=userList";
    public static final String COMMAND_SUBJECT_LIST =  "/controller?command=subjectList";
    public static final String COMMAND_TEST_LIST =  "/controller?command=testList";
    public static final String COMMAND_QA_LIST = "/controller?command=QAList&id=";

    // commands for user
    public static final String COMMAND_SHOW_TEST_PAGE =  "/controller?command=testPage&id=";


    //Notification commands
    public static final String NOTIFICATION_REGISTERED = "/controller?command=notificationPass&registered=true";
    public static final String NOTIFICATION_TEST_BLOCKED = "/controller?command=notificationPass&testBlockedNotification=true";
    public static final String NOTIFICATION_TEST_SUBMITTED = "/controller?command=notificationPass&showResultNotification=true";
    public static final String NOTIFICATION_TEST_SUBMITTED_FAIL = "/controller?command=notificationPass&showResultNotificationFail=true";




}
