package command;

import Collection.LabWork;
import Collection.utils.LabWorkHelper;
import command.utils.Command;
import input.InputManager;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Command to save collection to file.
 */
public class Save extends Command {
    @Override
    public String execute() {

        if (InputManager.getIsCommandArgument()) {
            System.out.println("У команды не должно быть аргумента!");
        } else {
            try (FileOutputStream out = new FileOutputStream("/Users/viladit/IdeaProjects/progLab5/src/data.csv")) {
                BufferedOutputStream bos = new BufferedOutputStream(out);
                for (LabWork labWork : LabWorkHelper.getCollection()) {
                    // example of output:  "Lab-1, 1, 1.0, 6, HARD, OPD"
                    String labWorkStr = labWork.getName() + ", " + labWork.getCoordinates().getX() + ", " + labWork.getCoordinates().getY() + ", " + labWork.getMinimalPoint() + ", " + labWork.getDifficulty() + ", " + labWork.getDiscipline().getName();
                    System.out.println(labWorkStr);
                    byte[] buffer = labWorkStr.getBytes();
                    bos.write(buffer, 0, buffer.length);
                    bos.write('\n');
                    bos.flush();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return "Коллекция сохранена в файл Saved_data.txt";
        }
        return "";
    }
}
