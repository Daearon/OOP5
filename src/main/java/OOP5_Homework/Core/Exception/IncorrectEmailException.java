package OOP5_Homework.Core.Exception;

public class IncorrectEmailException extends RuntimeException{
    public IncorrectEmailException() {
        super("Entered incorrect email address");
    }
}
