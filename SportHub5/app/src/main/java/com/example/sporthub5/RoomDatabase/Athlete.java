package com.example.sporthub5.RoomDatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "Athlete",
        primaryKeys = {"acode"},
        foreignKeys = {
                @ForeignKey(entity = Sport.class,
                        parentColumns = "sid",
                        childColumns = "asid",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE)
        }
)
public class Athlete {
    @ColumnInfo(name = "acode")
    @NonNull
    private int code;

    @ColumnInfo(name = "aname")
    private String name;

    @ColumnInfo(name = "asurname")
    private String surname;

    @ColumnInfo(name = "acity")
    private String city;

    @ColumnInfo(name = "acountry")
    private String country;

    @ColumnInfo(name = "asid")
    @NonNull
    private int sid;

    @ColumnInfo(name = "ayear")
    private int year;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
