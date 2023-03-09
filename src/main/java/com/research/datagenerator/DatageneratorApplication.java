package com.research.datagenerator;

import com.github.javafaker.*;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.Colour;
import com.research.datagenerator.entity.Department;
import com.research.datagenerator.entity.ProductName;
import com.research.datagenerator.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@SpringBootApplication
public class DatageneratorApplication implements CommandLineRunner {


	@Autowired
	DepartmentRepository departmentRepository;
	public static void main(String[] args) {
		SpringApplication.run(DatageneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Faker faker =new Faker(new Locale("en"));
		int count = 0;
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"),new RandomService());
		List<Department> departments = new ArrayList<>();
		for (long i = 0; i < 1000000; i++) {
			Department department = new Department();
			String name = fakeValuesService.resolve("commerce.product_name.adjective", fakeValuesService, faker);
			department.setName(name);
			departments.add(department);
		}
		List<Department> collect = departments.stream().distinct().collect(Collectors.toList());
		System.out.println(collect);
		System.out.println(collect.size());
		//departmentRepository.saveAll(collect);
	}
}
