package main;

public class NoUpperAlphaException extends RuntimeException {
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
	public NoUpperAlphaException(String message) {
		super(message);
	}
}
