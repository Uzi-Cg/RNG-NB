package com.tedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

public class TestMybatis {
	public static void main(String[] args) throws Exception {
		// 1.读取mybatis-config.xml文件
		InputStream in=Resources.getResourceAsStream("mabatis/mybatis-config.xml");
		//获取SqlSessionFactoryBuilder()
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		SqlSession session=factory.openSession();
		//获取Mapper接口子类的实例
		DoorMapper mapper=session.getMapper(DoorMapper.class);
		List<Door> list=mapper.findAll();
		for(Door door:list) {
			System.out.println(door);
		}
	}
}
