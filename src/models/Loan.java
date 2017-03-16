package models;

import com.google.gson.annotations.SerializedName;
import database.Model;

import java.util.Date;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Loan extends Model {
    @SerializedName("_id") String id;
    Book book;
    Member member;
    Date StartDate;
    Boolean delivered;

    public Loan() {
    }

    @Override
    public String getPrimaryKey() {
        return id;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        id = primaryKey;
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
