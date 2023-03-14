package com.research.datagenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.Country.*;
import com.research.datagenerator.repo.countryRepository.*;
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
public class CountryApplication implements CommandLineRunner {

    @Autowired
    CapitalRepository capitalRepository;

    @Autowired
    CountryNameRepository countryNameRepository;

    @Autowired
    CountryCode2Repository countryCode2Repository;

    @Autowired
    CountryCode3Repository countryCode3Repository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    CurrencyCodeRepository currencyCodeRepository;


	public static void main(String[] args) {
		SpringApplication.run(CountryApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());

        log.info("Capital");
        List<Capital> departments = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            Capital businessCreditCardType = new Capital();
            String name = fakeValuesService.resolve("country.capital", fakeValuesService, faker);
            businessCreditCardType.setName(name);
            departments.add(businessCreditCardType);

        }
        List<Capital> collect = departments.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect.size());
        capitalRepository.saveAll(collect);

        log.info("CountryCode2");
        List<CountryCode2> countryCode2s = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            CountryCode2 businessCreditCardType = new CountryCode2();
            String name = fakeValuesService.resolve("country.code2", fakeValuesService, faker);
            businessCreditCardType.setName(name);
            countryCode2s.add(businessCreditCardType);

        }
        List<CountryCode2> collect2 = countryCode2s.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect2.size());
        countryCode2Repository.saveAll(collect2);



        log.info("CountryCode3");
        List<CountryCode3> countryCode3s = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
        CountryCode3 businessCreditCardType = new CountryCode3();
        String name = fakeValuesService.resolve("country.code3", fakeValuesService, faker);
        businessCreditCardType.setName(name);
        countryCode3s.add(businessCreditCardType);

    }
        List<CountryCode3> collect3 = countryCode3s.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect3.size());
        countryCode3Repository.saveAll(collect3);

        log.info("CountryName");
        List<CountryName> countryNames = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            CountryName businessCreditCardType = new CountryName();
            String name = fakeValuesService.resolve("country.name", fakeValuesService, faker);
            businessCreditCardType.setName(name);
            countryNames.add(businessCreditCardType);

        }
        List<CountryName> collect4 = countryNames.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect4.size());
        countryNameRepository.saveAll(collect4);


        log.info("Currency");
        List<Currency> currencies = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            Currency businessCreditCardType = new Currency();
            String name = fakeValuesService.resolve("country.currency", fakeValuesService, faker);
            businessCreditCardType.setName(name);
            currencies.add(businessCreditCardType);

        }
        List<Currency> collect5 = currencies.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect5.size());
        currencyRepository.saveAll(collect5);

        log.info("CurrencyCode");
        List<CurrencyCode> currencyCodes = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            CurrencyCode businessCreditCardType = new CurrencyCode();
            String name = fakeValuesService.resolve("country.currency_code", fakeValuesService, faker);
            businessCreditCardType.setName(name);
            currencyCodes.add(businessCreditCardType);

        }
        List<CurrencyCode> collect6 = currencyCodes.stream().distinct().collect(Collectors.toList());
        log.info("{}",collect6.size());
        currencyCodeRepository.saveAll(collect6);



    }

}
