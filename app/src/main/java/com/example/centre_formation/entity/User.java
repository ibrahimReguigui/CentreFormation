package com.example.centre_formation.entity;

import androidx.annotation.InspectableProperty;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "firstName")
    private String firstName;
    @ColumnInfo(name = "LastName")
    private String LastName;
    @ColumnInfo(name = "adress")
    private String adress;
    @ColumnInfo(name = "status")
    private String status;
    @ColumnInfo(name = "insritEn")
    private String insritEn;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "phoneNumber")
    private int phoneNumber;
    @ColumnInfo(name = "role")
    private String role;

    public User() {
    }

    public User(String firstName, String lastName, String adress, String status, String insritEn, int phoneNumber, String role) {
        this.firstName = firstName;
        LastName = lastName;
        this.adress = adress;
        this.status = status;
        this.insritEn = insritEn;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
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
