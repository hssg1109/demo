package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class UserAccountController {

    @Autowired
    private final UserAccountService userAccountService;
    private final UserAccountRepository accountRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<UserAccount> accountList = this.accountRepository.findAll();
        model.addAttribute("accountList", accountList);
        return "account_list";
    }

    //add
    @GetMapping("/create")
    public String showCreateAccountPage(@RequestParam("userId") Long userId, Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("userAccount", new UserAccount());
        return "create-account";
    }

    @PostMapping("/create")
    public String createAccount(@RequestParam("userId") Long userId, @ModelAttribute UserAccount userAccount) {
        userAccountService.createAccount(userId, userAccount);
        return "redirect:/account/list";
    }
}