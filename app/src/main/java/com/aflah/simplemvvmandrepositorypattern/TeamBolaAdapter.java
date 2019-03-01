package com.aflah.simplemvvmandrepositorypattern;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aflah.simplemvvmandrepositorypattern.model.TeamDetail;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TeamBolaAdapter extends RecyclerView.Adapter<TeamBolaAdapter.MyViewHolder> {

    private Context context;
    private List<TeamDetail> teamDetails;

    public TeamBolaAdapter(Context context, List<TeamDetail> teamDetails) {
        this.context = context;
        this.teamDetails = teamDetails;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(teamDetails.get(i).teamName);
        Picasso.get().load(teamDetails.get(i).getTeamLogo()).into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return teamDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.tv_namateam);
            imageView = (ImageView) itemView.findViewById(R.id.iv_logoteam);
        }
    }
}
