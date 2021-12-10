package com.example.server.controller;

import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/server")
public class ServerApiController {

  @GetMapping("/hello")
  public User hello(@RequestParam String name, @RequestParam int age) {
    User user = new User();
    user.setName(name);
    user.setAge(age);
    return user;
  }

  @PostMapping("/user/{userId}/name/{userName}")
  public User post(@RequestBody User user, @PathVariable int userId,
      @PathVariable String userName) {
    log.info("userId : {}, userName : {}", userId, userName);
    log.info("client req : {}", user);
    return user;
  }
}
