package com.example.bank.service;

import com.example.bank.dto.UserDto;
import com.example.bank.entity.Account;
import com.example.bank.entity.User;
import com.example.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountService accountService;


    public List<UserDto> getAll(){
        return userRepository.findAll().stream().map(UserDto::new).collect(Collectors.toList());
    }

    public User getById(Long id){
         Optional<User> user = userRepository.findById(id);
         if (user.isEmpty()){
             throw new IllegalArgumentException("Uživatel s id " + id + " neexistuje.");
         }
         return user.get();
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User getByFirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }

    public User getByFirstNameAndLastName(String firstName, String lastName){
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public User addAccount(Long idUser, Long idAccount) {
        User user = getById(idUser);
        final Account account = accountService.getById(idAccount);
        user.getAccountList().add(account);
        return userRepository.save(user);
    }

    public User deleteAccount(Long idUser, Long idAccount) {
        User user = getById(idUser);
        List<Account> accountList = user.getAccountList().stream()
                .filter(account -> !account.getAccountId().equals(idAccount))
                .collect(Collectors.toList());
        user.setAccountList(accountList);
        return userRepository.save(user);
    }
}
