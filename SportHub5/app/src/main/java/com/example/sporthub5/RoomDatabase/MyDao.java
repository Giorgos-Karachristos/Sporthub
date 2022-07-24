package com.example.sporthub5.RoomDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public void insertSport(Sport sport);

    @Insert
    public void insertAthlete(Athlete athlete);

    @Insert
    public void insertTeam(Team team);

    @Delete
    public void deleteSport(Sport sport);

    @Delete
    public void deleteAthlete(Athlete athlete);

    @Delete
    public void deleteTeam(Team team);

    @Update
    public void updateSport(Sport sport);

    @Update
    public void updateAthlete(Athlete athlete);

    @Update
    public void updateTeam(Team team);

    @Query("select * from sport")
    public List<Sport> getSports();

    @Query("select * from athlete")
    public List<Athlete> getAthletes();

    @Query("select * from team")
    public List<Team> getTeams();

    @Query("select * from sport where :id")
    public boolean getIdSport(int id);

    @Query("select * from athlete where :id")
    public boolean getAthleteCode(int id);

    @Query("select * from team where :id")
    public boolean getTeamCode(int id);
}
