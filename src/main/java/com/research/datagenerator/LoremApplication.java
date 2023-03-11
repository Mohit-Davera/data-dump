package com.research.datagenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.Lorem;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.lorem.Supplemental;
import com.research.datagenerator.entity.lorem.Words;
import com.research.datagenerator.repo.lorem.SupplementalRepository;
import com.research.datagenerator.repo.lorem.WordsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Locale;


@Slf4j
@SpringBootApplication
public class LoremApplication implements CommandLineRunner {

    @Autowired
    WordsRepository wordsRepository;
    @Autowired
    SupplementalRepository supplementalRepository;


    public static void main(String[] args) {
        SpringApplication.run(LoremApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
        Lorem lorem = faker.lorem();

        //Words
        log.info("Words");
        List<String> words = (List) fakeValuesService.fetchObject("lorem.words");
        List<Words> wordsList = words.stream().map(Words::new).distinct().toList();
        log.info("{}",wordsList.size());
        wordsRepository.saveAll(wordsList);

        //Supplemental
        log.info("Supplemental");
        List<String> supplemental = (List) fakeValuesService.fetchObject("lorem.supplemental");
        List<Supplemental> supplementalList = supplemental.stream().map(Supplemental::new).distinct().toList();
        log.info("{}",supplementalList.size());
        supplementalRepository.saveAll(supplementalList);

        //Title
/*        log.info("Title");
        List<Title> titles = new ArrayList<>();
        for (long i = 0; i < 1000000; i++) {
            Title title = new Title();
            String name = lorem.title();
            title.setName(name);
            titles.add(title);
        }
        List<Title> titleList = titles.stream().distinct().toList();
        log.info("{}",titleList.size());
        titleRepository.saveAll(titleList);*/

    }
}

