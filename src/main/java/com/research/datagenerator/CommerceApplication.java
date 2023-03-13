package com.research.datagenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.Commerce.*;
import com.research.datagenerator.repo.commerceRepository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class CommerceApplication  implements CommandLineRunner {


    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    ProductNameRepository productNameRepository;

    @Autowired
    PromotionCodeAdjective2Repository promotionCodeAdjective2Repository;

    @Autowired
    CommerceAdjectiveRepository commerceAdjectiveRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    PromotionCodeRepository promotionCodeRepository;


    public static void main(String[] args) {
        SpringApplication.run(CommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());

        log.info("Material");
        List<Material> materials = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            Material material = new Material();
            String name = fakeValuesService.resolve("commerce.product_name.material", fakeValuesService, faker);
            material.setName(name);
            materials.add(material);

        }
        List<Material> collect = materials.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect.size());
        materialRepository.saveAll(collect);

        log.info("ProductName");
        List<ProductName> productNames = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            ProductName businessCreditCardType = new ProductName();
            String name = fakeValuesService.resolve("commerce.product_name.product", fakeValuesService, faker);
            businessCreditCardType.setName(name);
            productNames.add(businessCreditCardType);

        }
        List<ProductName> collect4 = productNames.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect4.size());
        productNameRepository.saveAll(collect4);

        log.info("PromotionCode");
        List<PromotionCode> price = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            PromotionCode businessCreditCardType = new PromotionCode();
            String name = fakeValuesService.resolve("commerce.promotion_code.noun", fakeValuesService, faker);
            businessCreditCardType.setName(name);
            price.add(businessCreditCardType);


        }
        List<PromotionCode> collect3 = price.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect3.size());
        promotionCodeRepository.saveAll(collect3);

        log.info("Department");
        List<Department> departments2 = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            Department businessCreditCardType = new Department();
            String name = fakeValuesService.resolve("commerce.department", fakeValuesService, faker);
            businessCreditCardType.setName(name);
            departments2.add(businessCreditCardType);

        }
        List<Department> collect5 = departments2.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect5.size());
        departmentRepository.saveAll(collect5);

        log.info("CommerceAdjective");
        List<CommerceAdjective> commerceAdjectives = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            CommerceAdjective businessCreditCardType = new CommerceAdjective();
            String name = fakeValuesService.resolve("commerce.product_name.adjective", fakeValuesService, faker);
            businessCreditCardType.setName(name);
            commerceAdjectives.add(businessCreditCardType);

        }
        List<CommerceAdjective> collect6 = commerceAdjectives.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect6.size());
        commerceAdjectiveRepository.saveAll(collect6);

        log.info("PromotionCodeAdjective2");
        List<PromotionCodeAdjective2> promotionCodeAdjective2s = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            PromotionCodeAdjective2 businessCreditCardType = new PromotionCodeAdjective2();
            String name = fakeValuesService.resolve("commerce.product_name.adjective", fakeValuesService, faker);
            businessCreditCardType.setName(name);
            promotionCodeAdjective2s.add(businessCreditCardType);

        }
        List<PromotionCodeAdjective2> collect7 = promotionCodeAdjective2s.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect7.size());
        promotionCodeAdjective2Repository.saveAll(collect7);


    }



}
