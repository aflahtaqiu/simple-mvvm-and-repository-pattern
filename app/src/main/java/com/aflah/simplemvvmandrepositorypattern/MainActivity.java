package com.aflah.simplemvvmandrepositorypattern;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.aflah.simplemvvmandrepositorypattern.databinding.ActivityMainBinding;
import com.aflah.simplemvvmandrepositorypattern.model.TeamDetail;
import com.aflah.simplemvvmandrepositorypattern.viewmodel.TeamViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TeamViewModel.TeamNavigator {

    private TeamViewModel teamViewModel;
    private RecyclerView recyclerView;

    private TeamBolaAdapter adapter;
    private List<TeamDetail> dataListTeamBola = new ArrayList<>();

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        teamViewModel = new TeamViewModel(Injection.provideTeamRepository(this), this);
//        teamViewModel.setTeamNavigator(this);
//        initAdapter();
//        teamViewModel.getListTeam();
        teamViewModel.setTeamNavigator(this);
        teamViewModel.getListTeam();
        binding.setVm(teamViewModel);
        initAdapter();
    }

    @Override
    public void loadListTeam(List<TeamDetail> teamDetailList) {
        dataListTeamBola.addAll(teamDetailList);
        adapter.notifyDataSetChanged();
    }

    public void initAdapter(){
        adapter = new TeamBolaAdapter(this, this.dataListTeamBola);
        recyclerView = binding.recyclerviewTeamBola;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void errorLoadListTeam(String message) {
        Log.e("error", message);
    }
}
