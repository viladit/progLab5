package command.utils;

public abstract class Command implements CommandInterface {
    public String name;
    public String argument;
    private String description;

    public abstract String execute();

    public void setArgument(String argument) {
        this.argument = argument;
    }
    public String getName() {
        return name;
    }
    public String getDescription(){
        return description;
    }
}
