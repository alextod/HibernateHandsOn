package com.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Alex on 21.01.2017.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }
}
