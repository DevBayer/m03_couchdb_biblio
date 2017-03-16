package models.Catalogues;

import com.google.gson.annotations.SerializedName;
import database.Database;
import database.Model;
import interfaces.ICatalogue;
import models.Book;
import models.Member;
import org.lightcouch.NoDocumentException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Members extends Model implements ICatalogue {
    @SerializedName("_id") public String id;
    public List<Member> members = new ArrayList<>();

    public Members(Database db) {
        id = "members";
        try {
            Members d = (Members) db.findById(this);
            members = d.members;
            rev = d.getRev();
        }catch(NoDocumentException e){
            db.insert(this);
        }
    }

    @Override
    public String getPrimaryKey() {
        return "members";
    }

    @Override
    public void add(Object obj) {
        members.add((Member) obj);
    }
}
