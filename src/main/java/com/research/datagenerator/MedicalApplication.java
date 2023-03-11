package com.research.datagenerator;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.medical.DiseaseName;
import com.research.datagenerator.entity.medical.HospitalName;
import com.research.datagenerator.entity.medical.MedicineName;
import com.research.datagenerator.entity.medical.Symptoms;
import com.research.datagenerator.repo.medical.DiseaseNameRepository;
import com.research.datagenerator.repo.medical.HospitalNameRepository;
import com.research.datagenerator.repo.medical.MedicineNameRepository;
import com.research.datagenerator.repo.medical.SymptomsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Locale;


@Slf4j
@SpringBootApplication
public class MedicalApplication implements CommandLineRunner {

    @Autowired
    HospitalNameRepository hospitalNameRepository;
    @Autowired
    DiseaseNameRepository diseaseNameRepository;

    @Autowired
    SymptomsRepository symptomsRepository;
    @Autowired
    MedicineNameRepository medicineNameRepository;


    public static void main(String[] args) {
        SpringApplication.run(MedicalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());

        //DiseaseName
        log.info("DiseaseName");
        List<String> diseases = (List) fakeValuesService.fetchObject("medical.disease_name");
        List<DiseaseName> diseaseNameList = diseases.stream().map(DiseaseName::new).distinct().toList();
        log.info("{}",diseaseNameList.size());
        diseaseNameRepository.saveAll(diseaseNameList);

        //HospitalName
        log.info("HospitalName");
        List<String> hospitals = (List) fakeValuesService.fetchObject("medical.hospital_name");
        List<HospitalName> hospitalNameList = hospitals.stream().map(HospitalName::new).distinct().toList();
        log.info("{}",hospitalNameList.size());
        hospitalNameRepository.saveAll(hospitalNameList);

        //MedicineName
        log.info("MedicineName");
        List<String> medicines = (List) fakeValuesService.fetchObject("medical.medicine_name");
        List<MedicineName> medicineNameList = medicines.stream().map(MedicineName::new).distinct().toList();
        log.info("{}",medicineNameList.size());
        medicineNameRepository.saveAll(medicineNameList);

        //Symptoms
        log.info("Symptoms");
        List<String> symptoms = (List) fakeValuesService.fetchObject("medical.symptoms");
        List<Symptoms> symptomsList = symptoms.stream().map(Symptoms::new).distinct().toList();
        log.info("{}",symptomsList.size());
        symptomsRepository.saveAll(symptomsList);


    }
}

