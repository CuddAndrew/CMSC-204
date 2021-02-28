
public class InvalidNotationFormatException extends Exception {
	public InvalidNotationFormatException() {
		super("Notation format is incorrect");
	}
	public InvalidNotationFormatException(String message) {
		super(message);
	}
}
