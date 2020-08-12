package com.example.bank.dto;

import com.example.bank.entity.Account;
import com.example.bank.entity.User;

import java.util.List;

/*
    Třída pro vypsání uživatelů bez hesel
 */
public class UserDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private Integer age;

    private String username;

    private List<Account> accountList;

    public UserDto(User user){
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.age = user.getAge();
        this.username = user.getUsername();
        this.accountList = user.getAccountList();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
