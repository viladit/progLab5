package Collection;

public class LabWork {
    private long id; //Value must be greater than 0, Value must be unique, Value must be generated automatically
    private String name; //Field can't be null, String can't be empty
    private Coordinates coordinates; //Field can't be null
    private java.util.Date creationDate; //Field can't be null, Value must be generated automatically
    private long minimalPoint; //Value must be greater than 0
    private Difficulty difficulty; //Field can't be null
    private Discipline discipline; //Field can't be null
}
