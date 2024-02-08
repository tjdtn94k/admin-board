package com.admin.board.projectboardadmin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/management/user-account")
@RestController
public class UserAccountManagementController {
    @GetMapping
    public String userAccounts(Model model) {


        return "management/user-accounts";
    }
}
