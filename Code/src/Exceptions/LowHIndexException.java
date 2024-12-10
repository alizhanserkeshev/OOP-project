package Exceptions;

public class LowHIndexException extends Exception {
 public LowHIndexException(String message) {
     super(message);
 }

 public LowHIndexException(String message, Throwable cause) {
     super(message, cause);
 }
}
