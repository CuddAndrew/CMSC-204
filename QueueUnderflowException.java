
public class QueueUnderflowException extends Exception {
	public QueueUnderflowException() {
		super("Queue is full");
	}
	public QueueUnderflowException(String message) {
		super(message);
	}
}
