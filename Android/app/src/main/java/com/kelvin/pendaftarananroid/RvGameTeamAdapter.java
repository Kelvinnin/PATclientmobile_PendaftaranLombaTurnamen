package com.kelvin.pendaftarananroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvGameTeamAdapter extends RecyclerView.Adapter<RvGameTeamAdapter.ViewHolder> {

    private ArrayList<Gameindiv> listGameTeam;
    private Context context;

    public RvGameTeamAdapter(ArrayList<Gameindiv> listGameTeam, Context context) {
        this.listGameTeam = listGameTeam;
        this.context = context;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtJudulGame , txtTeam,txtWin,txtLose;

        public ViewHolder(View ItemView){
            super(ItemView);
            txtJudulGame=ItemView.findViewById(R.id.txtJudulGame);
            txtTeam=ItemView.findViewById(R.id.txtTeam);
            txtWin=ItemView.findViewById(R.id.txtWin);
            txtLose=ItemView.findViewById(R.id.txtLose);
        }

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_leaderboard,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvGameTeamAdapter.ViewHolder holder, int position) {
        Gameindiv gameindiv = listGameTeam.get(position);
        holder.txtTeam.setText(gameindiv.getNama());
        holder.txtJudulGame.setText(gameindiv.getNama_game());
        holder.txtWin.setText(String.valueOf(gameindiv.getWin()));
        holder.txtLose.setText(String.valueOf(gameindiv.getLose()));
    }

    @Override
    public int getItemCount() {
        return listGameTeam.size();
    }

}
