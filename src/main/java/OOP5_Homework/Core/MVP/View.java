package OOP5_Homework.Core.MVP;
import java.util.Collection;
import OOP5_Homework.Core.Models.Contacts;

public interface View {

    void welcome();

    void bye();

    void showMainMenu();

    int getCmd();

    void invalidCmd();

    void showChosenCmd(int cmd);

    String[] addContactMenu();

    String[] editContactMenu(Collection<Contacts> contacts);

    String removeContactMenu(Collection<Contacts> contacts);

    void showContact(Contacts contact);

    void showAllContacts(Collection<Contacts> contacts);

    void invalidEmail();

    void invalidPhoneNumber();

    void noContactFound();

    void successAddContact();

    void successEditContact();

    void successRemovedContact();

    boolean askAddNewContact();

    String getSearchString();

    boolean removeContactAccept(Contacts contact);
}

