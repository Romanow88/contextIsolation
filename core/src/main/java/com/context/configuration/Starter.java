package com.context.configuration;

import com.context.configuration.consumer.licence.LicenceConfiguration;
import com.context.configuration.consumer.rest.RestConfiguration;
import com.context.configuration.platform.PlatformContextConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@EnableAutoConfiguration(exclude = DispatcherServletAutoConfiguration.class)
@Import(PlatformContextConfig.class)
public class Starter
{

  //main entry point which should get called by the initializer
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Starter.class);
  }


  @Bean
  public ServletRegistrationBean rest() {
    DispatcherServlet dispatcherServlet = new DispatcherServlet();

    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    applicationContext.register(RestConfiguration.class); //child 1
    dispatcherServlet.setApplicationContext(applicationContext);

    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/rest/*");
    servletRegistrationBean.setName("platform-rest");

    return servletRegistrationBean;
  }

  @Bean
  public ServletRegistrationBean licence() {
    DispatcherServlet dispatcherServlet = new DispatcherServlet();

    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    applicationContext.register(LicenceConfiguration.class);
    dispatcherServlet.setApplicationContext(applicationContext);

    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/licence/*");
    servletRegistrationBean.setName("platform-licence");

    return servletRegistrationBean;
  }



}
