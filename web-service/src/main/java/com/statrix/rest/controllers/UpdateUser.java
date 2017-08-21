package com.statrix.rest.controllers;

import com.statrix.rest.models.Users;
import com.statrix.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("statrix/api/v1/")

public class UpdateUser {

    @Autowired
    UserService userService;
    @RequestMapping(value = "sx_user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody Users user){
        Users currentUser = userService.findById(id);
        if( currentUser == null){
            return new ResponseEntity("not found", HttpStatus.NOT_FOUND);
        }
        currentUser.setName(user.getName());
        currentUser.setPassword(user.getPassword());
        currentUser.setInviterId(user.getInviterId());
//        currentUser.setSubscription(user.getSubscription());
        userService.updateUser(currentUser);
        return new ResponseEntity<Users>(currentUser, HttpStatus.OK);
    }
}
