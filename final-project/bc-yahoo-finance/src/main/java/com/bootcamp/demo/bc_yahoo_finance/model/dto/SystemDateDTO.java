package com.bootcamp.demo.bc_yahoo_finance.model.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class SystemDateDTO {
  private String stockName;
  private LocalDate systemDate;
  private Long maxRegularMarketTime;
}
