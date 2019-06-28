package com.tedu.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.tedu.pojo.Emp;

public class TestMybatis2 {
	private InputStream in ;		
	//2.通过配置信息获取SqlSessionFactory对象
	private	SqlSessionFactory factory ;
	@Before
	public void bef() {
		 try {
			in = Resources.getResourceAsStream("sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
	}
	//新增一个员工 
	@Test
	public void testInsert() {
		SqlSession session = factory.openSession();
		int rows = session.insert("com.tedu.pojo.EmpMapper.insert");
		System.out.println("影响的行数："+rows);
		session.commit();
	}
	@Test
	public void testUpdate() {
		SqlSession session = factory.openSession();
		int rows = session.insert("com.tedu.pojo.EmpMapper.update");
		System.out.println("影响的行数："+rows);
		session.commit();
	}
	@Test
	public void testFindById() {
		SqlSession session = factory.openSession();
		List<Emp> list1 = session.selectList("com.tedu.pojo.EmpMapper.FindById", 10);
		for(Emp emp:list1) {
			System.out.println(emp);
		}
	}

}
