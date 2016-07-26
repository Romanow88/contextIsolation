package com.context.configuration.consumer.licence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by rdoboni on 26.07.2016.
 */
@Configuration
@Import(LicenceService.class)
public class LicenceConfiguration
{

  final Log logger = LogFactory.getLog(getClass());

  @Bean
  public String licence()
  {
    logger.info("Starting licence");
    return "string";
  }
}
