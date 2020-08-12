package com.example.bank.repository;

import com.example.bank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByFirstName(String firstName);

    @Query("SELECT u FROM User u WHERE u.firstName = ?1 AND u.lastName = ?2")
    User findByFirstNameAndLastName(String firstName, String lastName);

}
