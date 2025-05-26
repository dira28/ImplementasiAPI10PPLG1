package com.example.implementasiapi10pplg1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    private Button btnPremierLeague, btnSpanishLeague;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnPremierLeague = findViewById(R.id.btnPremierLeague);
        btnSpanishLeague = findViewById(R.id.btnSpanishLeague);

        btnPremierLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity("English Premier League");
            }
        });

        btnSpanishLeague.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity("Spanish La Liga");
            }
        });
    }

    private void openMainActivity(String league) {
        Intent intent = new Intent(Home.this, MainActivity.class);
        intent.putExtra("league", league);
        startActivity(intent);
    }
}
