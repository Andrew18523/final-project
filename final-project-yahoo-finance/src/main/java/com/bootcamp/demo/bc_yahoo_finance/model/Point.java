package com.bootcamp.demo.bc_yahoo_finance.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Point<T extends Price> {
  private LocalDateTime time;
  private T price;

  public static void main(String[] args) {
    Point <Candle> point = new Point<>();
    Point<Close> point2 = new Point<>();
  }
}
