package com.admin.board.projectboardadmin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String root() {
        return "forward:/management/articles";
    }
}
