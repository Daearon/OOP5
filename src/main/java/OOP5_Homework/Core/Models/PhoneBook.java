package OOP5_Homework.Core.Models;
import java.util.Map;

public interface PhoneBook {
    void create(Contacts contact);

    Map<String,Contacts> readAll();

    void modify(Contacts contact);

    void delete(String name);

    Contacts search(String name);
}

