package com.statrix.rest.RestClient;

import com.statrix.rest.models.Persons;
import com.statrix.rest.models.Sites;
import com.statrix.rest.models.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author Uliana
 * В запросы должен передаваться ID ползьзователя, так как по сути только он меняется.
 * Его можно либо передавать в параметрах метода, либо получать через getID.
 * Так же пока методы ничего не возвращают, а просто выводят в консоль. В дальнейшем, надо будет это исправить.
 */

public class ClientClass {
    private static final String REST_SERVICE_URI = "https://statrix.com/API/V1/";

    /* GET */
    @SuppressWarnings("unchecked")
    private void listAllSites(long id) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> response = restTemplate.getForEntity(REST_SERVICE_URI + "/info/sx_user/{userId}/sx_sites", List.class, id);

        if (response.getStatusCode() == HttpStatus.OK) {
            List<Sites> sites = response.getBody();
            System.out.println("result size:" + sites.size());
        } else {
            System.out.println("No sites exist----------");
        }
    }

    /* GET */
    @SuppressWarnings("unchecked")
    private void listAllStatisticks(long id) {


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> response = restTemplate.getForEntity(REST_SERVICE_URI + "/info/sx_user/{userId}/stats", List.class, id);

        if (response.getStatusCode() == HttpStatus.OK) {
            List<Object> sites = response.getBody();
        } else {
            System.out.println("No sites exist----------");
        }
    }

    /* GET */
    private void getUser(long id) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Users> response = restTemplate.getForEntity(REST_SERVICE_URI + "/info/sx_user/", Users.class, id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Users user = response.getBody();
            System.out.println(user);
        } else {
            System.out.println("No such user exist----------");

        }


    }

    /* GET */
    @SuppressWarnings("unchecked")
    private void listAllPersons(long id) {


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> response = restTemplate.getForEntity(REST_SERVICE_URI + "/info/sx_user/{userId}/sx_persons", List.class, id);
        if (response.getStatusCode() == HttpStatus.OK) {
            List<Persons> persons = response.getBody();

        } else {
            System.out.println("No persons exist----------");
        }
    }

    /* POST */
    private static void createUser(long id) {

        RestTemplate restTemplate = new RestTemplate();

        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/sx_user/", id, Users.class);
        System.out.println("Location : " + uri.toASCIIString());
    }

    //
    /* PUT */
    private static void updateUser(Users user) {

        RestTemplate restTemplate = new RestTemplate();

        if (user.getSubscription() != null) {

            restTemplate.put(REST_SERVICE_URI + "/info/{sx_user}/" + user.getId(), "/admin/" + user.getId(), Users.class);
            System.out.println(user);
        } else {
            System.out.println("Please upgrade to admin!");
        }
    }

    /* DELETE */
    private void deleteUser(long id) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete(REST_SERVICE_URI + "/sx_user/" + id);
            System.out.println("User " + id + "was deleted");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}


