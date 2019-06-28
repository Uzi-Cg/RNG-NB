package com.tedu.mybatis;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.tedu.pojo.Emp;

/**
 *mybatis快速入门
 *单元测试的方法要求符合以下条件
 *1方法必须是公共的
 *2.方法必须是无返回值
 *3.方法必须是非静态的
 *4.方法必须是无参的
 *
 *
 *
 */
public class TestMybatis3 {
	private SqlSessionFactory factory;
	@Before
	public void bef() throws Exception {
		//1.读取mybatis的核心配置文件
		InputStream in=Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.通过配置信息获取工厂对象
		factory = new SqlSessionFactoryBuilder().build(in);

	}
	/*往emp表中新加一个新员工*/
	@Test
	public void testInsert() {
		/*1.获取sql对象*/
		SqlSession session=factory.openSession(); 
		/*2.执行新语句*/
		//将参数封装到Emp对象中
		Emp emp = new Emp();
		emp.setName("程功");
		emp.setJob("职业adc");
		emp.setSalary(15000.00);
		int rows=session.insert("com.tedu.pojo.EmpMapper.insert2",emp);
		/*3.输出结果*/
		System.out.println("影响的行数:"+rows);
		/*4.提交事务*/
		session.commit();
	}
	@Test
	public void testUpdate() {
		//获取Session对象
		SqlSession session = factory.openSession();
		//执行语句
		Emp emp = new Emp();
		emp.setName("程功");
		emp.setJob("世界第一上单");
		emp.setSalary(16000.00);
		int rows=session.update("com.tedu.pojo.EmpMapper.update2",emp);
		System.out.println(rows);
		session.commit();
	}
	@Test
	public void testDelete() {
		//获取SqlSession对象
		SqlSession session=factory.openSession();
		//执行删除的sql语句
		int rows=session.update("com.tedu.pojo.EmpMapper.delete2","刘沛霞");
		//输出结果
		System.out.println(rows);
		//提交事务
		session.commit();
	}
	@Test
	public void testFindAll() {
		//获取sqlSession对象
		SqlSession session=factory.openSession();
		//执行查询sql
		HashMap map = new HashMap();
		map.put("minSal", 15000.00);
		map.put("maxSal", 18000.00);
		List<Emp> list=session.selectList("com.tedu.pojo.EmpMapper.findAll3",map);
		//输出结果
		for(Emp emp:list) {
			System.out.println(emp);
		}
	}
	@Test
	public void testFindAll5() {
		//获取SqlSession对象
				SqlSession session=factory.openSession();
				//执行sql
				HashMap map = new HashMap();
				map.put("name", "涛");
				List<Emp> list=session.selectList("com.tedu.pojo.EmpMapper.findAll3",map);
				for(Emp emp:list) {
					System.out.println(emp);
				}
    }
	public void testFindAll6() {
		//获取SqlSession
		SqlSession session=factory.openSession();
		//执行sql
		HashMap map = new HashMap();
		map.put("minSal", 3000);
		map.put("maxSal", 18000);
		List<Emp> list=session.selectList("com.tedu.pojo.EmpMapper.findAll6",map);
		for(Emp emp:list) {
			System.out.println(emp);
		}
	}
	public void testUpdate3() {
		//获取SqlSession
		SqlSession session=factory.openSession();
		//执行sql
		Emp emp = new Emp();
		//emp.setName("涛哥");
		emp.setJob("法师");
		emp.setSalary(15000.0);
		int rows=session.update("com.tedu.pojo.EmpMapper.update3",emp);
		System.out.println("影响的行数"+rows);
		//提交
		session.commit();
	}
	public void testDeleteByIds() {
		//获取SqlSession 对象
		SqlSession session=factory.openSession();
		//执行删除SQL，批量删除员工信息
		//>> 声明一个数组  包含所有删除员工的ID
		Integer[] ids= {2,4,6,8};
		int rows=session.update("com.tedu.pojo.EmpMapper",ids);
		System.out.println("影响的行数"+rows);
		//提交
		session.commit();
	}
}

