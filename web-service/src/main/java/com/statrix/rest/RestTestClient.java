package com.statrix.rest;

import com.statrix.rest.models.Subscriptions;
import com.statrix.rest.models.Users;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class RestTestClient {

    public static final String REST_SERVICE_URI = "http://localhost:8080/statrix/api/v1/";
    /* GET */
    @SuppressWarnings("unchecked")
    private static void getAdmin(Long id){
        RestTemplate restTemplate = new RestTemplate();
        Users user = restTemplate.getForObject(REST_SERVICE_URI+"info/admin/" + id, Users.class);
        System.out.println(user);
    }

    private static void createUser(Users user){
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "sx_user/", user, Users.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    private static void getUser(Long id){
        RestTemplate restTemplate = new RestTemplate();
        Users user = restTemplate.getForObject(REST_SERVICE_URI+"info/sx_user/" + id, Users.class);
        System.out.println(user);
    }

    private static void updateUser(Long id, Users updatedUser){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(REST_SERVICE_URI + "/sx_user/" + id , updatedUser);
    }

    private static void deleteUser(Long id){
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/sx_user/" + id);
    }

    public static void main(String args[]){
        System.out.println("Testing API----------");
//        getAdmin(new Long(1));
//        getUser(new Long(2));
//        updateUser(new Long(2));
//        getUser(new Long(2));
//        createUser();
//        deleteUser(new Long(4));
        createUser( new Users("UserMasha","123@m.ru","qwerty"));
        updateUser( 4L, new Users( 4L , "UserMashaUpdated", "123@m.ru", "qwerty123"));
        getUser(4L);

    }
}
