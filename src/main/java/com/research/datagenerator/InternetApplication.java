package com.research.datagenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.internet.*;
import com.research.datagenerator.repo.internet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;


@Slf4j
@SpringBootApplication
public class InternetApplication implements CommandLineRunner {

    @Autowired
    DomainNameRepository domainNameRepository;
    @Autowired
    DomainWordRepository domainWordRepository;
    @Autowired
    DomainSuffixRepository domainSuffixRepository;
    @Autowired
    EmailAddressRepository emailAddressRepository;
    @Autowired
    SafeEmailAddressRepository safeEmailAddressRepository;
    @Autowired
    InternetUrlRepository internetUrlRepository;

    @Autowired
    UserAgentRepository userAgentRepository;
    @Autowired
    ImageDimensionRepository imageDimensionRepository;
    @Autowired
    ImageCategoryRepository imageCategoryRepository;



    public static void main(String[] args) {
        SpringApplication.run(InternetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
        Internet internet = faker.internet();

        //DomainName
        log.info("DomainName");
        Set<DomainName> domainNames = new HashSet<>();
        for (long i = 0; i < 100000; i++) {
            DomainName domainName = new DomainName();
            String name = internet.domainName();
            domainName.setName(name);
            domainNames.add(domainName);
        }
        List<DomainName> domainNameList = domainNames.stream().distinct().toList();
        log.info("{}",domainNameList.size());
        domainNameRepository.saveAll(domainNameList);

        //DomainSuffix
        log.info("DomainSuffix");
        List<String> domainSuffixes = (List) fakeValuesService.fetchObject("internet.domain_suffix");
        List<DomainSuffix> domainSuffixList = domainSuffixes.stream().map(DomainSuffix::new).distinct().toList();
        log.info("{}",domainSuffixList.size());
        domainSuffixRepository.saveAll(domainSuffixList);

        //DomainWord
        log.info("DomainWord");
        Set<DomainWord> domainWords = new HashSet<>();
        for (long i = 0; i < 100000; i++) {
            DomainWord domainWord = new DomainWord();
            String name = internet.domainWord();
            domainWord.setName(name);
            domainWords.add(domainWord);
        }
        List<DomainWord> domainWordList = domainWords.stream().distinct().toList();
        log.info("{}",domainWordList.size());
        domainWordRepository.saveAll(domainWordList);

        //EmailAddress
        log.info("EmailAddress");
        List<EmailAddress> emailAddresses = new ArrayList<>();
        for (long i = 0; i < 10000000; i++) {
            EmailAddress emailAddress = new EmailAddress();
            String name = internet.emailAddress();
            emailAddress.setName(name);
            emailAddresses.add(emailAddress);
        }
        List<EmailAddress> emailAddressList = emailAddresses.stream().distinct().toList();
        log.info("{}",emailAddressList.size());
        emailAddressRepository.saveAll(emailAddressList);


        //SafeEmailAddress
        log.info("SafeEmailAddress");
        List<SafeEmailAddress> safeEmailAddresses = new ArrayList<>();
        for (long i = 0; i < 10000000; i++) {
            SafeEmailAddress safeEmailAddress = new SafeEmailAddress();
            String name = internet.safeEmailAddress();
            safeEmailAddress.setName(name);
            safeEmailAddresses.add(safeEmailAddress);
        }
        List<SafeEmailAddress> safeEmailAddressList = safeEmailAddresses.stream().distinct().toList();
        log.info("{}",safeEmailAddressList.size());
        safeEmailAddressRepository.saveAll(safeEmailAddressList);


        //ImageCategory
        log.info("ImageCategory");
        List<String> imageCategories = (List) fakeValuesService.fetchObject("internet.image_category");
        List<ImageCategory> imageCategoryList = imageCategories.stream().map(ImageCategory::new).distinct().toList();
        log.info("{}",imageCategoryList.size());
        imageCategoryRepository.saveAll(imageCategoryList);


        //ImageDimension
        log.info("ImageDimension");
        List<String> imageDimensions = (List) fakeValuesService.fetchObject("internet.image_dimension");
        List<ImageDimension> imageDimensionList = imageDimensions.stream().map(ImageDimension::new).distinct().toList();
        log.info("{}",imageDimensionList.size());
        imageDimensionRepository.saveAll(imageDimensionList);


        //InternetUrl
        log.info("InternetUrl");
        List<InternetUrl> internetUrls = new ArrayList<>();
        for (long i = 0; i < 10000000; i++) {
            InternetUrl internetUrl = new InternetUrl();
            String name = internet.url();
            internetUrl.setName(name);
            internetUrls.add(internetUrl);
        }
        List<InternetUrl> internetUrlList = internetUrls.stream().distinct().toList();
        log.info("{}",internetUrlList.size());
        internetUrlRepository.saveAll(internetUrlList);

        //UserAgent
        log.info("UserAgent");
        LinkedHashMap<String,List<String>> linkedHashMap = (LinkedHashMap) fakeValuesService.fetchObject("internet.user_agent");
        List<UserAgent> userAgents = linkedHashMap.values().stream().flatMap(List::stream).map(UserAgent::new).toList();
        log.info("{}",userAgents.size());
        userAgentRepository.saveAll(userAgents);
    }
}

