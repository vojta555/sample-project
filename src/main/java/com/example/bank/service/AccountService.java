package com.example.bank.service;

import com.example.bank.entity.Account;
import com.example.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public Account getById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty()){
            throw new IllegalArgumentException("Účet nenalezen.");
        }
        return account.get();
    }

    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    public Account create(Account account) {
        return accountRepository.save(account);
    }
}
