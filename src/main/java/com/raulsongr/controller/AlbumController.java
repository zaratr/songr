package com.raulsongr.controller;

import com.raulsongr.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


}
