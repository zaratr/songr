package com.raulsongr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HelloWorldController {

    @ResponseBody
    @GetMapping("/hello")
    public String helloMethod()
    {
        return "Hello World";
    }
}
