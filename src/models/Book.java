package models;

import database.Model;

import java.util.List;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Book extends Model {
    transient static public String _view_all = "library/books";
    transient static public String _view_key = "library/book";
    String ISBN;
    String Author;
    String Editorial;
    String Title;
    String Category;
    int EditionYear;

    public Book() {
        this._view_all = "library/books";
        this._view_key = "library/book";
        this.Type = "Book";
    }

    @Override
    public String getKey() {
        return ISBN;
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
