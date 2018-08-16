package com.example.rifqi.recycler;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Player implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("kit_no")
    private String kit_no;

    @SerializedName("club")
    private String club;

    @SerializedName("nationality")
    private String nationality;

    String nama_player;
    String desc_player;
    int foto_player;

    public Player(String nama_player, int foto_player,String desc_player) {
        this.nama_player = nama_player;
        this.foto_player = foto_player;
        this.desc_player = desc_player;
    }

    public String getNama_player() {
        return nama_player;
    }

    public void setNama_player(String nama_player) {
        this.nama_player = nama_player;
    }

    public int getFoto_player() {
        return foto_player;
    }

    public void setFoto_player(int foto_player) {
        this.foto_player = foto_player;
    }

    public String getDesc_player() {
        return desc_player;
    }

    public void setDesc_player(String desc_player) {
        this.desc_player = desc_player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKit_no() {
        return kit_no;
    }

    public void setKit_no(String kit_no) {
        this.kit_no = kit_no;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", kit_no='" + kit_no + '\'' +
                ", club='" + club + '\'' +
                ", nationality='" + nationality + '\'' +
                ", nama_player='" + nama_player + '\'' +
                ", desc_player='" + desc_player + '\'' +
                ", foto_player=" + foto_player +
                '}';
    }
}
