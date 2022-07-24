package com.example.sporthub5.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Sport")
public class Sport {
    @PrimaryKey
    @ColumnInfo(name = "sid")
    private int id;

    @ColumnInfo(name = "sname")
    private String name;

    @ColumnInfo(name = "stype")
    private String type;

    @ColumnInfo(name = "sgender")
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setType(String type) {
        this.type = type;
    }
}
