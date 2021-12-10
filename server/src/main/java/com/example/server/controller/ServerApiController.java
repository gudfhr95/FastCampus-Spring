package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
  public Req<User> post(
//      HttpEntity<String> entity,
      @RequestBody Req<User> user,
      @PathVariable int userId,
      @PathVariable String userName,
      @RequestHeader("x-authorization") String authorization,
      @RequestHeader("custom-header") String customHeader
  ) {
//    log.info("req: {}", entity.getBody());
    log.info("userId : {}, userName : {}", userId, userName);
    log.info("authorization : {}, custom : {}", authorization, customHeader);
    log.info("client req : {}", user);

    Req<User> response = new Req<>();
    response.setHeader(new Req.Header());
    response.setResBody(user.getResBody());

    return response;
  }
}
