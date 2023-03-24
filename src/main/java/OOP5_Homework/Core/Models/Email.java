package OOP5_Homework.Core.Models;
import OOP5_Homework.Core.Exception.IncorrectEmailException;

public class Email {
    private String email;

    public Email(String email) throws IncorrectEmailException{
        if (isValid(email)) {
            this.email = email;
        } else {
            throw new IncorrectEmailException();
        }
    }

    private static boolean isValid(String email) {
        return email.contains("@");
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return this.getEmail();
    }
}
