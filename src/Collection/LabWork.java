package Collection;

import javax.swing.text.LabelView;
import java.text.*;
import java.util.*;

public class LabWork implements Comparable<LabWork>{
    private long id; //Value must be greater than 0, Value must be unique, Value must be generated automatically
    private String name; //Field can't be null, String can't be empty
    private Coordinates coordinates; //Field can't be null
    private java.util.Date creationDate; //Field can't be null, Value must be generated automatically
    private long minimalPoint; //Value must be greater than 0
    private Difficulty difficulty; //Field can't be null
    private Discipline discipline; //Field can be null
    public static final Set<Long> IDs = new LinkedHashSet<>();

    public LabWork(String[] arrayForCollection) {
        Long randomID = 0l;
        while (true) {
            randomID = generateID();
            if (checkIfIDUnique(randomID)) {
                saveId(randomID);
                break;
            }
        }
        id = randomID;
        name = arrayForCollection[0];
        coordinates = new Coordinates(Long.parseLong(arrayForCollection[1]), Float.parseFloat(arrayForCollection[2]));
        creationDate = new Date();

        minimalPoint = Long.parseLong(arrayForCollection[3]);
        if (isFieldEmpty(arrayForCollection[4])) {
            difficulty = Difficulty.valueOf(arrayForCollection[4]);
        }
        if (isFieldEmpty(arrayForCollection[5])) {
            discipline = new Discipline(arrayForCollection[5]);

        } else {
            discipline = new Discipline(null);
        }
    }
        public boolean isFieldEmpty(String argument) {
            if (argument.equals("")) return false;
            else return true;
        }
        public long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Coordinates getCoordinates() {
            return coordinates;
        }
        public void setCoordinates (Coordinates coordinates) {
            this.coordinates = coordinates;
        }
        public Date getCreationDate() {
            return creationDate;
        }
        public void setCreationDate(Date creationDate) {
            this.creationDate = creationDate;
        }
        public long getMinimalPoint() {
            return minimalPoint;
        }
        public void setMinimalPoint(Long minimalPoint) {
            this.minimalPoint = minimalPoint;
        }
        public Difficulty getDifficulty() {
            return difficulty;
        }
        public void setDifficulty(Difficulty difficulty) {
            this.difficulty = difficulty;
        }
        public Discipline getDiscipline() {
            return discipline;
        }
        public void setDiscipline(Discipline discipline) {
            this.discipline = discipline;
        }
    public static void saveId(long id) {
        IDs.add(id);
    }

    public static void removeId(long id) {
        IDs.remove(id);
    }

    public static void removeAllIds() {
        IDs.clear();
    }

    public static boolean checkIfIDUnique(long id) {
        return !IDs.contains(id);
    }

    public static long generateID() {
        Random rand = new Random();
        int upperbound = 999999;
        int int_random = rand.nextInt(upperbound);
        return int_random;
    }
    @Override
    public int compareTo(LabWork lab) {
        if (this.minimalPoint == lab.minimalPoint) {
            return 0;
        } else if (this.minimalPoint < lab.minimalPoint) {
            return -1;
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
