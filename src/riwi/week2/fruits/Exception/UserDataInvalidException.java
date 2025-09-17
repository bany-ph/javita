package riwi.week2.fruits.Exception;

public class UserDataInvalidException extends RuntimeException {

    public UserDataInvalidException(String message) {
        super(message);
    }

    public UserDataInvalidException(String message,Throwable cause){super(message,cause);}
}
