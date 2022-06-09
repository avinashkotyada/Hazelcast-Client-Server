package com.example.hzclient.controller;
import com.example.hzclient.model.User;
import com.example.hzclient.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/users")
public class UserController {

//    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/get-all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @GetMapping("/get/{accountNumber}")
    public User getUser(@PathVariable("accountNumber") String accountNumber) {
        return userService.getUser(accountNumber);
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
