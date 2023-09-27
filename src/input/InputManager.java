package input;

import command.utils.Command;
import command.utils.CommandHelper;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputManager {

    private static String commandArgument;
    public static boolean isWorking = true;
    static boolean isCommandArgument = false;
    public static void inputMode(){
        HashMap<String, Command> commandList;
        commandList = CommandHelper.getCommands();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the command: ");
        String commandLine = "" ;
        try {
            commandLine = scanner.nextLine().trim();
        } catch (NoSuchElementException e) {
            System.out.println("Завершение программы.");
            System.exit(0);
        }
        String[] input = commandLine.split(" ");
        while (input.length == 0 || input.length > 2) {
            System.out.println("Wrong command!");
            System.out.println("Enter the command: ");
            commandLine = scanner.nextLine().trim();
            input = commandLine.split(" ");
        }
        String command = input[0];
        isCommandArgument = false;
        try {
            if (input.length == 2) {
                commandArgument = input[1].trim();
                isCommandArgument = true;
                commandList.get(command).setArgument(commandArgument);
            }
            System.out.println(commandList.get(command).execute());
        }catch (NullPointerException e) {
            System.out.println("Wrong command!");
        }

    }
    public static String getCommandArgument(){
        return commandArgument;
    }
    public static boolean getIsCommandArgument(){
        return isCommandArgument;
    }
    public static void setCommandArgument(String newCommandArgument){
        commandArgument = newCommandArgument;
    }
    public static boolean getIsWorking(){
        return isWorking;
    }
    public static void setIsWorking(boolean status){
        isWorking = status;
    }
    public static void setIsCommandArgument(boolean status){
        isCommandArgument = status;
    }
}
