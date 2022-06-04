package com.raulsongr.controller;

import com.raulsongr.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

//import com.raulsongr.repositories.*;
import com.raulsongr.repositories.SongrRepository;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    SongrRepository songrRepository;


    @GetMapping("/")
    public String songrAlbums(Model mdl) {
        List<Album> list = songrRepository.findAll();
        mdl.addAttribute("albums", list);

        return "album";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imgurl)
    {
        Album addMe = new Album(title, artist ,songCount,length,imgurl);
        songrRepository.save(addMe);
        return new RedirectView("/");
    }

    @GetMapping("/view-album/{title}")
    public String viewAlbumW(@PathVariable String title, Model mdl)
    {
        Album albumToView = songrRepository.findByTitle(title);
        mdl.addAttribute("album", albumToView);
        mdl.addAttribute("songs", albumToView.getSongsofAlbum());
        return "view-album.html";
    }
    @PutMapping("/edit-album")
    public RedirectView viewAlbum(long id, String title, String artist, int songCount, int length, String imgUrl){
        Album albumToEdit = songrRepository.getReferenceById(id);
        albumToEdit.setTitle(title);
        albumToEdit.setArtist(artist);
        albumToEdit.setSongCount(songCount);
        albumToEdit.setLength(length);
        albumToEdit.setImgUrl(imgUrl);
        return new RedirectView("/");
    }


    @DeleteMapping("/delete-album")
    public RedirectView deleteAlbum(long id)
    {
        songrRepository.deleteById(id);
        return new RedirectView("/");
    }
}
