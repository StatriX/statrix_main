package com.statrix.rest.controllers;

import com.statrix.rest.models.Users;
import com.statrix.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("statrix/api/v1/info/")
public class GetUserInfo {

    @Autowired
    UserService userService;

    @RequestMapping(value = "sx_user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserInfo(@PathVariable("id") Long id){
        Users user = userService.findById(id);
        if( user == null){
            return new ResponseEntity("not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Users>(user, HttpStatus.OK);
    }
}