package com.admin.board.projectboardadmin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/management/articles")
@RestController
public class ArticleManagementController {
    @GetMapping
    public String articles(Model model) {


        return "management/articles";
    }
}
