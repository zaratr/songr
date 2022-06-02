package com.raulsongr.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Capitalization {
    @GetMapping("/capitalize/{capMe}")
    @ResponseBody
    public String toCap(@PathVariable String capMe){
        return capMe.toUpperCase();
    }

}
