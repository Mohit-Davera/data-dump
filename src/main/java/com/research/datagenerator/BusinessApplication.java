package com.research.datagenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.Business.BusinessCreditCardType;
import com.research.datagenerator.entity.Business.CreditCardExpiry;
import com.research.datagenerator.entity.Business.CreditCardNumber;

import com.research.datagenerator.repo.businessRepository.CreditCardExpiryRepository;
import com.research.datagenerator.repo.businessRepository.CreditCardNumberRepository;
import com.research.datagenerator.repo.businessRepository.CreditCardTypeRepository;
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
public class BusinessApplication implements CommandLineRunner{


    @Autowired
    CreditCardTypeRepository creditCardTypeRepository;

    @Autowired
     CreditCardNumberRepository creditCardNumberRepository;

    @Autowired
    CreditCardExpiryRepository creditCardExpiryRepository;
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }

   @Override
   public void run(String... args) throws Exception {
       Faker faker =new Faker(new Locale("en"));
       FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"),new RandomService());


       log.info("BusinessCreditCardType");
       List<BusinessCreditCardType> departments = new ArrayList<>();
       for (long i = 0; i < 100000; i++) {
           BusinessCreditCardType businessCreditCardType = new BusinessCreditCardType();
           String name = fakeValuesService.resolve("business.credit_card_types", fakeValuesService, faker);
           businessCreditCardType.setName(name);
           departments.add(businessCreditCardType);

       }
       List<BusinessCreditCardType> collect = departments.stream().distinct().collect(Collectors.toList());
       log.info("{}",collect.size());
       creditCardTypeRepository.saveAll(collect);

       log.info("CreditCardNumber");
       List<CreditCardNumber> creditCardNumbers = new ArrayList<>();
       for (long i = 0; i < 10000; i++) {
           CreditCardNumber businessCreditCardType = new CreditCardNumber();
           String name = fakeValuesService.resolve("business.credit_card_numbers", fakeValuesService, faker);
           businessCreditCardType.setCnumber(name);
           creditCardNumbers.add(businessCreditCardType);

       }
       List<CreditCardNumber> creditCardNumberList = creditCardNumbers.stream().distinct().collect(Collectors.toList());
       log.info("{}",creditCardNumberList.size());
       creditCardNumberRepository.saveAll(creditCardNumberList);


       log.info("CreditCardExpiry");
       List<CreditCardExpiry> creditCardExpiries = new ArrayList<>();
       for (long i = 0; i < 10000; i++) {
           CreditCardExpiry businessCreditCardType = new CreditCardExpiry();
           String name = fakeValuesService.resolve("business.credit_card_expiry_dates", fakeValuesService, faker);
           businessCreditCardType.setExpiryDate(name);
           creditCardExpiries.add(businessCreditCardType);

       }
       List<CreditCardExpiry> creditCardExpiryList = creditCardExpiries.stream().distinct().collect(Collectors.toList());
       log.info("{}",creditCardExpiryList.size());
       creditCardExpiryRepository.saveAll(creditCardExpiryList);


}
        }
