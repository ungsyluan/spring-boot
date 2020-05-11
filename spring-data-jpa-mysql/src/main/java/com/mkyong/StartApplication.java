package com.mkyong;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

	@Autowired
	private BookRepository repository;
	@Autowired
	private BookDetailsRepository detailsRepository;
	String name = "A+";

	@Autowired
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	public void run(String... args) {
		repository.save(new Book("Java"));
		repository.save(new Book("Node"));
		repository.save(new Book("python"));
		repository.save(new Book("A+"));
//		Book book = repository.findById(Long.valueOf("1")).get();
//		detailsRepository.save(new BookDetails(book, 200, "this is Java"));
		System.out.print(getBookByName("A+"));
		

	}

	String getBookByName(@Param("name") String bookName) {
		// Scalar function
		Query query = entityManager.createQuery("SELECT * from DBCatalog");
		List<Book> books = query.getResultList();		
		return books.toString();
	}

}