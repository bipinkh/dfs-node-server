package com.erbipin.dfs.api;

import com.erbipin.dfs.model.dto.SubscribeRequest;
import com.erbipin.dfs.model.dto.UserSubscriptionDto;
import com.erbipin.dfs.service.SubscriberService;
import com.erbipin.dfs.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */

@RestController
@RequestMapping("/api/v1/")
public class ClientRestApi {

    @Autowired
    SubscriberService subscriberService;

    @GetMapping("")
    public String status(){
        return "Rest API Server is running";
    }

    @GetMapping("/ping")
    public String ping(){
        return "Online.";
    }

    @PostMapping("/subscribe/new")
    public UserSubscriptionDto newSubscription(@RequestBody SubscribeRequest subscribeRequest){
        return subscriberService.createSubscription(subscribeRequest);
    }

    @GetMapping("/subscribe/view")
    public UserSubscriptionDto newSubscription(@RequestParam String userKey){
        return subscriberService.viewSubscription(userKey);
    }

    @GetMapping("/unsubscribe")
    public UserSubscriptionDto unsubscribe(@RequestParam String userKey){
        return subscriberService.unsubscribe(userKey);
    }





}
