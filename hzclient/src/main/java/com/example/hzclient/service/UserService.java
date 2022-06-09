package com.example.hzclient.service;



import com.example.hzclient.model.User;
import com.example.hzclient.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Map<String, User> accountMap;

    public User getUser(String accountNumber) {
        if(accountMap.get(accountNumber)!=null){
            System.out.println("yes");
            return accountMap.get(accountNumber);
        }

        User user = userRepo.findByAccountNumber(accountNumber);
        accountMap.put(accountNumber,user);

        return user;
    }
    public User createUser(User user) {

        User newUser = userRepo.save(user);
        accountMap.put(user.getAccountNumber(),user);

        return newUser;
    }

    public List<User> getAllUsers(){

        return userRepo.findAll();
    }

}
