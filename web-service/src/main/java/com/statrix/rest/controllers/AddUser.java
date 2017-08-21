package com.statrix.rest.controllers;

import com.statrix.rest.models.Users;
import com.statrix.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@EnableAutoConfiguration
@RequestMapping("statrix/api/v1/")
public class AddUser {

    @Autowired
    UserService userService;

    @RequestMapping(value = "sx_user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody Users user, UriComponentsBuilder ucBuilder){

        if(userService.isUserExist(user)){
            return new ResponseEntity("Unable to create. Already exist.", HttpStatus.CONFLICT);
        }
        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("statrix/api/v1/info/sx_user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}
