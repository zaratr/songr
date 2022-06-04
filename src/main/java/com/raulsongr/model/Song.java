package com.raulsongr.model;
import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String title;
    private int length;
    private int trackNumber;

    @ManyToOne
    private Album album;

    public Song(){}

    public Song(String title, int length, int trackNumber)
    {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Album getAlbum() {
        return album;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }
}
