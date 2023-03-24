package OOP5_Homework.UI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import OOP5_Homework.Core.MVP.View;
import OOP5_Homework.Core.Models.Contacts;


public class Console implements View {
    private Scanner input;

    public Console(Scanner input) {
        this.input = input;
    }

    @Override
    public void welcome() {
        System.out.print(Message.welcomeMsg);
    }

    @Override
    public void bye() {
        System.out.println(Message.byeMsg);
    }

    @Override
    public void showMainMenu() {
        System.out.println(Message.chooseActionsMsg);
        for (int i = 1; i < Message.mainMenuEntries.size(); i++) {
            System.out.printf("%d - %s\n", i, Message.mainMenuEntries.get(i));
        }
        System.out.printf("%d - %s\n", 0, Message.mainMenuEntries.get(0));
    }

    @Override
    public int getCmd() {
        return this.getInt();
    }

    @Override
    public void invalidCmd() {
        System.out.println(Message.invalidCmdMsg);
    }

    @Override
    public void showChosenCmd(int cmd) {
        System.out.printf("\n%s\n", Message.mainMenuEntriesMsg.get(cmd));
    }

    @Override
    public String[] addContactMenu() {
        String name = getString(Message.getNameMsg);
        String emailStr = getString(Message.getEmailMsg);
        String phoneNumberStr = getString(Message.getPhoneNumberMsg);
        return new String[] { name, emailStr, phoneNumberStr };
    }

    @Override
    public String[] editContactMenu(Collection<Contacts> contacts) {
        showAllContacts(contacts);
        System.out.println(Message.editContactMsg);
        String name = getString(Message.getNameMsg);
        String emailStr = getString(Message.getEmailMsg);
        String phoneNumberStr = getString(Message.getPhoneNumberMsg);
        return new String[] { name, emailStr, phoneNumberStr };
    }

    @Override
    public String removeContactMenu(Collection<Contacts> contacts) {
        showAllContacts(contacts);
        return getString(Message.getNameMsg);
    }

    @Override
    public void showContact(Contacts contact) {
        System.out.printf("%s - %s\n", Message.ContactFoundMsg, contact);
    }

    @Override
    public void showAllContacts(Collection<Contacts> contacts) {
        System.out.println(Message.showAllContactsMsg);
        List<Contacts> listContacts = new ArrayList<>(contacts);
        Collections.sort(listContacts);
        for (Contacts contact : listContacts) {
            System.out.println(contact);
        }
    }

    @Override
    public void invalidEmail() {
        System.out.println(Message.invalidEmailMsg);
    }

    @Override
    public void invalidPhoneNumber() {
        System.out.println(Message.invalidPhoneNumberMsg);
    }

    @Override
    public void noContactFound() {
        System.out.println(Message.noContactFoundMsg);
    }

    @Override
    public void sucessAddContact() {
        System.out.println(Message.successAddMsg);
    }

    @Override
    public void sucessEditContact() {
        System.out.println(Message.successAddMsg);
    }

    @Override
    public void sucessRemovedContact() {
        System.out.println(Message.successRemovedMsg);
    }

    @Override
    public boolean askAddNewContact() {
        return this.getBoolean(Message.askAddContactMsg);
    }

    @Override
    public String getSearchString() {
        return this.getString(Message.getSearchStrMsg);
    }

    @Override
    public boolean removeContactAccept(Contacts contact) {
        System.out.printf("%s %s", Message.removeContacMsg, contact);
        return getBoolean(Message.askRemoveContactMsg);
    }

    private String getString(String msg) {
        System.out.print(msg);
        return this.input.next();
    }

    private int getInt() {
        while (true) {
            System.out.print(Message.getCommandMsg);
            if (this.input.hasNextInt()) {
                return this.input.nextInt();
            }
            System.out.println(Message.notDigitMsg);
            this.input.next();
        }
    }

    private boolean getBoolean(String msg) {
        System.out.print(msg);
        return this.input.next().equalsIgnoreCase("y");
    }
}
