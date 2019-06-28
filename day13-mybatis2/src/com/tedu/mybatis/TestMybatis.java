package com.tedu.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tedu.pojo.Emp;

/**
 *mybatis快速入门
 */
public class TestMybatis {
	public static void main(String[] args) {
		/**1.查询Emp表中的所有员工信息，将所有员工信息封装到
		 * List集合，并输出list集合*/
		
		//1.读取Mybatis核心配置文件(sqlMapConfig.xml)
		try {
			InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");		
		//2.通过配置信息获取SqlSessionFactory对象
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.通过factory获取SqlSession对象
			SqlSession session = factory.openSession();
		//4.执行查询Sql获取所有员工信息的List集合
			List<Emp> list = session.selectList("com.tedu.pojo.EmpMapper.selectAll");
		//5.遍历集合，输出所有员工信息
			for(Emp emp:list) {
				System.out.println(emp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
