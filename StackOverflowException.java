
public class StackOverflowException extends Exception {
	public StackOverflowException() {
		super("The stack is empty");
	}
	public StackOverflowException(String message) {
		super(message);
	}
}
