package com.kelvin.pendaftarananroid;

public class BracketTeam {
    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public BracketTeam(String team1, String team2, String date, String komentar) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.komentar = komentar;
    }

    private String team1,team2,date,komentar;
}
