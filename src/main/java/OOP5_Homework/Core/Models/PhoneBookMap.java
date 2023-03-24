package OOP5_Homework.Core.Models;
import java.util.HashMap;
import java.util.Map;

public class PhoneBookMap implements PhoneBook {
    private Map<String,Contacts> contacts;

    public PhoneBookMap(Map<String,Contacts> contacts) {
        this.contacts = contacts;
    }

    public PhoneBookMap() {
        this.contacts = new HashMap<>();
    }

    private Map<String,Contacts> getContacts() {
        return this.contacts;
    }

    private void setContact(Contacts contact) {
        try {
            this.contacts.put(contact.getName(), contact);
        } catch (UnsupportedOperationException | NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void create(Contacts contact) {
        this.setContact(contact);
    }

    @Override
    public Contacts read(String name) {
        if (this.getContacts().containsKey(name)) {
            return this.getContacts().get(name);
        }
        return null;
    }

    @Override
    public Map<String, Contacts> readAll() {
        return this.getContacts();
    }

    @Override
    public void modify(Contacts contact) {
        this.setContact(contact);
    }

    @Override
    public void delete(String name) {
        try {
            this.contacts.remove(name);
        } catch (UnsupportedOperationException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Contacts search(String name) {
        return this.getContacts().get(name);
    }
}
