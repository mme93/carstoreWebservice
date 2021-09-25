package de.carstorewebservice.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {


    @GetMapping("/registration")
    public String reg(){
        return "Ich regestriere dich!";
    }


}
