package com.userdetails.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	 
@PostMapping("/sub")
static int sub()
{
	int a=30;
	int b=20;
	int c=a-b;
	return c;
	}  


@GetMapping("/add")
static int add()
{
	int a=10;
	int b=20;
	
	return a+b;
	}  


}
