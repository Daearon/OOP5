package OOP5_Homework.Core.MVP;
import java.util.Collection;

import OOP5_Homework.Core.Exception.IncorrectEmailException;
import OOP5_Homework.Core.Models.Contacts;
import OOP5_Homework.Core.Models.Email;
import OOP5_Homework.Core.Models.PhoneNumber;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void load() {
        model.load();
    }

    public void save() {
        model.save();
    }

    public void mainMenu() {
        view.welcome();
        while (true) {
            view.showMainMenu();
            int cmd = view.getCmd();
            view.showChosenCmd(cmd);
            switch (cmd) {
                case 0:
                    return;
                case 1:
                    String[] newContactArr = view.addContactMenu();
                    addContact(newContactArr);
                    break;
                case 2:
                    Collection<Contacts> contacts = this.model.getPhoneBook().readAll().values();
                    String[] editContactArr = view.editContactMenu(contacts);
                    editContact(editContactArr);
                    break;
                case 3:
                    contacts = this.model.getPhoneBook().readAll().values();
                    String contactToRemove = view.removeContactMenu(contacts);
                    removeContact(contactToRemove);
                    break;
                case 4:
                    readAllContacts();
                    break;
                case 5:
                    String searchStr = view.getSearchString();
                    readContact(searchStr);
                    break;
                default:
                    view.invalidCmd();
            }
        }
    }

    private Contacts makeContact(String[] data) {
        String name = data[0];
        try {
            Email email = new Email(data[1]);
            PhoneNumber phoneNumber = new PhoneNumber(data[2]);
            return new Contacts(name, email, phoneNumber);
        } catch (NumberFormatException e) {
            view.invalidPhoneNumber();
        } catch (IncorrectEmailException e) {
            view.invalidEmail();
        }
        return null;
    }

    private void addContact(String[] data) {
        Contacts contact = makeContact(data);
        if (contact != null) {
            this.model.getPhoneBook().create(contact);
            view.successAddContact();
        }
    }

    private void editContact(String[] data) {
        String name = data[0];
        if (!this.model.getPhoneBook().readAll().containsKey(name)) {
            if (view.askAddNewContact()) {
                addContact(data);
            }
            return;
        }
        Contacts contact = makeContact(data);
        this.model.getPhoneBook().modify(contact);
        view.successEditContact();
    }

    private void removeContact(String name) {
        Contacts contact = this.model.getPhoneBook().search(name);
        if (contact == null) {
            view.noContactFound();
            return;
        }
        if (view.removeContactAccept(contact)) {
            this.model.getPhoneBook().delete(name);
            view.successRemovedContact();
        }
    }

    private void readContact(String searchStr) {
        Contacts contact = this.model.getPhoneBook().search(searchStr);
        if (contact == null) {
            view.noContactFound();
        } else {
            view.showContact(contact);
        }
    }

    private void readAllContacts() {
        view.showAllContacts(this.model.getPhoneBook().readAll().values());
    }
}
