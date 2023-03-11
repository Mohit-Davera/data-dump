package com.research.datagenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.hacker.*;
import com.research.datagenerator.repo.hacker.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Locale;


@Slf4j
@SpringBootApplication
public class HackerApplication implements CommandLineRunner {

    @Autowired
    AbbreviationRepository abbreviationRepository;
    @Autowired
    AdjectiveRepository adjectiveRepository;
    @Autowired
    IngVerbRepository ingVerbRepository;
    @Autowired
    NounRepository nounRepository;
    @Autowired
    VerbRepository verbRepository;



    public static void main(String[] args) {
        SpringApplication.run(HackerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());

        //Abbreviation
        log.info("Abbreviation");
        List<String> abbreviations = (List) fakeValuesService.fetchObject("hacker.abbreviation");
        List<Abbreviation> abbreviationList = abbreviations.stream().map(Abbreviation::new).distinct().toList();
        log.info("{}",abbreviationList.size());
        abbreviationRepository.saveAll(abbreviationList);

        //Adjective
        log.info("Adjective");
        List<String> adjectives = (List) fakeValuesService.fetchObject("hacker.adjective");
        List<Adjective> adjectiveList = adjectives.stream().map(Adjective::new).distinct().toList();
        log.info("{}",adjectiveList.size());
        adjectiveRepository.saveAll(adjectiveList);


        //IngVerb
        log.info("IngVerb");
        List<String> ingverbs = (List) fakeValuesService.fetchObject("hacker.ingverb");
        List<IngVerb> ingVerbList = ingverbs.stream().map(IngVerb::new).distinct().toList();
        log.info("{}",ingVerbList.size());
        ingVerbRepository.saveAll(ingVerbList);


        //Abbreviation
        log.info("Noun");
        List<String> nouns = (List) fakeValuesService.fetchObject("hacker.noun");
        List<Noun> nounList = nouns.stream().map(Noun::new).distinct().toList();
        log.info("{}",nounList.size());
        nounRepository.saveAll(nounList);


        //Verb
        log.info("Verb");
        List<String> verbs = (List) fakeValuesService.fetchObject("hacker.verb");
        List<Verb> verbList = verbs.stream().map(Verb::new).distinct().toList();
        log.info("{}",verbList.size());
        verbRepository.saveAll(verbList);

    }
}

