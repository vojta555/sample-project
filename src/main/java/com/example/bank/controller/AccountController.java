package com.example.bank.controller;

import com.example.bank.entity.Account;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id){
        return accountService.getById(id);
    }

    @PostMapping
    public Account create(@RequestBody Account account){
        return accountService.create(account);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        accountService.deleteById(id);
    }
}
