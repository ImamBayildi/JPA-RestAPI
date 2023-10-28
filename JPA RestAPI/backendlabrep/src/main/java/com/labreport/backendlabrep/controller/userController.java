package com.labreport.backendlabrep.controller;


import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labreport.backendlabrep.entity.t_user;
import com.labreport.backendlabrep.service.userServiceInterface;

@RestController//API bildirimi
@RequestMapping("/user")//path bildirimi. Bu adrese gelen istekler burada karşılanacak
public class userController {
    
    //@Autowired  //IoC içindeki referans enjekte ediliyor. Böylelikle user service referansımızı controller içine enjekte etmiş oluyoruz// ve ya final ve cunstructor kullan:
    private final userServiceInterface userService;

    public userController(com.labreport.backendlabrep.service.userServiceInterface userService) {
        this.userService = userService;

    }

    @PostMapping("/create")
    public ResponseEntity<t_user> createUser(@RequestBody t_user user) {
        t_user resultUser = userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<t_user>> getUsers(){

       List<t_user> users= userService.getUsers();
       return ResponseEntity.ok(users);
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<t_user> getId (@PathVariable("id") long id){//ResponseEntity tipinde

        t_user user = userService.getUserId(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<t_user> updateUser (@PathVariable("id") Long id, @RequestBody t_user user){

        t_user resultUser = userService.updateUser(id,user);
        return ResponseEntity.ok(resultUser);
        // {
        //     "firtName": "Ahmemt",
        //     "lastName": "Gökgöz"
        // }
    }


    @DeleteMapping("delete/{userId}")
    public ResponseEntity<Boolean> deleteUser (@PathVariable("userId") Long id){

        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);
    }
    
}
