package com.oracle.spring;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.oracle.entity.User;
public class SpringDemo {
	@Test
	private void testIoc() {
		// TODO Auto-generated method stub
		//创建ioc容器
		Resource resource =new ClassPathResource("/struts/src/applicationContext.xml");
		// 创建容器对象(Bean的工厂), IOC容器 = 工厂类 + applicationContext.xml
		BeanFactory factory= new XmlBeanFactory(resource);
		//获取实体类
		User user= (User)factory.getBean("user");
		System.out.println(user);
	}
	//2. （方便）直接得到IOC容器对象 
	@Test
	public void testIocTwice() throws Exception{
	/*	ApplicationContext ac = new ClassPathXmlApplicationContext("/struts/src/applicationContext.xml");*/
		
	}
}