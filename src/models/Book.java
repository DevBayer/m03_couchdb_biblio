package models;

import com.google.gson.annotations.SerializedName;
import database.Model;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Book extends Model {
    @SerializedName("_id") String ISBN;
    String Author;
    String Editorial;
    String Title;
    String Category;
    int EditionYear;

    @Override
    public String getPrimaryKey() {
        return ISBN;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        ISBN = primaryKey;
    }

    public Book() {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getEditionYear() {
        return EditionYear;
    }

    public void setEditionYear(int editionYear) {
        EditionYear = editionYear;
    }
}
