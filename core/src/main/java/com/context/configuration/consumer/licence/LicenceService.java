package com.context.configuration.consumer.licence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rdoboni on 26.07.2016.
 */
@Configuration
public class LicenceService
{
  final Log logger = LogFactory.getLog(getClass());

  @Bean
  public String licenceServiceBean()
  {
    logger.info("Starting licence service");
    return "string";
  }
}
