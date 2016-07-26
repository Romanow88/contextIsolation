package com.context.configuration.platform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Main configuration for the platform services and beans
 */
@Configuration
@Import({SomeServiceConfig.class, SomeOtherServiceConfig.class})
//or component scan or xml or something
public class PlatformContextConfig
{
  final Log logger = LogFactory.getLog(getClass());

  @Bean
  public String platform()
  {
    logger.info("Starting platform");
    return "string";
  }
}
