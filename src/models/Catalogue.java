package models;

import database.Database;
import database.Model;
import models.Catalogues.Books;
import models.Catalogues.Loans;
import models.Catalogues.Members;

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
        if(obj.getClass().equals(Book.class)) {
            /*
            if(books.books.contains(obj)){
                books.books.set(books.books.lastIndexOf(obj), (Book) obj);
            }else{
                books.add(obj);
            }
            */
            //db.update(books);
            db.insert(obj);
        }else if(obj.getClass().equals(Member.class)) {
            /*
            if(members.members.contains(obj)){
                members.members.set(members.members.lastIndexOf(obj), (Member) obj);
            }else{
                members.add(obj);
            }
            */
            //db.update(members);
            db.insert(obj);
        }else if(obj.getClass().equals(Loan.class)) {
            db.insert(obj);
            //if(loans.loans.contains(obj)){
            //    loans.loans.set(loans.loans.lastIndexOf(obj), (Loan) obj);
            //}else{
            //    loans.add(obj);
            //}
            //db.update(loans);
        }
    }

}
