
package com.research.datagenerator;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.research.datagenerator.entity.book.AuthorName;
import com.research.datagenerator.entity.book.BookTitle;
import com.research.datagenerator.entity.book.Genre;
import com.research.datagenerator.entity.book.Publisher;
import com.research.datagenerator.repo.book.AuthorRepository;
import com.research.datagenerator.repo.book.BookTitleRepository;
import com.research.datagenerator.repo.book.GenreRepository;
import com.research.datagenerator.repo.book.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
@Slf4j
public class BookApplication implements CommandLineRunner {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookTitleRepository bookTitleRepository;

	@Autowired
	PublisherRepository publisherRepository;

	@Autowired
	GenreRepository genreRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Faker faker =new Faker(new Locale("en"));
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en"),new RandomService());
		Book book = faker.book();

		//AuthorName
		log.info("AuthorName");
		List<AuthorName> authors = new ArrayList<>();
		for (long i = 0; i < 10000000; i++) {
			AuthorName author = new AuthorName();
			String name = book.author();
			author.setName(name);
			authors.add(author);
		}
		List<AuthorName> authorList = authors.stream().distinct().toList();
		log.info("{}",authorList.size());
		authorRepository.saveAll(authorList);

		//TITLE
		log.info("BookTitle");
		List<String> bookTitles = (List) fakeValuesService.fetchObject("book.title");
		List<BookTitle> bookTitleList = bookTitles.stream().map(BookTitle::new).distinct().toList();
		log.info("{}",bookTitleList.size());
		bookTitleRepository.saveAll(bookTitleList);

		//Publisher
		log.info("Publisher");
		List<String> publishers = (List) fakeValuesService.fetchObject("book.publisher");
		List<Publisher> publisherList = publishers.stream().map(Publisher::new).distinct().toList();
		log.info("{}",publisherList.size());
		publisherRepository.saveAll(publisherList);

		//Genre
		log.info("Genre");
		List<String> genres = (List) fakeValuesService.fetchObject("book.genre");
		List<Genre> genreList = genres.stream().map(Genre::new).distinct().toList();
		log.info("{}",genreList.size());
		genreRepository.saveAll(genreList);
	}
}

