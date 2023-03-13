package com.research.datagenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.file.MimeType;
import com.research.datagenerator.entity.internet.DomainWord;
import com.research.datagenerator.entity.name.*;
import com.research.datagenerator.repo.nameRepository.*;
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
public class NameApplication implements CommandLineRunner {


    @Autowired
    BloodGroupRepository bloodGroupRepository;

    @Autowired
    FirstNameRepository firstNameRepository;

    @Autowired
    LastNameRepository lastNameRepository;

    @Autowired
    NameRepository nameRepository;

   @Autowired
    NameWithMiddleRepository nameWithMiddleRepository;
   @Autowired
   PrefixRepository prefixRepository;
   @Autowired
   SuffixRepository suffixRepository;

    public static void main(String[] args) {
        SpringApplication.run(NameApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
        Name name =faker.name();

        log.info("BloodGroup");
        List<String> bloodgroup = (List) fakeValuesService.fetchObject("name.blood_group");
        List<BloodGroup> bloodgroupList  = bloodgroup.stream().map(BloodGroup::new).distinct().toList();
        log.info("{}",bloodgroupList.size());
        bloodGroupRepository.saveAll(bloodgroupList);

        log.info("FirstName");
        List<String> firstName = (List) fakeValuesService.fetchObject("name.male_first_name");
        List<String> secondName = (List) fakeValuesService.fetchObject("name.female_first_name");
        List<FirstName> firstNameList  = firstName.stream().map(FirstName::new).distinct().toList();
        List<FirstName> secondNameList  = secondName.stream().map(FirstName::new).distinct().toList();
        log.info("{}",firstNameList.size()+secondNameList.size());
        firstNameRepository.saveAll(firstNameList);
        firstNameRepository.saveAll(secondNameList);



//        log.info("Name With Middle");
//        Set<NameWithMiddle> nameWithMiddles = new HashSet<>();
//        for (long i = 0; i < 10200000; i++) {
//            NameWithMiddle nameWithMiddle = new NameWithMiddle();
//            String name1 = name.nameWithMiddle();
//            nameWithMiddle.setName(name1);
//            nameWithMiddles.add(nameWithMiddle);
//        }
//        List<NameWithMiddle> nameWithMiddleList = nameWithMiddles.stream().distinct().toList();
//        log.info("{}",nameWithMiddleList.size());
//        nameWithMiddleRepository.saveAll(nameWithMiddleList);



//        log.info("Name");
//        Set<com.research.datagenerator.entity.name.Name> names = new HashSet<>();
//        for (long i = 0; i < 10000000; i++) {
//            com.research.datagenerator.entity.name.Name name12 = new com.research.datagenerator.entity.name.Name();
//            String name1 = name.name();
//            name12.setName(name1);
//            names.add(name12);
//        }
//        List<com.research.datagenerator.entity.name.Name> nameList = names.stream().distinct().toList();
//        log.info("{}",nameList.size());
//        nameRepository.saveAll(nameList);




        log.info("LastName");
        List<String> lastname = (List) fakeValuesService.fetchObject("name.last_name");
        List<LastName> lastNameList  = lastname.stream().map(LastName::new).distinct().toList();
        log.info("{}",lastNameList.size());
        lastNameRepository.saveAll(lastNameList);

        log.info("Prefix");
        List<String> prefix = (List) fakeValuesService.fetchObject("name.prefix");
        List<Prefix>  prefixList  = prefix.stream().map(Prefix::new).distinct().toList();
        log.info("{}",prefixList.size());
        prefixRepository.saveAll(prefixList);

        log.info("Suffix");
        List<String> suffix = (List) fakeValuesService.fetchObject("name.suffix");
        List<Suffix>  suffixList  = suffix.stream().map(Suffix::new).distinct().toList();
        log.info("{}",suffixList.size());
        suffixRepository.saveAll(suffixList);


    }
}
