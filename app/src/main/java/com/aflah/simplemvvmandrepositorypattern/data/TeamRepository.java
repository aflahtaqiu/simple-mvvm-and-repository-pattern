package com.aflah.simplemvvmandrepositorypattern.data;

import android.support.annotation.Nullable;

import com.aflah.simplemvvmandrepositorypattern.data.local.TeamLocalDataSource;
import com.aflah.simplemvvmandrepositorypattern.data.remote.TeamRemoteDataSource;
import com.aflah.simplemvvmandrepositorypattern.model.Team;

public class TeamRepository implements TeamDataSource {

    private TeamLocalDataSource teamLocalDataSource;
    private TeamRemoteDataSource teamRemoteDataSource;

    public TeamRepository(TeamLocalDataSource teamLocalDataSource, TeamRemoteDataSource teamRemoteDataSource) {
        this.teamLocalDataSource = teamLocalDataSource;
        this.teamRemoteDataSource = teamRemoteDataSource;
    }

    @Override
    public void getListTeams(final GetTeamsCallback callback) {
        teamLocalDataSource.getListTeams(new GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                callback.onTeamLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errMsg) {
                getTeamsfromRempoteDataSource(callback);
            }
        });
    }

    private void getTeamsfromRempoteDataSource(@Nullable final GetTeamsCallback callback){
        teamRemoteDataSource.getListTeams(new GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                teamLocalDataSource.saveDataTeam(data.getTeams());
                callback.onTeamLoaded(data);
            }

            @Override
            public void onDataNotAvailable(String errMsg) {
                callback.onDataNotAvailable(errMsg);
            }
        });
    }
}
