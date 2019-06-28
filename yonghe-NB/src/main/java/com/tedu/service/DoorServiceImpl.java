package com.tedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;
@Service
/* 1.标识当前层为service层
 * 2.表示当前类的对象的创建交给Spring容器负责
 * 3.
 */
public class DoorServiceImpl  implements DoorService{
	@Autowired
	/*表示当前类（或接口）的实例将由Spring容器负责创建，
	 * 并赋值给该变量
	 */ 
	private DoorMapper dao;
	/*1.查询所有门店信息*/
	@Override
	public List<Door> findAll() {
		List<Door> list=dao.findAll();
		return list;
	}
	/*2.新增门店信息*/
	@Override
	public void addDoor(Door door) {
		//调用dao层新增门店信息方法
		dao.addDoor( door );
		}
	@Override
	public void deleteDoor(Integer id) {
		// 调用dao层删除门店信息方法
		dao.deleteDoor(id);
		
	}
	@Override
	public Door findById(Integer id) {
		// 调用dao层根据id查询门店信息方法
		Door door= dao.findById(id);
		
		return door;
		}
	@Override
	public void updateById(Door door) {
		dao.updateById(door);
	}

}
