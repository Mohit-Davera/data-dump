package com.research.datagenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.weather.TemperatureCelsius;
import com.research.datagenerator.entity.weather.TemperatureFahrenheit;
import com.research.datagenerator.entity.weather.WeatherDescription;
import com.research.datagenerator.repo.weather.TemperatureCelsiusRepository;
import com.research.datagenerator.repo.weather.TemperatureFahrenheitRepository;
import com.research.datagenerator.repo.weather.WeatherDescriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Slf4j
@SpringBootApplication
public class WeatherApplication implements CommandLineRunner {

    @Autowired
    WeatherDescriptionRepository weatherDescriptionRepository;
    @Autowired
    TemperatureCelsiusRepository temperatureCelsiusRepository;

    @Autowired
    TemperatureFahrenheitRepository temperatureFahrenheitRepository;

    static final Integer CELSIUS_MAX = 38;
    static final Integer CELSIUS_MIN = -30;

    static final Integer FAHRENHEIT_MAX = 100;
    static final Integer FAHRENHEIT_MIN = -22;

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());

        String fahrenheit = faker.resolve("weather.temperature.fahrenheit");
        String celsius = faker.resolve("weather.temperature.celsius");

        //WeatherDescription
        log.info("WeatherDescription");
        List<String> weatherDescriptions = (List) fakeValuesService.fetchObject("weather.description");
        List<WeatherDescription> weatherDescriptionList = weatherDescriptions.stream().map(WeatherDescription::new).distinct().toList();
        log.info("{}",weatherDescriptionList.size());
        weatherDescriptionRepository.saveAll(weatherDescriptionList);

        //TemperatureCelsius
        log.info("TemperatureCelsius");
        List<TemperatureCelsius> temperatureCelsiuses = new ArrayList<>();
        for (int i = CELSIUS_MIN; i <= CELSIUS_MAX; i++) {
            temperatureCelsiuses.add(new TemperatureCelsius(i + celsius));
        }
        log.info("{}",temperatureCelsiuses.size());
        temperatureCelsiusRepository.saveAll(temperatureCelsiuses);


        //TemperatureFahrenheit
        log.info("TemperatureFahrenheit");
        List<TemperatureFahrenheit> temperatureFahrenheits = new ArrayList<>();
        for (int i = FAHRENHEIT_MIN; i <= FAHRENHEIT_MAX; i++) {
            temperatureFahrenheits.add(new TemperatureFahrenheit(i + fahrenheit));
        }
        log.info("{}",temperatureFahrenheits.size());
        temperatureFahrenheitRepository.saveAll(temperatureFahrenheits);
    }
}

