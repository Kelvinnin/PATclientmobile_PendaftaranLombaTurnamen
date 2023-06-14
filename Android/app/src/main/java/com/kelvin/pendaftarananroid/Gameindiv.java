package com.kelvin.pendaftarananroid;

public class Gameindiv {
    public String getNama_game() {
        return nama_game;
    }

    public void setNama_game(String nama_game) {
        this.nama_game = nama_game;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public Gameindiv(String nama_game, String nama, int win, int lose) {
        this.nama_game = nama_game;
        this.nama = nama;
        this.win = win;
        this.lose = lose;
    }

    private String nama_game , nama;
    private  int win,lose;
}
