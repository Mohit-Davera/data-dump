package com.research.datagenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.Job;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.job.*;
import com.research.datagenerator.repo.job.*;
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
public class JobApplication implements CommandLineRunner {

    @Autowired
    EducationLevelRepository educationLevelRepository;
    @Autowired
    EmploymentTypeRepository employmentTypeRepository;
    @Autowired
    FieldRepository fieldRepository;
    @Autowired
    KeySkillsRepository keySkillsRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    SeniorityRepository seniorityRepository;
    @Autowired
    TitleRepository titleRepository;




    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
        Job job = faker.job();

        //EmploymentLevel
        log.info("EmploymentLevel");
        List<String> emLevels = (List) fakeValuesService.fetchObject("job.education_level");
        List<EducationLevel> educationLevelList = emLevels.stream().map(EducationLevel::new).distinct().toList();
        log.info("{}",educationLevelList.size());
        educationLevelRepository.saveAll(educationLevelList);

        //EmploymentType
        log.info("EmploymentType");
        List<String> emTypes = (List) fakeValuesService.fetchObject("job.employment_type");
        List<EmploymentType> employmentTypeList = emTypes.stream().map(EmploymentType::new).distinct().toList();
        log.info("{}",employmentTypeList.size());
        employmentTypeRepository.saveAll(employmentTypeList);

        //Field
        log.info("Field");
        List<String> fields = (List) fakeValuesService.fetchObject("job.field");
        List<Field> fieldList = fields.stream().map(Field::new).distinct().toList();
        log.info("{}",fieldList.size());
        fieldRepository.saveAll(fieldList);


        //KeySkills
        log.info("KeySkills");
        List<String> skills = (List) fakeValuesService.fetchObject("job.key_skills");
        List<KeySkills> keySkillsList = skills.stream().map(KeySkills::new).distinct().toList();
        log.info("{}",keySkillsList.size());
        keySkillsRepository.saveAll(keySkillsList);

        //Position
        log.info("Position");
        List<String> positions = (List) fakeValuesService.fetchObject("job.position");
        List<Position> positionList = positions.stream().map(Position::new).distinct().toList();
        log.info("{}",positionList.size());
        positionRepository.saveAll(positionList);

        //Seniority
        log.info("Seniority");
        List<String> seniority = (List) fakeValuesService.fetchObject("job.seniority");
        List<Seniority> seniorityList = seniority.stream().map(Seniority::new).distinct().toList();
        log.info("{}",seniorityList.size());
        seniorityRepository.saveAll(seniorityList);

        //JobTitle
        log.info("JobTitle");
        Set<Title> titles = new HashSet<>();
        for (long i = 0; i < 400000; i++) {
            Title title = new Title();
            String name = job.title();
            title.setName(name);
            titles.add(title);
        }
        List<Title> titleList = titles.stream().distinct().toList();
        log.info("{}",titleList.size());
        titleRepository.saveAll(titleList);

    }
}

