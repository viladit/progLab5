package Collection;

public class Discipline {
    private String name; //Field can't be null, String can't be empty
    private long labsCount;

    public Discipline (String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
