package com.bootcamp.demo.bc_yahoo_finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_yahoo_finance.infra.web.redis.RedisHelper;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class QuoteDataOperation {
  
  @Autowired
  private RedisHelper redisHelper;

  @GetMapping("/redis")
  public String[] getMethodName() throws JsonProcessingException {
      return redisHelper.get("STOCK-LIST", String[].class);
  }
}
