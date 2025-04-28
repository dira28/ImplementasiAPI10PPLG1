package com.example.implementasiapi10pplg1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchTeams();
    }




        private void fetchTeams () {
            ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
            Call<TeamListResponse> call = apiService.getAllTeams("English Premier League");

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