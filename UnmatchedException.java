package main;

public class UnmatchedException extends RuntimeException {
	public UnmatchedException() {
		super("The passwords do not match");
	}
	public UnmatchedException(String message) {
		super(message);
	}
}
