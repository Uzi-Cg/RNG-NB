package com.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//测试springmvc的测试环境
@Controller
public class TestSpringmvc {
	@RequestMapping("/testSpringmvc")
    public String testSpringmvc() {
    	System.out.println("Hello SpringMVC");
		return "Ezreal";
    }
}
