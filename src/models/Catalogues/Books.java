package models.Catalogues;
import database.Database;
import database.Model;
import interfaces.ICatalogue;
import models.Book;
import models.Loan;
import models.Member;

import java.util.*;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Books implements ICatalogue {
    public List<Book> books = new ArrayList<>();
    private String view = "library/books";
    private Database db;

    public Books(Database db) {
        this.db = db;
        //books = db.findAll(Book.class, view);
    }

    @Override
    public void add(Object obj) {
        books.add((Book) obj);
    }

    @Override
    public List get() {
        System.out.println(Book._view_key);
        return db.findAll(Book.class, Book._view_all);
    }

    @Override
    public Model get(String key) {
        List<Book> d = db.findById(Book.class, Book._view_key, key);
        if(d.isEmpty()){
            return null;
        }else{
            return d.get(0);
        }
    }

    public List<Loan> loans(Book b) {
        return db.findById(Loan.class, Loan._view_by_book, b.getISBN());
    }
}
