package Exceptions;

public class ImposterException extends Exception {
	 public ImposterException(String message) {
	     super(message);
	 }

	 public ImposterException(String message, Throwable cause) {
	     super(message, cause);
	 }
	}
