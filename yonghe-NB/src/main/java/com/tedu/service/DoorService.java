package com.tedu.service;

import java.util.List;

import com.tedu.pojo.Door;

public interface DoorService {
	/*1.查询所有门店信息*/
	public List<Door> findAll();
	/*2.新增门店信息*/
	public void addDoor(Door door);
	/*3.删除门店信息*/
	public void deleteDoor(Integer id);
	/*4.查询门店信息*/
	public Door findById(Integer id);
	/*5.更新门店信息*/
	public void updateById(Door door);
	
}
