package Collection;

import javax.swing.text.LabelView;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.MissingFormatArgumentException;
import java.util.Random;
import java.util.TreeSet;

public class LabWork implements Comparable<LabWork>{
    private long id; //Value must be greater than 0, Value must be unique, Value must be generated automatically
    private String name; //Field can't be null, String can't be empty
    private Coordinates coordinates; //Field can't be null
    private java.util.Date creationDate; //Field can't be null, Value must be generated automatically
    private long minimalPoint; //Value must be greater than 0
    private Difficulty difficulty; //Field can't be null
    private Discipline discipline; //Field can be null

    public LabWork(String[] arrayForCollection) {
        Random randomID = new Random();
        id = Math.abs(randomID.nextInt());
        name = arrayForCollection[0];
        coordinates = new Coordinates(Double.parseDouble(arrayForCollection[1]), Double.parseDouble(arrayForCollection[2]));
        creationDate = new Date();
        if (isFieldEmpty(arrayForCollection[3])) {
            SimpleDateFormat df = new SimpleDateFormat("dd.mm.yyyy");
            creationDate = df.parse(arrayForCollection[3], new ParsePosition(0));
        }
        minimalPoint = Long.parseLong(arrayForCollection[4]);
        if (isFieldEmpty(arrayForCollection[5])) {
            difficulty = Difficulty.valueOf(arrayForCollection[5]);
        }
        if (isFieldEmpty(arrayForCollection[6])) {
            discipline = new Discipline(arrayForCollection[6]);
        } else {
            discipline = new Discipline(null);
        }
    }

        public boolean isFieldEmpty(String argument) {
            if (argument.equals("")) return false;
            else return true;
        }

        public long getID() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Coordinates getCoordinates() {
            return coordinates;
        }

        public Date getCreationDate() {
            return creationDate;
        }

        public long getMinimalPoint() {
            return minimalPoint;
        }

        public Difficulty getDifficulty() {
            return difficulty;
        }

        public Discipline getDiscipline() {
            return discipline;
        }
    @Override
    public int compareTo(LabWork lab) {
        if (this.minimalPoint == lab.minimalPoint) {
            return -1;
        } else if (this.minimalPoint < lab.minimalPoint) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        String toStringResult;
        toStringResult = "ID: " + id + " | Name: " + name + " | Coordinates: X = " + coordinates.getX() + "; Y = " + coordinates.getY() +
                " | Date: " + creationDate + " | Min. point: " + minimalPoint + " | Difficulty: " + difficulty;
        if (discipline != null) {
            toStringResult += " | Discipline: " + discipline.getName();
        }
        return toStringResult;
    }
}
