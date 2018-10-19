package com.fangyuan.ch5_2_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch522Application {
	
	@Autowired //可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法
	private Environment env;
	@Autowired
	private AuthorSettings authorSettings;
	
	@RequestMapping("/")
	private String index(){
		//return env.getProperty("author.age");
		return "author name is "+authorSettings.getName()+" and author age is "+authorSettings.getAge();
	}
	
	public static void main(String[] args) {
		//new SpringApplicationBuilder(Ch522Application.class).listeners(new LoadAdditionalProperties()).run(args);
		SpringApplication.run(Ch522Application.class, args);
	}
	
	
}
