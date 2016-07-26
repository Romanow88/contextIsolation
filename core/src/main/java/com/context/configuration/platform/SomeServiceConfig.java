package com.context.configuration.platform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rdoboni on 26.07.2016.
 */
@Configuration
public class SomeServiceConfig
{
  final Log logger = LogFactory.getLog(getClass());

  @Bean
  public String service()
  {
    logger.info("Starting some service");
    return "Some service";
  }
}
