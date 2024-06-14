package com.oms.studentcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/first")
public class FirstController {
    @GetMapping("/firstapi")
    public String firsApi(){
        return"working";
    }
}
