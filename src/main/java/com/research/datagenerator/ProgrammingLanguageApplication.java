package com.research.datagenerator;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.programming.Creator;
import com.research.datagenerator.entity.programming.ProgrammingLanguage;
import com.research.datagenerator.repo.programming.CreatorRepository;
import com.research.datagenerator.repo.programming.ProgrammingLanguageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Locale;


@Slf4j
@SpringBootApplication
public class ProgrammingLanguageApplication implements CommandLineRunner {

    @Autowired
    ProgrammingLanguageRepository programmingLanguageRepository;
    @Autowired
    CreatorRepository creatorRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProgrammingLanguageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());

        //ProgrammingLanguage
        log.info("ProgrammingLanguage");
        List<String> programmingLanguages = (List) fakeValuesService.fetchObject("programming_language.name");
        List<ProgrammingLanguage> programmingLanguageList = programmingLanguages.stream().map(ProgrammingLanguage::new).distinct().toList();
        log.info("{}",programmingLanguageList.size());
        programmingLanguageRepository.saveAll(programmingLanguageList);

        //Creator
        log.info("Creator");
        List<String> creators = (List) fakeValuesService.fetchObject("programming_language.creator");
        List<Creator> creatorList = creators.stream().map(Creator::new).distinct().toList();
        log.info("{}",creatorList.size());
        creatorRepository.saveAll(creatorList);


    }
}

