package models;

import database.Model;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Member extends Model {
    transient static public String _view_all = "library/members";
    transient static public String _view_key = "library/member";
    String dni;
    String name;
    String surname;
    String address;
    String telephone;

    public Member() {
        this._view_all = "library/members";
        this._view_key = "library/member";
        this.Type = "Member";
    }

    @Override
    public String getKey() {
        return dni;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String dni) {
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
