package com.aflah.simplemvvmandrepositorypattern.data.local;

import android.content.Context;

import com.aflah.simplemvvmandrepositorypattern.data.TeamDataSource;
import com.aflah.simplemvvmandrepositorypattern.model.Team;
import com.aflah.simplemvvmandrepositorypattern.model.TeamDetail;

import java.util.List;

public class TeamLocalDataSource implements TeamDataSource {

    private Context context;
    private TeamDao teamDao;

    public TeamLocalDataSource(Context context) {
        this.context = context;
        this.teamDao = TeamDatabase.getInstance(context).teamDao();
    }

    @Override
    public void getListTeams(final GetTeamsCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<TeamDetail> teamDetails = teamDao.getTeams();
                if (teamDetails.isEmpty())
                    callback.onDataNotAvailable("Data di db SQLite kosong");
                else {
                    Team team = new Team(teamDetails);
                    callback.onTeamLoaded(team);
                }
            }
        };
        new Thread(runnable).start();
    }

    public void saveDataTeam(final List<TeamDetail> teamDetails){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                teamDao.insertTeam(teamDetails);
            }
        };

        new Thread(runnable).start();
    }
}
