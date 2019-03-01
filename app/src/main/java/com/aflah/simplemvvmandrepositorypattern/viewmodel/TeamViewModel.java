package com.aflah.simplemvvmandrepositorypattern.viewmodel;

import android.content.Context;

import com.aflah.simplemvvmandrepositorypattern.data.TeamDataSource;
import com.aflah.simplemvvmandrepositorypattern.data.TeamRepository;
import com.aflah.simplemvvmandrepositorypattern.model.Team;
import com.aflah.simplemvvmandrepositorypattern.model.TeamDetail;

import java.util.List;

public class TeamViewModel {

    private TeamRepository teamRepository;
    private TeamNavigator teamNavigator;

    public TeamViewModel(TeamRepository teamRepository, Context context){
        this.teamRepository = teamRepository;
    }

    public void setTeamNavigator(TeamNavigator teamNavigator) {
        this.teamNavigator = teamNavigator;
    }

    public interface TeamNavigator {
        void loadListTeam(List<TeamDetail> teamDetailList);
        void errorLoadListTeam(String message);
    }

    public void getListTeam() {
        teamRepository.getListTeams(new TeamDataSource.GetTeamsCallback() {
            @Override
            public void onTeamLoaded(Team data) {
                teamNavigator.loadListTeam(data.getTeams());
            }

            @Override
            public void onDataNotAvailable(String errMsg) {
                teamNavigator.errorLoadListTeam(errMsg);
            }
        });
    }
}
