package com.example.BibliotecaDST.controller;

import com.example.BibliotecaDST.model.User;
import com.example.BibliotecaDST.repo.UserRepo;
import com.example.BibliotecaDST.tools.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllusers(){
        List<User> res = userRepo.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/get")
    public ResponseEntity<User> getUser(@RequestBody User user) {
        ResponseEntity res = this.userRepo.findAll().stream().noneMatch(
                x -> x.getNick().equals(user.getNick()) && x.getPassWord().equals(user.getPassWord())
        )? new ResponseEntity(user, HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);

        return res;
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User res = userRepo.findById(Long.valueOf(1)).orElseThrow(() -> new UserNotFoundException("user by id = " + id + " no found"));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/getByName/{nick}")
    public ResponseEntity<User> getByNick(@PathVariable String nick) {
        List<User> res = userRepo.findAll().stream().takeWhile(x -> !x.getNick().equals(nick)).collect(Collectors.toList());
        if (res.isEmpty())
            return new ResponseEntity<>(new User(nick), HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(res.get(0), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> adduser(@RequestBody User newuser) {
        if (!userRepo.existsUserByNickEquals(newuser.getNick())) {
            return new ResponseEntity<>(userRepo.save(newuser), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

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

    @GetMapping("/contains/nick={nick}")
    public ResponseEntity<User> containsByNick(@PathVariable String nick) {
        if (this.userRepo.existsUserByNickEquals(nick))
            return new ResponseEntity<>(new User(Long.valueOf(-1), "Todo OK Jose Luis", "Todo OK"), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/valid")
    public ResponseEntity<User> validateUser(@RequestBody User user) {
        User aux = userRepo.findUserByNickEquals(user.getNick());
        if (aux != null) {
            return new ResponseEntity<>(aux, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
