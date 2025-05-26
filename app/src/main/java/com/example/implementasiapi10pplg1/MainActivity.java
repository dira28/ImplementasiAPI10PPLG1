package com.example.implementasiapi10pplg1;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;

    private String selectedLeague;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        selectedLeague = getIntent().getStringExtra("league");
        if (selectedLeague == null || selectedLeague.isEmpty()) {
            selectedLeague = "English Premier League";
        }

        fetchTeams();
    }

    private void fetchTeams() {
        ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
        Call<TeamListResponse> call = apiService.getAllTeams(selectedLeague);

        call.enqueue(new Callback<TeamListResponse>() {
            @Override
            public void onResponse(Call<TeamListResponse> call, Response<TeamListResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Team> teams = response.body().getTeams();
                    if (teams != null) {
                        teamAdapter = new TeamAdapter(teams);
                        recyclerView.setAdapter(teamAdapter);
                    } else {
                        Toast.makeText(MainActivity.this, "Data kosong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TeamListResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
