package com.exampl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.exampl.bean.Class;
import com.exampl.bean.Student;

@Configuration
public class ConfigBean {
	@Bean(name = "class1")
	@Lazy
	public Class createClass1() {
		return new Class("lop01", "10A1");
	}
	
	@Bean(name = "class2")
	public Class createClass2() {
		return new Class("lop02", "10A2");
	}
	@Bean(name = "student1")
	@Lazy
	public Student student1() {
		return new Student("st1", "thai");
	}
	
	@Bean(name ="student2")
	public Student student2() {
		return new Student("st2", "ngoc");
	}
}
