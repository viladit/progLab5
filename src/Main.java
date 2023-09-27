import Collection.LabWork;
import Collection.utils.LabWorkHelper;
import input.InputManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Main is class for reading collection from file.
 */
public class Main {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("Введите название файла в формате .csv, из которого взять данные для коллекции");
        Scanner scanner = new Scanner(System.in);
        File file = new File(scanner.nextLine());
        try {
            Scanner input = new Scanner(file);
            String[] arrayForSplit = new String[1001];
            String line;
            while (input.hasNextLine()) {
                line = input.nextLine();
                arrayForSplit = line.split(", ");
                LabWork lab = new LabWork(arrayForSplit);
                LabWorkHelper.getCollection().add(lab);
            }
            System.out.println("Коллекция успешно заполнена из файла.");
        }catch (FileNotFoundException e) {
            System.out.println("Файл не найден или нет на него прав!");
        }

        while (InputManager.isWorking) {
            InputManager.inputMode();
        }






    }
}