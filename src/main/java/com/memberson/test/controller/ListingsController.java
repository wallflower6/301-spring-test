package com.memberson.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;

@RestController
public class ListingsController {

    @RequestMapping(path="/", method=RequestMethod.GET, produces={ "application/json"})
    public void getListings() {
        String uri = "https://c21sguat.memgate.com/MockRewardApi/reward/1?includeMedia=true&includeRewardPricing=true&includeLinkedItems=true&includeRedeemedItem=false";
    }
}
