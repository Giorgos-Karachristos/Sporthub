package com.example.sporthub5.RoomDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Sport.class, Athlete.class, Team.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
