package com.context.configuration.consumer.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * mMain configuration for all of the rest services
 */
@Configuration
@Import(RestServices.class)
public class RestConfiguration
{

  final Log logger = LogFactory.getLog(getClass());

  @Autowired
  @Qualifier("service")
  private String someService;

  @Bean
  public String rest()
  {
    logger.info("Starting rest with someService: " + someService);
    return "string";
  }
}
