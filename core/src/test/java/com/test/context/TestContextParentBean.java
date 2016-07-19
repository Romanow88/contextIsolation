package com.test.context;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by rdoboni on 19.07.2016.
 */
public class TestContextParentBean
{

  @Test
  public void test(){
    ApplicationContext rootContext = new ClassPathXmlApplicationContext("com/test/context/root-context.xml");

    GenericXmlApplicationContext childExport = new GenericXmlApplicationContext();
    childExport.setParent(rootContext);
    childExport.load("com/test/context/child-context-export.xml");
    childExport.refresh();

    GenericXmlApplicationContext childImport = new GenericXmlApplicationContext();
    childImport.setParent(rootContext);
    childImport.load("com/test/context/child-context-import.xml");
    childImport.refresh();

    String importString = childImport.getBean("importTestString", String.class);

    Assert.assertEquals(importString, "Hello from child 1");
    Assert.assertFalse(childImport.containsBean("just-bean"));
  }

}
