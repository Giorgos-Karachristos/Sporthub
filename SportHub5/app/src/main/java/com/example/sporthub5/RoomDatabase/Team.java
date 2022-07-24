package com.example.sporthub5.RoomDatabase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "Team",
        primaryKeys = {"tcode"},
        foreignKeys = {
                @ForeignKey(entity = Sport.class,
                        parentColumns = "sid",
                        childColumns = "tsid",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE)
        }
)
public class Team {
    @ColumnInfo(name = "tcode")
    @NonNull
    private int code;

    @ColumnInfo(name = "tname")
    private String name;

    @ColumnInfo(name = "tstadium")
    private String stadium;

    @ColumnInfo(name = "tcity")
    private String city;

    @ColumnInfo(name = "tcountry")
    private String country;

    @ColumnInfo(name = "tsid")
    @NonNull
    private int sid;

    @ColumnInfo(name = "tyear")
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

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
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
