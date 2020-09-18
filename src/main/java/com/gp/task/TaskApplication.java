package com.gp.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories(value = "com.gp.task.repository")
public class TaskApplication {
	public static void main(String[] args) {
	    SpringApplication.run(TaskApplication.class, args);
	}
}
