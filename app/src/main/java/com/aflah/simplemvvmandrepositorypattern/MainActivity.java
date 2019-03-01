package com.aflah.simplemvvmandrepositorypattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.aflah.simplemvvmandrepositorypattern.model.TeamDetail;
import com.aflah.simplemvvmandrepositorypattern.viewmodel.TeamViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TeamViewModel.TeamNavigator {

    private TeamViewModel teamViewModel;
    private RecyclerView recyclerView;

    private TeamBolaAdapter adapter;
    private List<TeamDetail> dataListTeamBola = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewTeamBola);
        teamViewModel = new TeamViewModel(Injection.provideTeamRepository(this), this);
        teamViewModel.setTeamNavigator(this);
        initAdapter();
        teamViewModel.getListTeam();
    }

    @Override
    public void loadListTeam(List<TeamDetail> teamDetailList) {
        dataListTeamBola.addAll(teamDetailList);
        adapter.notifyDataSetChanged();
    }

    public void initAdapter(){
        adapter = new TeamBolaAdapter(this, this.dataListTeamBola);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.smoothScrollToPosition(0);
    }

    @Override
    public void errorLoadListTeam(String message) {
        Log.e("error", message);
    }
}
