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
@RequestMapping("statrix/api/v1/")
public class DeleteUser {

    @Autowired
    UserService userService;

    @RequestMapping(value = "sx_user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){

        Users user = userService.findById(id);
        if( user == null){
            return new ResponseEntity("Unable to delete. User with id " + id + " not found.",
                    HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
    }
}
