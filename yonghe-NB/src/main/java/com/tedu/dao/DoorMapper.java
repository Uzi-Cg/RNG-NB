package com.tedu.dao;

import java.util.List;

import com.tedu.pojo.Door;

//Mapper接口
public interface DoorMapper {
    /*查询所有门店信息*/
	public List<Door> findAll();
	/*2.新增门店信息*/
	public void addDoor(Door door);
	/*3.删除门店信息*/
	public void deleteDoor(Integer id);
	/*3.查询门店信息*/
	public Door findById(Integer id);
	/*3.更新门店信息*/
	public Door updateById(Door door); 
}
