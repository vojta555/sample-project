package com.example.bank.controller;

import com.example.bank.dto.UserDto;
import com.example.bank.entity.User;
import com.example.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/firstName/{firstName}")
    public User getByFirstName(@PathVariable String firstName){
        return userService.getByFirstName(firstName);
    }

    @GetMapping("/firstName/{firstName}/lastName/{lastName}")
    public User getByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName){
        return userService.getByFirstNameAndLastName(firstName, lastName);
    }

    @PostMapping("/{idUser}/account/{idAccount}")
    public User addAccount(@PathVariable Long idUser, @PathVariable Long idAccount){
        return userService.addAccount(idUser, idAccount);
    }

    @DeleteMapping("/{idUser}/account/{idAccount}")
    public User deleteAccount(@PathVariable Long idUser, @PathVariable Long idAccount){
        return userService.deleteAccount(idUser, idAccount);
    }
}
