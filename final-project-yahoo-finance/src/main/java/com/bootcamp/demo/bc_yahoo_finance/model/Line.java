package com.bootcamp.demo.bc_yahoo_finance.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Line {

  private TranType type;

  @Builder.Default
  private List<Point> points = new ArrayList<>();

}
