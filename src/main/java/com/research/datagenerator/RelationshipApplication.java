package com.research.datagenerator;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.relationship.*;
import com.research.datagenerator.repo.relationship.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Locale;


@Slf4j
@SpringBootApplication
public class RelationshipApplication implements CommandLineRunner {

    @Autowired
    DirectRepository directRepository;
    @Autowired
    ExtendedRepository extendedRepository;

    @Autowired
    InLawRepository inLawRepository;
    @Autowired
    ParentRepository parentRepository;
    @Autowired
    SiblingRepository siblingRepository;
    @Autowired
    SpouseRepository spouseRepository;


    public static void main(String[] args) {
        SpringApplication.run(RelationshipApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());

        //Direct
        log.info("Direct");
        List<String> directs = (List) fakeValuesService.fetchObject("relationship.familial.direct");
        List<Direct> directList = directs.stream().map(Direct::new).distinct().toList();
        log.info("{}",directList.size());
        directRepository.saveAll(directList);

        //Extended
        log.info("Extended");
        List<String> extended = (List) fakeValuesService.fetchObject("relationship.familial.extended");
        List<Extended> extendedList = extended.stream().map(Extended::new).distinct().toList();
        log.info("{}",extendedList.size());
        extendedRepository.saveAll(extendedList);

        //InLaw
        log.info("InLaw");
        List<String> inLaws = (List) fakeValuesService.fetchObject("relationship.in_law");
        List<InLaw> inLawList = inLaws.stream().map(InLaw::new).distinct().toList();
        log.info("{}",inLawList.size());
        inLawRepository.saveAll(inLawList);

        //Parent
        log.info("Parent");
        List<String> parents = (List) fakeValuesService.fetchObject("relationship.parent");
        List<Parent> parentList = parents.stream().map(Parent::new).distinct().toList();
        log.info("{}",parentList.size());
        parentRepository.saveAll(parentList);

        //Sibling
        log.info("Sibling");
        List<String> siblings = (List) fakeValuesService.fetchObject("relationship.sibling");
        List<Sibling> siblingList = siblings.stream().map(Sibling::new).distinct().toList();
        log.info("{}",siblingList.size());
        siblingRepository.saveAll(siblingList);

        //Spouse
        log.info("Spouse");
        List<String> spouses = (List) fakeValuesService.fetchObject("relationship.spouse");
        List<Spouse> spouseList = spouses.stream().map(Spouse::new).distinct().toList();
        log.info("{}",spouseList.size());
        spouseRepository.saveAll(spouseList);

    }
}

