package com.hulin;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAdviceTest {

	@Test
    public void testBeforceAdvice()
    {
        Artist target = new ArtistImpl();
        BeforeAdvice advice = new MyBeforeAdvice();
        
        ProxyFactory factory = new ProxyFactory();
        //factory.setInterfaces(target.getClass().getInterfaces());
        factory.setOptimize(true);
        factory.setTarget(target);
        factory.addAdvice(advice);
        
        Artist proxy = (Artist)factory.getProxy();
        proxy.singing();
        proxy.dancing();
    }
	
	@Test
    public void testBeforceAdviceByXml()
    {
       String xmlPath = "spring-beans.xml";
       ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
       
       Artist artist = (Artist)context.getBean("artist");
       artist.singing();
       artist.dancing();
    }
}
