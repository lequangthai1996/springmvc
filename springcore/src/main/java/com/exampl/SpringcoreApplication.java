package com.exampl;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import com.exampl.bean.ClassStudent;



@ComponentScan({"com.exampl.bean", "com.exampl.config"})
public class SpringcoreApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringcoreApplication.class);
		System.out.println("Before init class-student");
		ClassStudent bean = context.getBean(ClassStudent.class);
		System.out.println("ClassStudent bean:" + System.identityHashCode(bean));
		ClassStudent bean2 = context.getBean(ClassStudent.class);
		System.out.println("ClassStudent bean2: " + System.identityHashCode(bean2));
		System.out.println("getLop bean" + System.identityHashCode(bean.getLop()));
	}
	@PostConstruct
	public void init() {
		System.out.println("new SpringcoreApplication()");
	}
	

//Ta sẽ nhận thấy rằng, khi ta new AnnotationConfig và truyền tham số class vào thì nó đã tự đăng kí class
// SpringcoreApplication là bean , ta không cần phải annotation nó là @Configuration gì cả, sau đó có 
// ComponentScan qua 2 package , rồi tạo bean cho class2 và student2 vì cả 2 không được chỉ thị @Lazy
//mà ko tạo bean cho class1,student1 và ClassStudent vì đánh dấu @Lazy, khi ta getBean(ClassStudent) thì
// nó @Autowired và tạo bean cho class1 và student1, sau khi ta get bean tiếp ClassStudent thì vẫn nhận
// một bean vì là singleton theo mặc định
}
