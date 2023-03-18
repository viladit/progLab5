public abstract class Command implements CommandInterface {
    public String name;
    public String argument;

    public abstract void execute() throws Exception;

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
