package com.erbipin.dfs.api;

import com.erbipin.dfs.model.dto.SubscriptionDto;
import com.erbipin.dfs.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
@RestController
@RequestMapping("/node-api/v1/")
public class NodeRestApi {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping("/ping")
    public String checkStatus(){
        return "Admin api service is running";
    }

    @PostMapping("/subscription/add")
    public SubscriptionDto addSubscriptionPackage(@RequestBody SubscriptionDto subsRequest){
        return subscriptionService.addPackage(subsRequest);
    }

    @GetMapping("/subscription")
    public SubscriptionDto addSubscriptionPackage(@RequestParam String subscriptionId){
        return subscriptionService.getPackage(Long.valueOf(subscriptionId));
    }

}
