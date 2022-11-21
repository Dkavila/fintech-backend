package me.kayrhu.controller;

import lombok.RequiredArgsConstructor;
import me.kayrhu.dao.UserDAO;
import me.kayrhu.model.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    UserDAO repository;

    @GetMapping("/userVerify/{email}/{password}")
    public UserModel verifyUser(@PathVariable String email, @PathVariable String password){
        return repository.verifyUser(email, password);
    }
    @GetMapping("/users")
    public List<UserModel> getAllUsers(){
        return repository.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserModel getUser(@PathVariable int id){
        return repository.getUser(id);
    }

    @PostMapping("/user")
    public boolean insertUser(@RequestBody UserModel user){
        return repository.insertUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        repository.deleteUser(id);
    }

}
