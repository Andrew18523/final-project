package com.bootcamp.demo.bc_yahoo_finance.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class QuoteResponse {
  private List<Result> result;
  private String error;

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @ToString
  public class Result{
    private String language;
    private String region;
    private String quoteType;
    private String typeDisp;
    private String quoteSourceName;
    private boolean triggerable;
    private String customPriceAlertConfidence;
    private double regularMarketChangePercent;
    private double regularMarketPrice;
    private String marketState;
    private boolean hasPrePostMarketData;
    private long firstTradeDateMilliseconds;
    private int priceHint;
    private double regularMarketChange;
    private long regularMarketTime;
    private double regularMarketDayHigh;
    private String regularMarketDayRange;
    private double regularMarketDayLow;
    private long regularMarketVolume;
    private double regularMarketPreviousClose;
    private double bid;
    private double ask;
    private int bidSize;
    private int askSize;
    private String fullExchangeName;
    private String financialCurrency;
    private double regularMarketOpen;
    private long averageDailyVolume3Month;
    private long averageDailyVolume10Day;
    private double fiftyTwoWeekLowChange;
    private double fiftyTwoWeekLowChangePercent;
    private String fiftyTwoWeekRange;
    private double fiftyTwoWeekHighChange;
    private double fiftyTwoWeekHighChangePercent;
    private double fiftyTwoWeekLow;
    private double fiftyTwoWeekHigh;
    private double fiftyTwoWeekChangePercent;
    private String currency;
    private long earningsTimestamp;
    private long earningsTimestampStart;
    private long earningsTimestampEnd;
    private long earningsCallTimestampStart;
    private long earningsCallTimestampEnd;
    private boolean isEarningsDateEstimate;
    private double trailingAnnualDividendRate;
    private double trailingPE;
    private double dividendRate;
    private double trailingAnnualDividendYield;
    private double dividendYield;
    private double epsTrailingTwelveMonths;
    private double epsForward;
    private double epsCurrentYear;
    private double priceEpsCurrentYear;
    private long sharesOutstanding;
    private double bookValue;
    private double fiftyDayAverage;
    private double fiftyDayAverageChange;
    private double fiftyDayAverageChangePercent;
    private double twoHundredDayAverage;
    private double twoHundredDayAverageChange;
    private double twoHundredDayAverageChangePercent;
    private long marketCap;
    private double forwardPE;
    private double priceToBook;
    private int sourceInterval;
    private int exchangeDataDelayedBy;
    private String averageAnalystRating;
    private boolean tradeable;
    private boolean cryptoTradeable;
    private String exchange;
    private String shortName;
    private String longName;
    private String messageBoardId;
    private String exchangeTimezoneName;
    private String exchangeTimezoneShortName;
    private String market;
    private long gmtOffSetMilliseconds;
    private boolean esgPopulated;
    private String symbol;
  }
}
