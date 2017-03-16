package models;

import com.google.gson.annotations.SerializedName;
import database.Model;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Member extends Model {
    @SerializedName("_id") String dni;
    String name;
    String surname;
    String address;
    String telephone;

    public Member() {
    }

    @Override
    public String getPrimaryKey() {
        return dni;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        dni = primaryKey;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
