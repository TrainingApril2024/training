package com.apex.BasicSpringProject.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class PersonFieldInjection {
	
	@Value("Sham")
	private String name;
	@Value("21")
	private int age;
	@Value("San Jose")
	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", city=" + city + "]";
	}

	@PostConstruct
	public void init() {
		System.out.println("Entered into Init Method for PersonFieldInjection");
	}
	
	@PreDestroy
	public void destory() {
		System.out.println("Entered into destory Method for PersonFieldInjection");
	}
}
