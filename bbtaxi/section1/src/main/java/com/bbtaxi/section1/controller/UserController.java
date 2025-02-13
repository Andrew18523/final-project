package com.bbtaxi.section1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class UserController {

  @GetMapping(value = "/hello")
  public String greeting(){
    System.out.println("this is greeting!!"); // Log in the cmd which mean the function was run once, you wouldn't see in client side
    return "Hello World!!!!";
  }
}
