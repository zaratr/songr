package com.raulsongr.model;
import javax.persistence.*;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    long id;
    @Column(columnDefinition = "text")
    private String title;
    private String artist;
    private int songCount;
    private int length;
    private String imgUrl;

    public Album()
    {
    }
    public Album(String title, String artist, int count, int length, String imgUrl)
    {
        this.title = title;
        this.artist = artist;
        this.songCount = count;
        this.length = length;
        this.imgUrl = imgUrl;
    }
    public Album(Album toCopy)
    {
        this.title = toCopy.title;
        this.artist = toCopy.artist;
        this.songCount = toCopy.songCount;
        this.length = toCopy.length;
        this.imgUrl = toCopy.imgUrl;
    }
    //mutators


    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //getters
    public int getLength() {
        return length;
    }

    public int getSongCount() {
        return songCount;
    }

    public String getArtist() {
        return artist;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }
}
