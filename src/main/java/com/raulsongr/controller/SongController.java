package com.raulsongr.controller;


import com.raulsongr.model.Album;
import com.raulsongr.model.Song;
import com.raulsongr.repositories.SongRepo;
import com.raulsongr.repositories.SongrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    SongrRepository albumsRepo;
    @Autowired
    SongRepo songRepo;

    @PostMapping("/add-song")
    public RedirectView addSong(long albumId, String title, int length, int trackNumber)
    {
        Album songsAlbum = albumsRepo.getReferenceById(albumId);
        Song songToAdd = new Song(title, length, trackNumber);
        songToAdd.setAlbum(songsAlbum);
        songRepo.save(songToAdd);
        return new RedirectView("/");
    }

}
