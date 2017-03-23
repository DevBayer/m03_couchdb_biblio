package models;

import database.Database;
import database.Model;
import models.Catalogues.Books;
import models.Catalogues.Loans;
import models.Catalogues.Members;
import org.lightcouch.DocumentConflictException;

import java.util.List;


/**
 * Created by 23878410v on 09/03/17.
 */
public class Catalogue {
    public Books books;
    public Loans loans;
    public Members members;
    public Database db;

    public Catalogue(Database db) {
        this.db = db;
        books = new Books(db);
        loans = new Loans(db);
        members = new Members(db);
    }

    public void insert(Object obj){
        try {
            if (obj.getClass().equals(Book.class) || obj.getClass().equals(Member.class)) {
                if(db.count(obj) == 0) {
                    db.insert(obj);
                }
            } else if (obj.getClass().equals(Loan.class)) {
                db.insert(obj);
            }
        }catch(DocumentConflictException e){
            System.out.println(e.getMessage());
        }
    }

    public Model get(Class<? extends Model> cls, String key){
        if(cls.equals(Book.class)){
            return books.get(key);
        }else if(cls.equals(Member.class)){
            return members.get(key);
        }
        return null;
    }

}
