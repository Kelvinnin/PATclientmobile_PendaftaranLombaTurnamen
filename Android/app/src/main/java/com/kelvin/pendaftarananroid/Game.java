package com.kelvin.pendaftarananroid;

public class Game {
    private int idgame;
    private String nama_game;

    public Game(int idgame, String nama_game) {
        this.idgame = idgame;
        this.nama_game = nama_game;
    }

    public int getIdgame() {
        return idgame;
    }

    public void setIdgame(int idgame) {
        this.idgame = idgame;
    }

    public String getNama_game() {
        return nama_game;
    }

    public void setNama_game(String nama_game) {
        this.nama_game = nama_game;
    }


}
