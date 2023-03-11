
package com.research.datagenerator;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.color.Colour;
import com.research.datagenerator.repo.color.ColourRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Locale;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class ColorApplication implements CommandLineRunner {
	private final ColourRepository colourRepository;

	public static void main(String[] args) {
		SpringApplication.run(ColorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"),new RandomService());


		//Color
		log.info("Color");
		List<String> colors = (List) fakeValuesService.fetchObject("color.name");
		List<Colour> colourList = colors.stream().map(Colour::new).distinct().toList();
		log.info("{}",colourList.size());
		colourRepository.saveAll(colourList);
	}
}

