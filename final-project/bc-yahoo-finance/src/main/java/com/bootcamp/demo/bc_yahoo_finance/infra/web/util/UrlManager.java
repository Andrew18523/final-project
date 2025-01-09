package com.bootcamp.demo.bc_yahoo_finance.infra.web.util;

import org.springframework.web.util.UriComponentsBuilder;

public class UrlManager {
  private Scheme scheme;
  private String domain;
  private String endpoint;

  // @Override
  // public String toString() {
  //   return this.scheme.getUrlPrefix() //
  //       .concat(this.domain) //
  //       .concat(this.endpoint);

  private UrlManager(Builder builder) {
    this.scheme = builder.scheme == null ? Scheme.HTTPS : builder.scheme;
    this.domain = builder.domain;
    this.endpoint = builder.endpoint;
  }

  public static UrlManager.Builder builder() {
    return new Builder();
  }

  public String toUriString() {
    return UriComponentsBuilder.newInstance() //
      .scheme(this.scheme.name().toLowerCase()) // https
      .host(this.domain) // www.apple.com
      .path(this.endpoint) // "/user"
      .toUriString();
  }

  public static class Builder {
    private Scheme scheme;
    private String domain;
    private String endpoint;

    public Builder scheme(Scheme scheme) {
      this.scheme = scheme;
      return this;
    }

    public Builder domain(String domain) {
      this.domain = domain;
      return this;
    }

    public Builder endpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    public UrlManager build() {
      return new UrlManager(this);
    }
  }
}
