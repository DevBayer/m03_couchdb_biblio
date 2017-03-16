package models.Catalogues;
import com.google.gson.annotations.SerializedName;
import database.Database;
import database.Model;
import interfaces.ICatalogue;
import models.Book;
import org.lightcouch.NoDocumentException;

import java.util.*;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Books extends Model implements ICatalogue {
    @SerializedName("_id") public String id;
    public List<Book> books = new ArrayList<>();

    public Books(Database db) {
        id = "books";
        try {
            Books d = (Books) db.findById(this);
            books = d.books;
            rev = d.getRev();
        }catch(NoDocumentException e){
            db.insert(this);
        }
    }

    @Override
    public String getPrimaryKey() {
        return "books";
    }


    @Override
    public void add(Object obj) {
        books.add((Book) obj);
    }
}
