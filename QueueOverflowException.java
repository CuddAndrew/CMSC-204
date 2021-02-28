
public class QueueOverflowException extends Exception {
	public QueueOverflowException() {
		super("Queue is empty");
	}
	public QueueOverflowException(String message) {
		super(message);
	}
}
