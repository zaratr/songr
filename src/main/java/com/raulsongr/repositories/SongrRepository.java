package com.raulsongr.repositories;

import com.raulsongr.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

//make a repo for the data value
public interface SongrRepository extends JpaRepository<Album , Long> {

    public Album findByTitle(String title);
}
/*
*/