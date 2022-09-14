package com.bridgelabz.fundoonotes.repository;

import com.bridgelabz.fundoonotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User deleteUserById(int id);
}
