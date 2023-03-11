package com.research.datagenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.Food;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.food.*;
import com.research.datagenerator.repo.food.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;


@Slf4j
@SpringBootApplication
public class FoodApplication implements CommandLineRunner {

    @Autowired
    DescriptionRepository descriptionRepository;
    @Autowired
    DishRepository dishRepository;
    @Autowired
    FruitRepository fruitRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    SpiceRepository spiceRepository;
    @Autowired
    SushiRepository sushiRepository;
    @Autowired
    VegetableRepository vegetableRepository;


    public static void main(String[] args) {
        SpringApplication.run(FoodApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
        Food food = faker.food();

        //Description
        log.info("Description");
        List<String> descriptions = (List) fakeValuesService.fetchObject("food.descriptions");
        List<Description> descriptionList = descriptions.stream().map(Description::new).distinct().toList();
        log.info("{}",descriptionList.size());
        descriptionRepository.saveAll(descriptionList);

        //Dish
        log.info("Dish");
        List<String> dishes = (List) fakeValuesService.fetchObject("food.dish");
        List<Dish> dishList = dishes.stream().map(Dish::new).distinct().toList();
        log.info("{}",dishList.size());
        dishRepository.saveAll(dishList);

        //Fruit
        log.info("Fruit");
        List<String> fruits = (List) fakeValuesService.fetchObject("food.fruits");
        List<Fruit> fruitList = fruits.stream().map(Fruit::new).distinct().toList();
        log.info("{}",fruitList.size());
        fruitRepository.saveAll(fruitList);


        //Ingredient
        log.info("Ingredient");
        List<String> ingredients = (List) fakeValuesService.fetchObject("food.ingredients");
        List<Ingredient> ingredientList = ingredients.stream().map(Ingredient::new).distinct().toList();
        log.info("{}",ingredientList.size());
        ingredientRepository.saveAll(ingredientList);

        //Measurement
        log.info("Measurement");
        Set<Measurement> measurements = new HashSet<>();
        for (long i = 0; i < 1000; i++) {
            Measurement measurement = new Measurement();
            String name = food.measurement();
            measurement.setName(name);
            measurements.add(measurement);
        }
        List<Measurement> measurementList = measurements.stream().distinct().toList();
        log.info("{}",measurementList.size());
        measurementRepository.saveAll(measurementList);


        //Spice
        log.info("Spice");
        List<String> spices = (List) fakeValuesService.fetchObject("food.spices");
        List<Spice> spiceList = spices.stream().map(Spice::new).distinct().toList();
        log.info("{}",spiceList.size());
        spiceRepository.saveAll(spiceList);


        //Sushi
        log.info("Sushi");
        List<String> sushies = (List) fakeValuesService.fetchObject("food.sushi");
        List<Sushi> sushiList = sushies.stream().map(Sushi::new).distinct().toList();
        log.info("{}",sushiList.size());
        sushiRepository.saveAll(sushiList);


        //Vegetable
        log.info("Vegetable");
        List<String> vegetables = (List) fakeValuesService.fetchObject("food.vegetables");
        List<Vegetable> vegetableList = vegetables.stream().map(Vegetable::new).distinct().toList();
        log.info("{}",vegetableList.size());
        vegetableRepository.saveAll(vegetableList);
    }
}

