package OOP5_Homework.UI;

import java.util.Scanner;

import OOP5_Homework.Core.DB.ExternalContacts;
import OOP5_Homework.Core.DB.ExternalData;
import OOP5_Homework.Core.MVP.Model;
import OOP5_Homework.Core.MVP.Presenter;
import OOP5_Homework.Core.MVP.View;
import OOP5_Homework.Core.Models.PhoneBook;
import OOP5_Homework.Core.Models.PhoneBookMap;

public class Application {
    public static void Run() {
        Scanner scan = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBookMap();
        ExternalData db = new ExternalContacts(phoneBook, "db.csv");
        Model model = new Model(phoneBook, db);
        View view = new Console(scan);
        Presenter presenter = new Presenter(model, view);

        presenter.load();
        presenter.mainMenu();
        presenter.save();

        scan.close();
    }
}
