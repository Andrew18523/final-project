package com.bootcamp.demo.bc_yahoo_finance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Close implements Price {
  private Double close;
}
