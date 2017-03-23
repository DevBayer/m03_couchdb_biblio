package models;

import database.Model;

import java.util.Date;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Loan extends Model {
    Book book;
    Member member;
    Date StartDate;
    Boolean delivered;
    transient static public String _view_all = "library/loans";
    transient static public String _view_key = "library/loan";
    transient static public String _view_by_book = "library/loan_by_isbn";
    transient static public String _view_by_member = "library/loan_by_dni";

    public Loan() {
        this._view_all = "library/loans";
        this._view_key = "library/book";
        this.Type = "Loan";
    }

    public String getKeyBook() {
        return book.getKey();
    }

    public String getKeyMember() {
        return member.getKey();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }
}
