package com.example.implementasiapi10pplg1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private List<Team> teamList;

    public TeamAdapter(List<Team> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.tvIdTeam.setText("ID: " + team.getIdTeam());
        holder.tvTeamName.setText(team.getStrTeam());
        holder.tvDescription.setText(team.getDescription());
        Glide.with(holder.ivLogo.getContext())
                .load(team.getStrBadge())
                .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdTeam, tvTeamName, tvDescription;
        ImageView ivLogo;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdTeam = itemView.findViewById(R.id.tvIdTeam);
            tvTeamName = itemView.findViewById(R.id.tvTeamName);
            ivLogo = itemView.findViewById(R.id.ivLogo);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
