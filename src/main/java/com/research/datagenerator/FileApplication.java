package com.research.datagenerator;

import com.github.javafaker.Faker;
import com.github.javafaker.File;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.file.Extension;
import com.research.datagenerator.entity.file.FileName;
import com.research.datagenerator.entity.file.MimeType;
import com.research.datagenerator.repo.file.ExtensionRepository;
import com.research.datagenerator.repo.file.FileNameRepository;
import com.research.datagenerator.repo.file.MimeTypeRepository;
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
public class FileApplication implements CommandLineRunner {

    @Autowired
    FileNameRepository fileNameRepository;
    @Autowired
    MimeTypeRepository mimeTypeRepository;

    @Autowired
    ExtensionRepository extensionRepository;

    public static void main(String[] args) {
        SpringApplication.run(FileApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
        File file = faker.file();

        //Extension
        log.info("Extension");
        List<String> extensions = (List) fakeValuesService.fetchObject("file.extension");
        List<Extension> extensionList = extensions.stream().map(Extension::new).distinct().toList();
        log.info("{}",extensionList.size());
        extensionRepository.saveAll(extensionList);

        //MimeType
        log.info("MimeType");
        List<String> mimeTypes = (List) fakeValuesService.fetchObject("file.mime_type");
        List<MimeType> mimeTypeList = mimeTypes.stream().map(MimeType::new).distinct().toList();
        log.info("{}",mimeTypeList.size());
        mimeTypeRepository.saveAll(mimeTypeList);


        //FileName
        log.info("FileName");
        Set<FileName> fileNames = new HashSet<>();
        for (long i = 0; i < 10000000; i++) {
            FileName fileName = new FileName();
            String name = file.fileName();
            fileName.setName(name);
            fileNames.add(fileName);
        }
        List<FileName> fileNameList = fileNames.stream().distinct().toList();
        log.info("{}",fileNameList.size());
        fileNameRepository.saveAll(fileNameList);

    }
}

