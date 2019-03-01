package com.aflah.simplemvvmandrepositorypattern;

import android.content.Context;

import com.aflah.simplemvvmandrepositorypattern.data.TeamRepository;
import com.aflah.simplemvvmandrepositorypattern.data.local.TeamLocalDataSource;
import com.aflah.simplemvvmandrepositorypattern.data.remote.TeamRemoteDataSource;

public class Injection {

    public static TeamRepository provideTeamRepository(Context context){
        return  new TeamRepository(new TeamLocalDataSource(context), new TeamRemoteDataSource());
    }
}
