package com.kelvin.pendaftarananroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvBracketAdapter extends RecyclerView.Adapter<RvBracketAdapter.ViewHolder> {


    private ArrayList<Bracket> listBracketIndiv;
    private Context context;

    public RvBracketAdapter(ArrayList<Bracket> listBracketIndiv, Context context) {
        this.listBracketIndiv = listBracketIndiv;
        this.context = context;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtPlayer1 , txtPlayer2,txtPlayerDate;

        public ViewHolder(View ItemView){
            super(ItemView);
            txtPlayer1=ItemView.findViewById(R.id.txtTeam1);
            txtPlayer2=ItemView.findViewById(R.id.txtTeam2);
            txtPlayerDate=ItemView.findViewById(R.id.textViewDate);
//            txtKomentar=ItemView.findViewById(R.id.txtLose);
        }

    }
    @NonNull
    @Override
    public RvBracketAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_bracket_layout,parent,false);
        return new RvBracketAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvBracketAdapter.ViewHolder holder, int position) {
        Bracket bracket = listBracketIndiv.get(position);
        holder.txtPlayer1.setText(bracket.getPeserta1());
        holder.txtPlayer2.setText(bracket.getPeserta2());
        holder.txtPlayerDate.setText(String.valueOf(bracket.getDate()));
        holder.txtPlayerDate.setText(String.valueOf(bracket.getKomentar()));
//        holder.txtLose.setText(String.valueOf(gameindiv.getLose()));
    }

    @Override
    public int getItemCount() {
        return listBracketIndiv.size();
    }
}

