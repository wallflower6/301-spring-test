package com.memberson.test.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

// import java.net.http.HttpClient;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

@RestController
public class APIController {

    String apiEndpoint = "https://c21sguat.memgate.com/api/";

    @Value("${svc.auth}")
    String svcAuth;

    @Value("${token}")
    String token;

    @GetMapping("/views")
    public String getListings() {
        HttpClient httpClient;

        // test uri
        String uri = "https://c21sguat.memgate.com/MockRewardApi/reward/1?includeMedia=false&includeRewardPricing=false&includeLinkedItems=false&includeRedeemedItem=false";
        // HttpClient client = new DefaultHttpClient();
        // HttpGet request = new HttpGet(uri);
        // request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        // request.setHeader("SvcAuth", svcAuth);
        // request.setHeader("Token", token);
        // client.execute(request);
        // RestTemplate restTemplate = new RestTemplate();
        // String result = restTemplate.getForObject(uri, String.class);
        // return result;

        // httpClient.DefaultRequestHeaders.Add("Authorization", "SvcAuth=" + svcAuth);
        // httpClient.DefaultRequestHeaders.Authorization = new
        // AuthenticationHeaderValue("SvcAuth", svcAuth);
        // httpClient.DefaultRequestHeaders.Authorization = new
        // AuthenticationHeaderValue("Token", token);

        RestTemplate restTemplate = new RestTemplate();
        
        // create headers
        HttpHeaders headers = new HttpHeaders();
        // set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("SvcAuth", svcAuth);
        headers.set("Token", token);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class, 1);

        // ResponseEntity<Post> response = this.restTemplate.exchange(uri, HttpMethod.GET, request, Post.class, 1);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } 
        
        return "null";
        

        // RestTemplate restTemplate = new RestTemplate();
        // String result = restTemplate.getForObject(uri, String.class);
        // return result;
    }
}
