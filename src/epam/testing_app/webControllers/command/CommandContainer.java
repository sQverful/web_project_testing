package epam.testing_app.webControllers.command;

import epam.testing_app.database.entity.Question;
import epam.testing_app.database.entity.Test;
import epam.testing_app.webControllers.command.ClientCommands.ShowMainPageCommand;
import epam.testing_app.webControllers.command.QAManagerCommands.*;
import epam.testing_app.webControllers.command.SubjectManagerCommands.*;
import epam.testing_app.webControllers.command.TestManagerCommands.*;
import epam.testing_app.webControllers.command.UserManagerCommands.*;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {

//    private static final Logger log = Logger.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new TreeMap<>();

    static {
        // common commands
        commands.put("login", new LoginCommand());
        commands.put("registerPage", new RegisterPageCommand());
        commands.put("register", new RegisterCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("noCommand", new NoCommand());
        commands.put("notificationPass", new NotificationPassCommand());
        commands.put("showMainPage", new ShowMainPageCommand());


        //ADMIN ROLE COMMANDS BELOW
        commands.put("adminPage", new ShowAdminPageCommand());
        //User commands
        commands.put("addNewUser", new AddNewUserCommand());
        commands.put("deleteUser", new DeleteUserCommand());
        commands.put("showUserEditForm", new ShowUserEditFormCommand());
        commands.put("updateUser", new UpdateUserCommand());
        commands.put("userList", new UserListCommand());
        commands.put("setBlockedUser", new SetBlockedUserCommand());

//        Subject commands
        commands.put("subjectList", new SubjectListCommand());
        commands.put("deleteSubject", new DeleteSubjectCommand());
        commands.put("addNewSubject", new AddNewSubjectCommand());
        commands.put("showSubjectEditForm", new ShowSubjectEditFormCommand());
        commands.put("updateSubject", new UpdateSubjectCommand());

//        Test commands
        commands.put("testList", new TestListCommand());
        commands.put("addNewTest", new AddNewTestCommand());
        commands.put("showTestEditForm", new ShowTestEditFormCommand());
        commands.put("updateTest", new UpdateTestCommand());
        commands.put("deleteTest", new DeleteTestCommand());

//        Question commands
        commands.put("QAList", new QAListCommand());
        commands.put("addNewQuestion", new AddNewQuestionCommand());
        commands.put("addNewAnswer", new AddNewAnswerCommand());
        commands.put("deleteQuestion", new DeleteQuestionCommand());
        commands.put("deleteAnswer", new DeleteAnswerCommand());
        commands.put("setAnswerCorrect", new SetAnswerCorrectCommand());

        //   // admin commands

//        log.debug("Command container was successfully initialized");
//        log.trace("Number of commands --> " + commands.size());
    }

    /**
     * Returns command object with the given name.
     *
     * @param commandName
     *            Name of the command.
     * @return Command object.
     */
    public static Command get(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
//            log.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }

}
