package spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import spring.mvc.controller.DemoController;

@Configuration
public class MyWebConfig {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("WEB-INF/view/");
		view.setSuffix(".jsp");
		return view;
	}
	@Bean
	public DemoController demoController() {
		return new DemoController();
	}
}
