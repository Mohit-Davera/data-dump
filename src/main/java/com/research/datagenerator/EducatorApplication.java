package com.research.datagenerator;

import com.github.javafaker.Educator;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.educator.Campus;
import com.research.datagenerator.entity.educator.Course;
import com.research.datagenerator.entity.educator.SecondarySchool;
import com.research.datagenerator.entity.educator.University;
import com.research.datagenerator.repo.educator.CampusRepository;
import com.research.datagenerator.repo.educator.CourseRepository;
import com.research.datagenerator.repo.educator.SecondarySchoolRepository;
import com.research.datagenerator.repo.educator.UniversityRepository;
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
public class EducatorApplication implements CommandLineRunner {

    @Autowired
    CampusRepository campusRepository;
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SecondarySchoolRepository secondarySchoolRepository;
    @Autowired
    UniversityRepository universityRepository;

    public static void main(String[] args) {
        SpringApplication.run(EducatorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
        Educator educator = faker.educator();

        //Campus
        log.info("Campus");
        List<String> campuses = (List) fakeValuesService.fetchObject("educator.name");
        List<Campus> campusList = campuses.stream().map(campus -> campus + " Campus" ).map(Campus::new).distinct().toList();
        log.info("{}",campusList.size());
        campusRepository.saveAll(campusList);

        //Course
        log.info("Course");
        Set<Course> courses = new HashSet<>();
        for (long i = 0; i < 10000; i++) {
            Course course = new Course();
            String name = educator.course();
            course.setName(name);
            courses.add(course);
        }
        List<Course> catchPhraseList = courses.stream().distinct().toList();
        log.info("{}",catchPhraseList.size());
        courseRepository.saveAll(catchPhraseList);

        //SecondarySchool
        log.info("SecondarySchool");
        Set<SecondarySchool> secondarySchools = new HashSet<>();
        for (long i = 0; i < 10000; i++) {
            SecondarySchool secondarySchool = new SecondarySchool();
            String name = educator.secondarySchool();
            secondarySchool.setName(name);
            secondarySchools.add(secondarySchool);
        }
        List<SecondarySchool> secondarySchoolList = secondarySchools.stream().distinct().toList();
        log.info("{}",secondarySchoolList.size());
        secondarySchoolRepository.saveAll(secondarySchoolList);


        //University
        log.info("University");
        Set<University> universities = new HashSet<>();
        for (long i = 0; i < 10000; i++) {
            University university = new University();
            String name = educator.university();
            university.setName(name);
            universities.add(university);
        }
        List<University> universityList = universities.stream().distinct().toList();
        log.info("{}",universityList.size());
        universityRepository.saveAll(universityList);


    }
}

