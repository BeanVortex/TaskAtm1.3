package com.payeshgaran.TaskAtm12;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @GetMapping
    public String SayHi(){

        return "welcome to first page";

    }

    // you can also define accessibility of users based on their roles or authorities right on methods
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("only-admin")
    public String sayHiToAdmin(){
        return "hi admin";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("only-user")
    public String sayHiToUser(){
        return "hi user";
    }



}
