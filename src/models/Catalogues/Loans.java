package models.Catalogues;

import database.Database;
import interfaces.ICatalogue;
import models.Loan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Loans implements ICatalogue {
    public List<Loan> loans = new ArrayList<>();

    public Loans(Database db) {
        loans = db.findAll(Loan.class);
        for (Loan b : loans) {
            System.out.println("ASSD -> "+b.getBook().getTitle());
            System.out.println(b.getPrimaryKey());
        }
    }

    @Override
    public void add(Object obj) {
        loans.add((Loan) obj);
    }
}
