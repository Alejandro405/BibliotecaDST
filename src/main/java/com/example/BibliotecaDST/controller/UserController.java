package com.example.BibliotecaDST.controller;

import com.example.BibliotecaDST.model.User;
import com.example.BibliotecaDST.repo.UserRepo;
import com.example.BibliotecaDST.tools.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllusers(){
        List<User> res = userRepo.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getuser(@PathVariable("id") Long id) {
        User res = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user by id = " + id + " no found"));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> adduser(@RequestBody User newuser) {
        return new ResponseEntity<>(userRepo.save(newuser), HttpStatus.OK);
    }

    @PostMapping("/addAll")
    public HttpStatus addAllusers(@RequestBody List<User> data) {
        for (User x :
                data) {
            if (userRepo.existsById(x.getId()))
                userRepo.deleteById(x.getId());

            userRepo.save(x);

            System.out.println("Libro ->" + x.toString() + "<-");
        }

        return HttpStatus.OK;
    }

    @PostMapping("/update")
    public ResponseEntity<User> updateuser(@RequestBody User user) {
        if (userRepo.existsById(user.getId())) {
            userRepo.deleteById(user.getId());
        }

        return new ResponseEntity<>(userRepo.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteuser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<User> deleteById(@RequestBody List<Long> ids) {
        for (Long x :
                ids) {
            userRepo.deleteById(x);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
