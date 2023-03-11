package com.research.datagenerator;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.currency.Code;
import com.research.datagenerator.entity.currency.CurrencyName;
import com.research.datagenerator.repo.currency.CodeRepository;
import com.research.datagenerator.repo.currency.CurrencyNameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Locale;

@Slf4j
@SpringBootApplication
public class CurrencyApplication implements CommandLineRunner {

    @Autowired
    CurrencyNameRepository currencyNameRepository;
    @Autowired
    CodeRepository codeRepository;


    public static void main(String[] args) {
        SpringApplication.run(CurrencyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());


        //Code
        log.info("Code");
        List<String> codes = (List) fakeValuesService.fetchObject("currency.code");
        List<Code> codeList = codes.stream().map(Code::new).distinct().toList();
        log.info("{}",codeList.size());
        codeRepository.saveAll(codeList);

        //CurrencyName
        log.info("CurrencyName");
        List<String> currencyNames = (List) fakeValuesService.fetchObject("currency.name");
        List<CurrencyName> currencyNameList = currencyNames.stream().map(CurrencyName::new).distinct().toList();
        log.info("{}",currencyNameList.size());
        currencyNameRepository.saveAll(currencyNameList);


    }
}

