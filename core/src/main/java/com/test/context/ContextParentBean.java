package com.test.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by rdoboni on 19.07.2016.
 */
public class ContextParentBean implements Registry, ApplicationContextAware, DisposableBean, ApplicationListener<ApplicationEvent>
{

  private static final Logger log = LoggerFactory.getLogger(ContextParentBean.class);

  protected ApplicationContext context;
  protected ConfigurableListableBeanFactory beanFactory;

  protected GenericApplicationContext registry;



  @Override
  public Void export(String name, Object target) {
    log.debug("Exporting bean '{}'", name);


    if (!registry.containsBean(name)) {
      beanFactory.registerSingleton(name, target);
    }
    return null;
  }


  @Override
  public <T> T lookup(String name, Class<T> clazz) {
    log.debug("Looking up bean '{}' with interface '{}'", name, clazz.getSimpleName());


    if (!registry.containsBean(name)) {
      throw new IllegalArgumentException("Resource not found.");
    }

    return registry.getBean(name, clazz);
  }

  @Override
  public void destroy() throws Exception
  {
    registry.close();
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
  {
    this.context = applicationContext;
    this.registry = new GenericApplicationContext();
    this.beanFactory = registry.getBeanFactory();
  }

  @Override
  public void onApplicationEvent(ApplicationEvent event)
  {
    if (event instanceof ContextRefreshedEvent) {
      if (context.equals(((ContextRefreshedEvent) event).getApplicationContext())) {
        registry.refresh();
      }
    }
  }
}
