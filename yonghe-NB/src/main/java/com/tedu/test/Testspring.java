package com.tedu.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tedu.pojo.Door;

public class Testspring {
	public void testspring() {
//获取spring的配置文件
	ClassPathXmlApplicationContext ac = 
			new ClassPathXmlApplicationContext(
					"spring/applicationContext.xml");
	//2.获取Door类的实例
	Door door = (Door) ac.getBean("door");
	System.out.println(door);
	
	}

}
