import database.DBManager;
import database.Database;
import models.Book;
import models.Catalogue;
import models.Loan;
import models.Member;
import utils.GetPropertyValues;

import java.util.Date;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Main {
    public static void main(String[] args) {
        GetPropertyValues properties = new GetPropertyValues();
        DBManager manager = new DBManager(properties);
        Database db = manager.connection;
        Catalogue catalogue = new Catalogue(db);

        Book b1 = new Book();
        b1.setISBN("ISBN123467");
        b1.setTitle("Title123461");
        catalogue.insert(b1);


        Member m1 = new Member();
        m1.setDni("23878411V");
        m1.setName("Lluís");
        m1.setSurname("Bayer Soler");
        catalogue.insert(m1);

        Loan l1 = new Loan();
        l1.setBook(b1);
        l1.setMember(m1);
        l1.setStartDate(new Date());
        catalogue.insert(l1);

        for (Book test : catalogue.books.books) {
            System.out.println(test.toString());
            System.out.println(test.getISBN());
            System.out.println(test.getTitle());
        }
    }
}
