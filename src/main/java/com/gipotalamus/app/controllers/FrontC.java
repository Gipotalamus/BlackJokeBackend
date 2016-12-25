package com.gipotalamus.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

/**
 * Created by gipotalamus on 28.11.16.
 */
@Controller
public class FrontC {

    @RequestMapping(value = {"/", ""})
    public String serveFrontend(){
        return "index.html";
    }
}
