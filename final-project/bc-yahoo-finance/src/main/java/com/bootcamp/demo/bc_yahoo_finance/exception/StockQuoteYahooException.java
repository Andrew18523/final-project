package com.bootcamp.demo.bc_yahoo_finance.exception;

import com.bootcamp.demo.bc_yahoo_finance.infra.web.BusinessException;
import com.bootcamp.demo.bc_yahoo_finance.infra.web.ErrorCode;
import com.bootcamp.demo.bc_yahoo_finance.infra.web.GeneralError;
import com.bootcamp.demo.bc_yahoo_finance.model.dto.YahooQuoteErrorDTO;

public class StockQuoteYahooException extends BusinessException {
  public StockQuoteYahooException(YahooQuoteErrorDTO quoteErrorDTO) {
    super(GeneralError.REST_CLIENT_EX,
        quoteErrorDTO.getBody().getError().getMessage());
  }
}

