package com.barry.springboot.MyBoot2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	@RequestMapping("/hello")
	public String index() {
		
		return "hello, my boot2";
	}
	
}
