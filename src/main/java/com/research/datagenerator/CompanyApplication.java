package com.research.datagenerator;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.company.*;
import com.research.datagenerator.repo.company.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;


@Slf4j
@SpringBootApplication
public class CompanyApplication implements CommandLineRunner {

    @Autowired
    BSOneRepository bsOneRepository;

    @Autowired
    BSTwoRepository bsTwoRepository;

    @Autowired
    BSThreeRepository bsThreeRepository;

    @Autowired
    BuzzwordOneRepository buzzwordOneRepository;

    @Autowired
    BuzzwordTwoRepository buzzwordTwoRepository;

    @Autowired
    BuzzwordThreeRepository buzzwordThreeRepository;

    @Autowired
    CatchPhraseRepository catchPhraseRepository;
    @Autowired
    CompanyNameRepository companyNameRepository;

    @Autowired
    CompanySuffixRepository companySuffixRepository;
    @Autowired
    IndustryRepository industryRepository;

    @Autowired
    LogoRepository logoRepository;

    @Autowired
    ProfessionRepository professionRepository;

    @Autowired
    UrlRepository urlRepository;



    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
        Company company = faker.company();

        //Name
        log.info("Company Name");
        Set<CompanyName> companyNames = new HashSet<>();
        for (long i = 0; i < 30000000; i++) {
            CompanyName companyName = new CompanyName();
            String name = company.name();
            companyName.setName(name);
            companyNames.add(companyName);
        }
        log.info("Company Data Loaded");
        List<CompanyName> companyNameList = companyNames.stream().distinct().toList();
        companyNameRepository.saveAll(companyNameList);
        log.info("{}",companyNameList.size());


        //BS
        log.info("BS");
        List<List<String>> bsListOfLists = (List)fakeValuesService.fetchObject("company.bs");
        List<String> firstOne = bsListOfLists.get(0);
        List<String> secondOne = bsListOfLists.get(1);
        List<String> thirdOne = bsListOfLists.get(2);

        log.info("{}",bsOneRepository.saveAll(firstOne.stream().map(BSOne::new).toList()).size());
        log.info("{}",bsTwoRepository.saveAll(secondOne.stream().map(BSTwo::new).toList()).size());
        log.info("{}",bsThreeRepository.saveAll(thirdOne.stream().map(BSThree::new).toList()).size());


        //Buzzword
        log.info("Buzzword");
        List<List<String>> buzzwordLists = (List)fakeValuesService.fetchObject("company.buzzwords");
        List<String> firstBuzz = buzzwordLists.get(0);
        List<String> secondBuzz = buzzwordLists.get(1);
        List<String> thirdBuzz = buzzwordLists.get(2);
        log.info("{}",buzzwordOneRepository.saveAll(firstBuzz.stream().map(BuzzwordOne::new).toList()).size());
        log.info("{}",buzzwordTwoRepository.saveAll(secondBuzz.stream().map(BuzzwordTwo::new).toList()).size());
        log.info("{}",buzzwordThreeRepository.saveAll(thirdBuzz.stream().map(BuzzwordThree::new).toList()).size());


        //CatchPhrase
        log.info("CatchPhrase");
        Set<CatchPhrase> catchPhrases = new HashSet<>();
        for (long i = 0; i < 20000000; i++) {
            CatchPhrase catchPhrase = new CatchPhrase();
            String name = company.catchPhrase();
            catchPhrase.setName(name);
            catchPhrases.add(catchPhrase);
        }
        List<CatchPhrase> catchPhraseList = catchPhrases.stream().distinct().toList();
        log.info("{}",catchPhraseList.size());
        catchPhraseRepository.saveAll(catchPhraseList);


        //CompanySuffix
        log.info("CompanySuffix");
        List<String> suffix = (List) fakeValuesService.fetchObject("company.suffix");
        List<CompanySuffix> companySuffixList = suffix.stream().map(CompanySuffix::new).distinct().toList();
        log.info("{}",companySuffixList.size());
        companySuffixRepository.saveAll(companySuffixList);


        //Industry
        log.info("Industry");
        List<String> industries = (List) fakeValuesService.fetchObject("company.industry");
        List<Industry> industryList = industries.stream().map(Industry::new).distinct().toList();
        log.info("{}",industryList.size());
        industryRepository.saveAll(industryList);


        //LOGO
        log.info("Logo");
        List<Logo> logos = new ArrayList<>();
        for (long i = 0; i < 1000; i++) {
            Logo industry = new Logo();
            String name = company.logo();
            industry.setName(name);
            logos.add(industry);
        }
        List<Logo> logoList = logos.stream().distinct().toList();
        log.info("{}",logoList.size());
        logoRepository.saveAll(logoList);


        //Profession
        log.info("Profession");
        List<String> professions = (List) fakeValuesService.fetchObject("company.profession");
        List<Profession> professionList = professions.stream().map(Profession::new).distinct().toList();
        log.info("{}",professionList.size());
        professionRepository.saveAll(professionList);


        //URL - 84,04,256 - 2,00,00,000 Loop
        log.info("URL");
        List<Url> urls = new ArrayList<>();
        for (long i = 0; i < 10000000; i++) {
            Url url = new Url();
            String name = company.url();
            url.setName(name);
            urls.add(url);
        }
        List<Url> urlList = urls.stream().distinct().toList();
        log.info("{}",urlList.size());
        urlRepository.saveAll(urlList);
    }
}

