import Collection.LabWork;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File("/Users/viladit/IdeaProjects/progLab5/src/data.csv");
        Scanner input = new Scanner(file);
        String[] arrayForSplit = new String[1001];
        String line;

        while (input.hasNextLine()) {
            line = input.nextLine();
            arrayForSplit = line.split(", ");
            System.out.println(Arrays.deepToString(arrayForSplit));
            LabWork lab = new LabWork(arrayForSplit);
            LabWorkHelper.getCollection().add(lab);
            for (LabWork lab1 : LabWorkHelper.getCollection()) {
                System.out.println(lab1.toString());
            }
            System.out.println(LabWorkHelper.getCollection().size());
        }






    }
}