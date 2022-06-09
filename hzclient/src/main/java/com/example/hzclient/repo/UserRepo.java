package com.example.hzclient.repo;


import com.example.hzclient.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long>{
    User findByAccountNumber(String accountNumber);
}
