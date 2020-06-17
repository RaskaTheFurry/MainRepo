package competition.utils;

/**
 * Vlastní výjimka
 * @author janvit
 */
public class IllegalFilenameException extends IllegalArgumentException {

    public IllegalFilenameException(String message) {
        super(message);
    }
    
}
