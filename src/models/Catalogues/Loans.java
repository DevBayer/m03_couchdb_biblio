package models.Catalogues;

import database.Database;
import database.Model;
import interfaces.ICatalogue;
import models.Book;
import models.Loan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Loans implements ICatalogue {
    public List<Loan> loans = new ArrayList<>();
    private String view = "library/loans";
    private Database db;

    public Loans(Database db) {
        this.db = db;
        //loans = db.findAll(Loan.class, view);
    }

    @Override
    public void add(Object obj) {
        loans.add((Loan) obj);
    }

    @Override
    public List get() {
        return db.findAll(Loan.class, Loan._view_all);
    }

    @Override
    public Model get(String key) {
        List<Loan> d = db.findById(Loan.class, Loan._view_key, key);
        if(d.isEmpty()){
            return null;
        }else{
            return d.get(0);
        }
    }
}
