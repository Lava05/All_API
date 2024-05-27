package com.trial.springboot.Hellotry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {
    String username = "Lavanya";
    String password = "Lava@123";

    @GetMapping("/login/{un}/{pass}")
    public  String welcome(@PathVariable ("un") String uname, @PathVariable ("pass") String pass)
    {
        System.out.println(uname);
        System.out.println(pass);
        if(username.equals(uname) && password.equals(pass))
        {
            return "valid user";
        }
        else {
            return "invalid user";
        }
    }
}
