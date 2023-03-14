package com.research.datagenerator;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.address.*;
import com.research.datagenerator.entity.address.TimeZone;
import com.research.datagenerator.repo.address.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;


@Slf4j
@SpringBootApplication
public class AddressApplication implements CommandLineRunner {

    @Autowired
    BuildingNumberRepository buildingNumberRepository;
    @Autowired
    CityNameRepository cityNameRepository;

    @Autowired
    CityPrefixRepository cityPrefixRepository;

    @Autowired
    CitySuffixRepository citySuffixRepository;

    @Autowired
    CountryByCodeRepository countryByCodeRepository;

    @Autowired
    CountryCodeRepository countryCodeRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    FullAddressRepository fullAddressRepository;

    @Autowired
    SecondaryAddressRepository secondaryAddressRepository;

    @Autowired
    SecondaryStreetAddressRepository secondaryStreetAddressRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    StateAbbrRepository stateAbbrRepository;

    @Autowired
    StreetAddressNumberRepository streetAddressNumberRepository;

    @Autowired
    StreetAddressRepository streetAddressRepository;

    @Autowired
    StreetNameRepository streetNameRepository;

    @Autowired
    StreetSuffixRepository streetSuffixRepository;

    @Autowired
    TimeZoneRepository timeZoneRepository;

    @Autowired
    ZipCodeByStateRepository zipCodeByStateRepository;

    @Autowired
    ZipCodeRepository zipCodeRepository;

    public static void main(String[] args) {
        SpringApplication.run(AddressApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Faker faker = new Faker(new Locale("en"));
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"), new RandomService());
        Address address = faker.address();

        //BuildingNumber
        log.info("BuildingNumber");
        List<String> buildingNumbers = new ArrayList<>();
        for (int i = 100; i <= 99999; i++) {
            buildingNumbers.add(String.valueOf(i));
        }
        List<BuildingNumber> buildingNumberList = buildingNumbers.stream().map(BuildingNumber::new).distinct().toList();
        log.info("{}", buildingNumberList.size());
        buildingNumberRepository.saveAll(buildingNumberList);

        //CityName
        log.info("CityName");
        Set<CityName> cities = new HashSet<>();
        for (int i = 0; i < 25000000; i++) {
            cities.add(new CityName(address.city()));
        }
        List<CityName> cityNameList = cities.stream().distinct().toList();
        log.info("{}",cityNameList.size());
        cityNameRepository.saveAll(cityNameList);

        //CityPrefix
        log.info("CityPrefix");
        List<String> prefixes = (List) fakeValuesService.fetchObject("address.city_prefix");
        List<CityPrefix> cityPrefixList = prefixes.stream().map(CityPrefix::new).distinct().toList();
        log.info("{}", cityPrefixList.size());
        cityPrefixRepository.saveAll(cityPrefixList);

        //CitySuffix
        log.info("CitySuffix");
        List<String> suffixes = (List) fakeValuesService.fetchObject("address.city_suffix");
        List<CitySuffix> citySuffixList = suffixes.stream().map(CitySuffix::new).distinct().toList();
        log.info("{}", citySuffixList.size());
        citySuffixRepository.saveAll(citySuffixList);

        //Country
        log.info("Country");
        List<String> countries = (List) fakeValuesService.fetchObject("address.country");
        List<Country> countryList = countries.stream().map(Country::new).distinct().toList();
        log.info("{}", countryList.size());
        countryRepository.saveAll(countryList);

        //CountryByCode
        log.info("CountryByCode");
        LinkedHashMap<String, String> countryByCodes = (LinkedHashMap) fakeValuesService.fetchObject("address.country_by_code");
        List<CountryByCode> countryByCodeList = new ArrayList<>();
        Set<String> code = countryByCodes.keySet();
        code.forEach(s -> countryByCodeList.add(new CountryByCode(s, countryByCodes.get(s))));
        log.info("{}", countryByCodeList.size());
        countryByCodeRepository.saveAll(countryByCodeList);

        //CountryCode
        log.info("CountryCode");
        List<String> countryCodes = (List) fakeValuesService.fetchObject("address.country_code");
        List<CountryCode> countryCodeList = countryCodes.stream().map(CountryCode::new).distinct().toList();
        log.info("{}", countryCodeList.size());
        countryCodeRepository.saveAll(countryCodeList);

        //FullAddress
        log.info("FullAddress");
        Set<FullAddress> fullAddresses = new HashSet<>();
        for (int i = 0; i < 10000000; i++) {
            fullAddresses.add(new FullAddress(address.fullAddress()));
        }
        List<FullAddress> fullAddressList = fullAddresses.stream().distinct().toList();
        log.info("{}",fullAddressList.size());
        fullAddressRepository.saveAll(fullAddressList);

        //SecondaryAddress
        log.info("SecondaryAddress");
        List<SecondaryAddress> secondaryAddresses = new ArrayList<>();
        for (int i = 100; i <= 999; i++) {
            secondaryAddresses.add(new SecondaryAddress("Apt. " + i));
        }
        for (int i = 100; i <= 999; i++) {
            secondaryAddresses.add(new SecondaryAddress("Suite " + i));
        }
        secondaryAddressRepository.saveAll(secondaryAddresses);

        //SecondaryStreetAddress
        log.info("SecondaryStreetAddress");
        Set<SecondaryStreetAddress> secondaryStreetAddresses = new HashSet<>();
        for (int i = 0; i < 10000000; i++) {
            secondaryStreetAddresses.add(new SecondaryStreetAddress(address.streetAddress(true)));
        }
        List<SecondaryStreetAddress> secondaryStreetAddressList = secondaryStreetAddresses.stream().distinct().toList();
        log.info("{}", secondaryStreetAddressList.size());
        secondaryStreetAddressRepository.saveAll(secondaryStreetAddressList);


        //State
        log.info("State");
        List<String> states = (List) fakeValuesService.fetchObject("address.state");
        List<State> stateList = states.stream().map(State::new).distinct().toList();
        log.info("{}", stateList.size());
        stateRepository.saveAll(stateList);

        //StateAbbr
        log.info("StateAbbr");
        List<String> stateAbbrs = (List) fakeValuesService.fetchObject("address.state_abbr");
        List<StateAbbr> stateAbbrList = stateAbbrs.stream().map(StateAbbr::new).distinct().toList();
        log.info("{}", stateAbbrList.size());
        stateAbbrRepository.saveAll(stateAbbrList);

        //StreetAddress
        log.info("StreetAddress");
        Set<StreetAddress> streetAddresses = new HashSet<>();
        for (int i = 0; i < 10000000; i++) {
            streetAddresses.add(new StreetAddress(address.streetAddress()));
        }
        List<StreetAddress> streetAddressList = streetAddresses.stream().distinct().toList();
        log.info("{}", streetAddressList.size());
        streetAddressRepository.saveAll(streetAddressList);

        //StreetAddressNumber
        log.info("StreetAddressNumber");
        List<StreetAddressNumber> streetAddressNumbers = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            streetAddressNumbers.add(new StreetAddressNumber(String.valueOf(i)));
        }
        log.info("{}", streetAddressNumbers.size());
        streetAddressNumberRepository.saveAll(streetAddressNumbers);

        //StreetName
        log.info("StreetName");
        Set<StreetName> streetNames = new HashSet<>();
        for (int i = 0; i < 10000000; i++) {
            streetNames.add(new StreetName(address.streetName()));
        }
        List<StreetName> streetNameList = streetNames.stream().distinct().toList();
        log.info("{}", streetNameList.size());
        streetNameRepository.saveAll(streetNameList);

        //StreetSuffix
        log.info("StreetSuffix");
        List<String> streetSuffixes = (List) fakeValuesService.fetchObject("address.street_suffix");
        List<StreetSuffix> streetSuffixList = streetSuffixes.stream().map(StreetSuffix::new).distinct().toList();
        log.info("{}", streetSuffixList.size());
        streetSuffixRepository.saveAll(streetSuffixList);

        //TimeZone
        log.info("TimeZone");
        List<String> timezones = (List) fakeValuesService.fetchObject("address.time_zone");
        List<TimeZone> timeZoneList = timezones.stream().map(TimeZone::new).distinct().toList();
        log.info("{}", timeZoneList.size());
        timeZoneRepository.saveAll(timeZoneList);

        //ZipCode
/*        log.info("ZipCode");
        List<ZipCode> zipCodes = null;
        for (int i = 10000; i <= 99999; i++) {
            zipCodes = new ArrayList<>();
            zipCodeRepository.save(new ZipCode(String.valueOf(i)));
            for (int j = 1000; j <= 9999; j++) {
                zipCodes.add(new ZipCode(i + "-" + j));
            }
            zipCodeRepository.saveAll(zipCodes);
        }*/
        //zipCodeRepository.saveAll(zipCodes);


        //ZipCodeByState
        log.info("ZipCodeByState");
        LinkedHashMap<String, String> stateByCode = (LinkedHashMap) fakeValuesService.fetchObject("address.postcode_by_state");
        List<ZipCodeByState> zipCodeByStates = new ArrayList<>();
        Set<String> stateAbbr = stateByCode.keySet();
        stateAbbr.forEach(s -> {
            String stateCode = stateByCode.get(s);
            String i = stateCode.substring(0, 3);
            for (int j = 10; j <= 99; j++) {
                zipCodeByStates.add(new ZipCodeByState(s,i + j));
            }
        });
        log.info("{}",zipCodeByStates.size());
        zipCodeByStateRepository.saveAll(zipCodeByStates);
    }
}

