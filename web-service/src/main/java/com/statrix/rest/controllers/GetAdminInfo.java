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
public class GetAdminInfo {

    @Autowired
    UserService userService;

    @RequestMapping(value = "admin/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAdminInfo(@PathVariable("id") long id){
        Users admin = userService.findById(id);
        if( admin == null){
            return new ResponseEntity("not found", HttpStatus.NOT_FOUND);
        }
//        return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity<Users>(admin, HttpStatus.OK);
    }
}
