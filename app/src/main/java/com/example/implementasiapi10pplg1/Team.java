package com.example.implementasiapi10pplg1;
import com.google.gson.annotations.SerializedName;
public class Team {
    @SerializedName("idTeam")
    private String idTeam;

    @SerializedName("strTeam")
    private String strTeam;

    @SerializedName("strBadge")
    private String strBadge;

    @SerializedName("strDescriptionEN")
    private String description;

    public String getDescription() {
        return description;
    }

    public String getStrBadge() {
        return strBadge;
    }


    public String getIdTeam() {
        return idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }
}
