package epam.testing_app.webControllers.command;

import epam.testing_app.webControllers.command.UserManagerCommands.*;

import java.util.Map;
import java.util.TreeMap;

public class CommandContainer {

//    private static final Logger log = Logger.getLogger(CommandContainer.class);

    private static Map<String, Command> commands = new TreeMap<>();

    static {
        // common commands
        commands.put("login", new LoginCommand());
     //   commands.put("logout", new LogoutCommand());
        commands.put("noCommand", new NoCommand());
        commands.put("addNewUser", new AddNewUserCommand());
        commands.put("deleteUser", new DeleteUserCommand());
        commands.put("showEditForm", new ShowEditFormCommand());
        commands.put("updateUser", new UpdateUserCommand());
        //   commands.put("updateSettings", new UpdateSettingsCommand());

     //   // client commands
        commands.put("userList", new UserListCommand());

     //   // admin commands
     //   commands.put("listOrders", new ListOrdersCommand());

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
