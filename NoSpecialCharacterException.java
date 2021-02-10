package main;

public class NoSpecialCharacterException extends RuntimeException {
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
	public NoSpecialCharacterException(String message) {
		super(message);
	}
}
