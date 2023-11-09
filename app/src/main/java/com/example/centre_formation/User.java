package com.example.centre_formation;

public class User {

    private int id;
    private String firstName,LastName,adress,status,insritEn;
    private int phoneNumber;

    public User(String firstName, String lastName, String adress, String status, String insritEn, int phoneNumber) {
        this.firstName = firstName;
        LastName = lastName;
        this.adress = adress;
        this.status = status;
        this.insritEn = insritEn;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInsritEn() {
        return insritEn;
    }

    public void setInsritEn(String insritEn) {
        this.insritEn = insritEn;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
