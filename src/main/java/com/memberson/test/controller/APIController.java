package com.memberson.test.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.memberson.test.Member;

import org.apache.catalina.connector.Response;
// import java.net.http.HttpClient;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Component
@RestController
public class APIController {

    String apiEndpoint = "https://c21sguat.memgate.com/api/";

    @Value("${svc.auth}")
    String svcAuth;

    @Value("${token}")
    String token;

    @RequestMapping(value="/signup",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void signUp(@RequestBody String details) {
        JSONParser parser = new JSONParser();
        JSONObject detailsJSON = new JSONObject();

        try {
            detailsJSON = (JSONObject) parser.parse(details);
        } catch (ParseException e) {
            System.out.println(e);
            return;
        }

        String uri = apiEndpoint + "profile/create-with-membership";
        JSONObject customer = postURI(detailsJSON, uri);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Unable to create member");
        }
    }

    // Triggers when login button is clicked on homepage (localhost:8080)
    @RequestMapping(value="/login",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void logIn(@RequestBody String password) {
        JSONObject pwdJson = new JSONObject();
        JSONParser parser = new JSONParser();

        try {
            pwdJson = (JSONObject) parser.parse(password);
        } catch (ParseException e) {
            
        }

        String uri = apiEndpoint + "profile/01820932/signin";
        JSONObject customer = postURI(pwdJson, uri);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("No such member");
        }
    }

    // POST REQUESTS
    public JSONObject postURI(JSONObject obj, String uri) {
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("SvcAuth", svcAuth);
        headers.set("Token", token);
        HttpEntity<String> request = new HttpEntity<>(obj.toString(), headers);

        ResponseEntity<String> response = null;
        try {
            response = restTemplate.postForEntity(uri, request, String.class);
            System.out.println(response.getBody());
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something went wrong.");
        }
        
        JSONParser parser = new JSONParser();

        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                JSONObject json = (JSONObject) parser.parse(response.getBody());
                return json;
            } catch (ParseException e) {
                return null;
            }
        } 

        return null;
    }

    // GET REQUESTS
    public JSONObject getURI(String uri) {
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("SvcAuth", svcAuth);
        headers.set("Token", token);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class, 1);

        JSONParser parser = new JSONParser();

        if (response.getStatusCode() == HttpStatus.OK) {
            try {
                JSONObject json = (JSONObject) parser.parse(response.getBody());
                System.out.println(json);
                return json;
            } catch (ParseException e) {
                return null;
            }
        } 

        return null;
    }
}
