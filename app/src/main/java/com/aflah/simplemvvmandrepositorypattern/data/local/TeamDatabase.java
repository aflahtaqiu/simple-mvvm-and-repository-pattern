package com.aflah.simplemvvmandrepositorypattern.data.local;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.aflah.simplemvvmandrepositorypattern.model.TeamDetail;

@Database(entities = {TeamDetail.class}, version = 1)
public abstract class TeamDatabase extends RoomDatabase {

    private static TeamDatabase INSTANCE;

    public abstract TeamDao teamDao();

    private static final Object sLack = new Object();

    public static TeamDatabase getInstance(Context context){
        synchronized (sLack){
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, TeamDatabase.class, "Teamdb").allowMainThreadQueries().build();
            }
            return INSTANCE;
        }
    }
}
