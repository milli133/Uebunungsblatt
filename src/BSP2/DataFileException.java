package BSP2;

public class DataFileException extends Exception {
    public DataFileException(String message, Throwable cause) {
        super("DATA FILE ERROR!", cause);
    }
}
