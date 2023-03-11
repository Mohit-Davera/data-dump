package com.research.datagenerator;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.demographic.*;
import com.research.datagenerator.repo.demographic.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Locale;


@Slf4j
@SpringBootApplication
public class DemographicApplication implements CommandLineRunner {

    @Autowired
    DemonymRepository demonymRepository;
    @Autowired
    EducationalAttainmentRepository educationalAttainmentRepository;

    @Autowired
    MaritalStatusRepository maritalStatusRepository;
    @Autowired
    RaceRepository raceRepository;

    @Autowired
    SexRepository sexRepository;


    public static void main(String[] args) {
        SpringApplication.run(DemographicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());


        //Demonym
        log.info("Demonym");
        List<String> demonyms = (List) fakeValuesService.fetchObject("demographic.demonym");
        List<Demonym> demonymList = demonyms.stream().map(Demonym::new).distinct().toList();
        log.info("{}",demonymList.size());
        demonymRepository.saveAll(demonymList);

        //EducationalAttainment
        log.info("EducationalAttainment");
        List<String> educationalAttainments = (List) fakeValuesService.fetchObject("demographic.educational_attainment");
        List<EducationalAttainment> educationalAttainmentList = educationalAttainments.stream().map(EducationalAttainment::new).distinct().toList();
        log.info("{}",educationalAttainmentList.size());
        educationalAttainmentRepository.saveAll(educationalAttainmentList);

        //martial_status
        log.info("MartialStatus");
        List<String> maritalStatuses = (List) fakeValuesService.fetchObject("demographic.marital_status");
        List<MaritalStatus> maritalStatusList = maritalStatuses.stream().map(MaritalStatus::new).distinct().toList();
        log.info("{}",maritalStatusList.size());
        maritalStatusRepository.saveAll(maritalStatusList);


        //Race
        log.info("Race");
        List<String> races = (List) fakeValuesService.fetchObject("demographic.race");
        List<Race> raceList = races.stream().map(Race::new).distinct().toList();
        log.info("{}",raceList.size());
        raceRepository.saveAll(raceList);

        //Sex
        log.info("Sex");
        List<String> sexes = (List) fakeValuesService.fetchObject("demographic.sex");
        List<Sex> sexList = sexes.stream().map(Sex::new).distinct().toList();
        log.info("{}",sexList.size());
        sexRepository.saveAll(sexList);



    }
}

