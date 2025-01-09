package com.bootcamp.demo.bc_yahoo_finance.infra.web.util;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTPS("https"),//
  HTTP("http"),//
  ;

  private String scheme;

  private Scheme(String scheme){
    this.scheme=scheme;
  }
  
}
