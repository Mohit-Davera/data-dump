package com.research.datagenerator;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.nation.CapitalCity;
import com.research.datagenerator.entity.nation.Flag;
import com.research.datagenerator.entity.nation.Language;
import com.research.datagenerator.entity.nation.Nationality;
import com.research.datagenerator.repo.nation.CapitalCityRepository;
import com.research.datagenerator.repo.nation.FlagRepository;
import com.research.datagenerator.repo.nation.LanguageRepository;
import com.research.datagenerator.repo.nation.NationalityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;


@Slf4j
@SpringBootApplication
public class NationApplication implements CommandLineRunner {

    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    NationalityRepository nationalityRepository;

    @Autowired
    FlagRepository flagRepository;
    @Autowired
    CapitalCityRepository capitalCityRepository;

    private static final Charset UTF8_CHARSET = StandardCharsets.UTF_8;

    public static void main(String[] args) {
        SpringApplication.run(NationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());

        //CapitalCity
        log.info("CapitalCity");
        List<String> cities = (List) fakeValuesService.fetchObject("nation.capital_city");
        List<CapitalCity> capitalCityList = cities.stream().map(CapitalCity::new).distinct().toList();
        log.info("{}",capitalCityList.size());
        capitalCityRepository.saveAll(capitalCityList);

        //Flag
        log.info("Flag");
        Set<Flag> flags = new HashSet<>();
        List<List<Integer>> flagInts = (List)fakeValuesService.fetchObject("nation.flag");
        flagInts.stream().forEach(
                s -> {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(s.size());
                    s.stream().map(Integer::byteValue).forEach(byteBuffer::put);
                    flags.add(new Flag(new String(byteBuffer.array(), UTF8_CHARSET)));
                }
        );
        log.info("{}",flags.size());
        flagRepository.saveAll(flags);

        //Language
        log.info("Language");
        List<String> languages = (List) fakeValuesService.fetchObject("nation.language");
        List<Language> languageList = languages.stream().map(Language::new).distinct().toList();
        log.info("{}",languageList.size());
        languageRepository.saveAll(languageList);

        //Nationality
        log.info("Nationality");
        List<String> nationalities = (List) fakeValuesService.fetchObject("nation.nationality");
        List<Nationality> nationalityList = nationalities.stream().map(Nationality::new).distinct().toList();
        log.info("{}",nationalityList.size());
        nationalityRepository.saveAll(nationalityList);

    }
}

