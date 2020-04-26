package com.demo.swagger.users;


import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserController {

    @Autowired
    private UserDaoService service;
    //GET /users
    // retrieveAllUsers
    @GetMapping("/users")
    public ResponseEntity<List<User>> retrieveAllUsers()
    {

        List <User> userList = service.findALL();

        return new ResponseEntity<List<User>> (userList,new HttpHeaders(),HttpStatus.OK);
    }

    //GET /user/{id}
    //retrieveUser
    @GetMapping("/users/{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable int id) {
        User user =service.findOne(id);
        return new ResponseEntity<User>(user,new HttpHeaders(),HttpStatus.OK);
    }
    
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser=service.save(user);
        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return new ResponseEntity<>(savedUser, new HttpHeaders(),HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public Boolean deleteUserById(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
