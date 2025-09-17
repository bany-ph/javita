package practice.hospital.exceptions;

public class UserDataInvalidException extends RuntimeException {


    public UserDataInvalidException(String message) {
        super(message);
    }

    public UserDataInvalidException() {
        super("Se debe seleccionar/ingresar un valor");
    }
}
