package com.statrix.rest;

import com.statrix.rest.models.Users;
import org.springframework.web.client.RestTemplate;

public class RestTestClient {

    public static final String REST_SERVICE_URI = "http://localhost:8080/statrix/api/v1/";
    /* GET */
    @SuppressWarnings("unchecked")
    private static void getAdmin(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Users user = restTemplate.getForObject(REST_SERVICE_URI+"info/admin/1", Users.class);
        System.out.println(user);
    }

    public static void main(String args[]){
        getAdmin();
    }
}
