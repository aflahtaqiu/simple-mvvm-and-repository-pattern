package com.aflah.simplemvvmandrepositorypattern.data.remote;

import com.aflah.simplemvvmandrepositorypattern.model.Team;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/v1/json/1/search_all_teams.php")
    Call<Team> getAllTeams(@Query("l") String search);
}
