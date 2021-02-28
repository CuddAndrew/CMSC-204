
public class StackUnderflowException extends Exception {
	public StackUnderflowException() {
		super("Stack is full");
	}
	public StackUnderflowException(String message) {
		super(message);
	}
}
