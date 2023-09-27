package command.utils;

import command.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class CommandHelper {
    static private final HashMap<String, Command> commands = new HashMap<>();
    static private Deque<String> scriptsPath = new ArrayDeque<>();
    static {
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("show", new Show());
        commands.put("add", new Add());
        commands.put("update_id", new UpdateById());
        commands.put("remove_by_id", new RemoveById());
        commands.put("clear", new Clear());
        commands.put("save", new Save());
        commands.put("execute_script", new ExecuteScript());
        commands.put("exit", new Exit());
        commands.put("add_if_max", new AddIfMax());
        commands.put("remove_greater", new RemoveGreater());
        commands.put("remove_lower", new RemoveLower());
        commands.put("average_of_minimal_point", new AverageOfMinimalPoint());
        commands.put("filter_starts_with_name", new FilterStartsWithName());
        commands.put("print_descending", new PrintDescending());
    }

    public static HashMap<String, Command> getCommands() {
        return commands;
    }
    public static Deque<String> getScriptsPath(){
        return scriptsPath;
    }
}