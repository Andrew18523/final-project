package com.bootcamp.demo.bc_yahoo_finance.service.impl;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_yahoo_finance.entity.StockPriceEntity;
import com.bootcamp.demo.bc_yahoo_finance.exception.LocalError;
import com.bootcamp.demo.bc_yahoo_finance.infra.web.BusinessException;
import com.bootcamp.demo.bc_yahoo_finance.infra.web.redis.RedisHelper;
import com.bootcamp.demo.bc_yahoo_finance.model.dto.SystemDateDTO;
import com.bootcamp.demo.bc_yahoo_finance.repository.StockPriceRepository;
import com.bootcamp.demo.bc_yahoo_finance.service.GetSystemDateService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class GetSystemDateImpl implements GetSystemDateService {

  @Autowired
  private RedisHelper redisHelper;

  @Autowired
  private StockPriceRepository stockPriceRepository;

  @Override
  public LocalDate getSystemDate(String symbol) throws JsonProcessingException {
    String redisKey = "SYSDATE-".concat(symbol);
    String redisSysDate = this.redisHelper.get(redisKey, String.class);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
    if (redisSysDate == null) {
      Long lastMarketTime = stockPriceRepository.getMaxRegularMarketTime(symbol);
      System.out.println("lastMarketTime=" + lastMarketTime);
      if (lastMarketTime == null) {
        throw new BusinessException(LocalError.SYSDATE_NOT_READY,
            "Sysdate is not ready for " + symbol + ".");
      }
      LocalDate dbSysDate = Instant.ofEpochSecond(lastMarketTime.longValue()) //
          .atZone(ZoneId.systemDefault()) //
          .toLocalDate();
      redisHelper.set(redisKey, dbSysDate.format(format),28800L);
      return dbSysDate;
    }
    return LocalDate.parse(redisSysDate, format);
  }
  
  
}
