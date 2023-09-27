package command.utils;

import Collection.Difficulty;


public class CheckCommand {
    public static boolean checkName(String argument) {
        if (argument.equals("")) {
            System.out.println("Значение не должно быть пустым!");
            return false;
        }
        return true;
    }

    public static boolean checkValueX(String argument) {
        if (argument.equals("")) {
            System.out.println("Значение не должно быть пустым!");
            return false;
        }
        try {
            Long longNum = Long.parseLong(argument);
        } catch (NumberFormatException e) {
            System.out.println("Значение должно быть в типе данных Long");
            return false;
        }
        if (Long.parseLong(argument) <= -1000) {
            System.out.println("Значение должно быть больше, чем -1000");
            return false;
        } else return true;
    }

    public static boolean checkValueY(String argument) {
        if (argument.equals("")) {
            System.out.println("Значение не должно быть пустым!");
            return false;
        }
        try {
            Float floatNum = Float.parseFloat(argument);
        } catch (NumberFormatException e) {
            System.out.println("Значение должно быть в типе данных Float");
            return false;
        }
        if (Float.parseFloat(argument) <= -512) {
            System.out.println("Значение должно быть больше, чем -512");
            return false;
        } else return true;
    }

    public static boolean checkMinimalPoint(String argument) {
        if (argument.equals("")) {
            System.out.println("Значение не должно быть пустым!");
            return false;
        }
        try {
            Long longNum = Long.parseLong(argument);
        } catch (NumberFormatException e) {
            System.out.println("Значение должно быть в типе данных Long");
            return false;
        }
        if (Long.parseLong(argument) <= 5 || Long.parseLong(argument) > 20) {
            System.out.println("Значение должно быть в границах [6; 20]");
            return false;
        } else return true;
    }

    public static boolean checkDifficulty(String argument) {
        if (argument.equals("")) return true;
        try {
            Difficulty.valueOf(argument);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Сложность должна соответствовать одному из значение: HARD, VERY_HARD, IMPOSSIBLE, INSANE, HOPELESS");
            return false;
        }
    }

    public static boolean checkDiscipline(String argument) {
        return true;
    }


}
