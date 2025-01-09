package com.bootcamp.demo.bc_yahoo_finance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Candle implements Price {
  private Double open;
  private Double close;
  private Double high;
  private Double low;
  
}
