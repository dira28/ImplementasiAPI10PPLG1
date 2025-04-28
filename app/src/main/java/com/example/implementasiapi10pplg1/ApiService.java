package com.example.implementasiapi10pplg1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search_all_teams.php")
    Call<TeamListResponse> getAllTeams(@Query("l") String league);
}
