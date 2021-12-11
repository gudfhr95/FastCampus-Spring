package com.example.springswagger.controller;

import com.example.springswagger.dto.UserReq;
import com.example.springswagger.dto.UserRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }

  @ApiImplicitParams({
      @ApiImplicitParam(name = "x", value = "x 값", required = true, dataType = "int", paramType = "path"),
      @ApiImplicitParam(name = "y", value = "y 값", required = true, dataType = "int", paramType = "query")
  })
  @GetMapping("/plus/{x}")
  public int plus(@PathVariable int x, @RequestParam int y) {
    return x + y;
  }

  @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일때")
  @ApiOperation(value = "사용자의 이름과 나이를 리턴하는 메소드")
  @GetMapping("/user")
  public UserRes user(UserReq userReq) {
    return new UserRes(userReq.getName(), userReq.getAge());
  }

  @PostMapping("/user")
  public UserRes userPost(@RequestBody UserReq req) {
    return new UserRes(req.getName(), req.getAge());
  }
}
