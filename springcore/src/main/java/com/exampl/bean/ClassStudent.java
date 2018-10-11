package com.exampl.bean;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ClassStudent {	
	private Class lop;
	private Student hocsinh;
	@Autowired
	public ClassStudent(@Qualifier("class1") Class class1,@Qualifier("student1") Student student1) {
		super();		
		this.lop = class1;
		this.hocsinh = student1;
	}
	@PostConstruct
	public void init() {
		System.out.println("new ClassStudent()");
	}
	
	public Class getLop() {
		return lop;
	}
	public void setLop(Class lop) {
		this.lop = lop;
	}
	public Student getHocsinh() {
		return hocsinh;
	}
	public void setHocsinh(Student hocsinh) {
		this.hocsinh = hocsinh;
	}
	
	
}
