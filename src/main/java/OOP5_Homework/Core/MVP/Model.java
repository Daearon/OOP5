package OOP5_Homework.Core.MVP;
import OOP5_Homework.Core.DB.ExternalData;
import OOP5_Homework.Core.Models.PhoneBook;

public class Model {
    private PhoneBook phoneBook;
    private ExternalData db;

    public Model(PhoneBook phoneBook, ExternalData db) {
        this.phoneBook = phoneBook;
        this.db = db;
    }

    public PhoneBook getPhoneBook() {
        return this.phoneBook;
    }

    public void load() {
        this.phoneBook = db.load();
    }

    public void save() {
        db.save(this.phoneBook);
    }
}

