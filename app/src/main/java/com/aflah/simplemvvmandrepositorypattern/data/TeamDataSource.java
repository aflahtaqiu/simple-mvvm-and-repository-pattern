package com.aflah.simplemvvmandrepositorypattern.data;

import com.aflah.simplemvvmandrepositorypattern.model.Team;

public interface TeamDataSource {

    void getListTeams(GetTeamsCallback callback);

    interface GetTeamsCallback {
        void onTeamLoaded(Team data);
        void onDataNotAvailable(String errMsg);
    }
}
