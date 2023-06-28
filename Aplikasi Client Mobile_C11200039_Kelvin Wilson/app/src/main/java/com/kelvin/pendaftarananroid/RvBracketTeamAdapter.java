package com.kelvin.pendaftarananroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvBracketTeamAdapter extends RecyclerView.Adapter<RvBracketTeamAdapter.ViewHolder>{


    private ArrayList<BracketTeam> listBracketTeam;
    private Context context;

    public RvBracketTeamAdapter(ArrayList<BracketTeam> listBracketTeam, Context context) {
        this.listBracketTeam = listBracketTeam;
        this.context = context;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtTeam1 , txtTeam2,txtTeamDate;

        public ViewHolder(View ItemView){
            super(ItemView);
            txtTeam1=ItemView.findViewById(R.id.txtTeam1);
            txtTeam2=ItemView.findViewById(R.id.txtTeam2);
            txtTeamDate=ItemView.findViewById(R.id.textViewDate);
//            txtKomentar=ItemView.findViewById(R.id.txtLose);
        }

    }
    @NonNull
    @Override
    public RvBracketTeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_bracket_layout,parent,false);
        return new RvBracketTeamAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvBracketTeamAdapter.ViewHolder holder, int position) {
        BracketTeam bracket = listBracketTeam.get(position);
        holder.txtTeam1.setText(bracket.getTeam1());
        holder.txtTeam2.setText(bracket.getTeam2());
        holder.txtTeamDate.setText(String.valueOf(bracket.getDate()));
        holder.txtTeamDate.setText(String.valueOf(bracket.getKomentar()));
//        holder.txtLose.setText(String.valueOf(gameindiv.getLose()));
    }

    @Override
    public int getItemCount() {
        return listBracketTeam.size();
    }
}
