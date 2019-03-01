package com.aflah.simplemvvmandrepositorypattern.data.local;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.aflah.simplemvvmandrepositorypattern.model.TeamDetail;

import java.util.List;

@Dao
public interface TeamDao {

    @Query("SELECT * FROM teamTable")
    List<TeamDetail> getTeams();

    @Insert
    void insertTeam(List<TeamDetail> teamDetails);
}
