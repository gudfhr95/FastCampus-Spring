package com.example.springasync.controller;

import com.example.springasync.service.AsyncService;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

  private final AsyncService asyncService;

  public ApiController(AsyncService asyncService) {
    this.asyncService = asyncService;
  }

  @GetMapping("/hello")
  public CompletableFuture hello() {
    log.info("completable future init");
    return asyncService.run();
  }
}
