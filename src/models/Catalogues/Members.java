package models.Catalogues;

import com.google.gson.annotations.SerializedName;
import database.Database;
import database.Model;
import interfaces.ICatalogue;
import models.Book;
import models.Loan;
import models.Member;
import org.lightcouch.NoDocumentException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Members implements ICatalogue {
    public List<Member> members = new ArrayList<>();
    private String view = "library/members";
    private Database db;


    public Members(Database db) {
        this.db = db;
        //members = db.findAll(Member.class, view);
    }

    @Override
    public void add(Object obj) {
        members.add((Member) obj);
    }

    @Override
    public List get() {
        return db.findAll(Member.class, Member._view_all);
    }

    @Override
    public Model get(String key) {
        List<Member> d =db.findById(Member.class, Member._view_key, key);
        if(d.isEmpty()){
            return null;
        }else{
            return d.get(0);
        }
    }

    public List<Loan> loans(Member m) {
        return db.findById(Loan.class, Loan._view_by_member, m.getDNI());
    }
}
