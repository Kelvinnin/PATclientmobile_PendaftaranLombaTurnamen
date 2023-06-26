package com.kelvin.pendaftarananroid;

public class Bracket {
    public String getPeserta1() {
        return peserta1;
    }

    public void setPeserta1(String peserta1) {
        this.peserta1 = peserta1;
    }

    public String getPeserta2() {
        return peserta2;
    }

    public void setPeserta2(String peserta2) {
        this.peserta2 = peserta2;
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

    private String peserta1;
    private String peserta2;
    private String date;

    public Bracket(String peserta1, String peserta2, String date, String komentar) {
        this.peserta1 = peserta1;
        this.peserta2 = peserta2;
        this.date = date;
        this.komentar = komentar;
    }

    private String komentar;
}
