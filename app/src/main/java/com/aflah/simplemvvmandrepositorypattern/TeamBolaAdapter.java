package com.aflah.simplemvvmandrepositorypattern;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aflah.simplemvvmandrepositorypattern.databinding.ItemRowBinding;
import com.aflah.simplemvvmandrepositorypattern.model.TeamDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamBolaAdapter extends RecyclerView.Adapter<TeamBolaAdapter.MyViewHolder> {

    private Context context;
    private List<TeamDetail> teamDetails;
    private LayoutInflater layoutInflater;

    public TeamBolaAdapter(Context context, List<TeamDetail> teamDetails) {
        this.context = context;
        this.teamDetails = teamDetails;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
//        MyViewHolder myViewHolder = new MyViewHolder(view);
//
//        return myViewHolder;

        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(viewGroup.getContext());

        ItemRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_row, viewGroup, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.binding.setTeamDetailVM(teamDetails.get(i));
    }

    @Override
    public int getItemCount() {
        return teamDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final ItemRowBinding binding;

        public MyViewHolder(ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.binding = itemRowBinding;
        }
    }
}
