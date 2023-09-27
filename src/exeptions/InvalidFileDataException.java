package exeptions;

public class InvalidFileDataException extends Exception{
    public InvalidFileDataException (String path, String message) {
        super("! invalid file data in " + path + ": " + message + " !");
    }
}
