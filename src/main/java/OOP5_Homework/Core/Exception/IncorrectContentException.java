package OOP5_Homework.Core.Exception;

public class IncorrectContentException extends RuntimeException{
    public IncorrectContentException() {
        super("Founded incorrect content, cannot load Phonebook");
    }
}
