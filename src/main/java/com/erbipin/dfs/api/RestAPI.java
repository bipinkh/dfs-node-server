package com.erbipin.dfs.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */

@RestController
@RequestMapping("/api/v1/")
public class RestAPI {

    @GetMapping("")
    public String status(){
        return "Rest API Server is running";
    }

}