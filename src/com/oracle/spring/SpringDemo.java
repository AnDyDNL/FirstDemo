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
		//����ioc����
		Resource resource =new ClassPathResource("/struts/src/applicationContext.xml");
		// ������������(Bean�Ĺ���), IOC���� = ������ + applicationContext.xml
		BeanFactory factory= new XmlBeanFactory(resource);
		//��ȡʵ����
		User user= (User)factory.getBean("user");
		System.out.println(user);
	}
	//2. �����㣩ֱ�ӵõ�IOC�������� 
	@Test
	public void testIocTwice() throws Exception{
	/*	ApplicationContext ac = new ClassPathXmlApplicationContext("/struts/src/applicationContext.xml");*/
		
	}
}