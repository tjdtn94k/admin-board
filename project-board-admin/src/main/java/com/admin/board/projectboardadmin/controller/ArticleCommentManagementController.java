package com.admin.board.projectboardadmin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/management/article-comment")
@RestController
public class ArticleCommentManagementController {

    @GetMapping
    public String articleComments(Model model) {


        return "management/article-comments";
    }
}
