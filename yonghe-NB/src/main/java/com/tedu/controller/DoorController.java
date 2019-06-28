package com.tedu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;
import com.tedu.service.DoorService;
/*门店管理模块*/
@Controller
/*测试ssm开发环境*/
public class DoorController {
	@Autowired 
	/*自动装配:由spring容器创建
	该类（或接口）的实例，并赋值给当前变量*/
	private DoorService service;
	//1.查询所有门店
	@RequestMapping("/doorList")
	public String doorList(Model model) {
		//查询所有门店信息，返回List<Door>
		List<Door> list=service.findAll();
		//输出所有门店信息存入model中
		model.addAttribute("doorlist", list);
		for(Door door:list) {
			System.out.println(door);
		}
		//转向door_jsp
		return "door_list";
	}
	/* 通用的跳转方法
	 * 如果用户访问的路径为/index /_top
	 * 则page的值就是index top
	 */
	@RequestMapping("/{page}")
	public String page(@PathVariable String page) {
		return page;
	}
	//2.新增门店信息
	@RequestMapping("doorAdd")
	public String doorAdd(Door door,Model model) {
		//1.调用service层新增门店的方法
		service.addDoor( door );
		//调用doorList方法
		return doorList(model);
		//转发doorList方法
		//return "forward:/doorList";
		//转发doorList方法
		//return "redirect:/doorList";
	}
	//3.删除门店信息
	@RequestMapping("doorDelete")
	public String doorDelete(Integer id) {
		service.deleteDoor(id);
		return "forward:/doorList";
	}
	//4.根据id查询门店信息
	@RequestMapping("doorInfo")
	public String doorInfo(Model model,Integer id) {
		//调用service层的根据id查询门店信息
		Door door = service.findById(id);
		//将门店存入model中
		model.addAttribute("door",door);
		//转向修改页面
		return"door_update";
	}
	//5.根据id修改门店信息
	@RequestMapping("doorUpdate")
	public String doorUpdate(Door door) {
		//调用service层的根据id更新门店信息
		service.updateById(door);
		return "redirect:/doorList";
	}

}


