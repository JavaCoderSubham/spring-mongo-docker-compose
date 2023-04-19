package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RestController
@RequestMapping("/book")
public class DemoApplication {

	@Autowired
	private BookRepository repository;

	@PostMapping("/create")
	public Book create(@RequestBody Book book) {
		book.setId(UUID.randomUUID().toString());
		return repository.save(book);
	}

	@GetMapping("/all")
	public List<Book> getAll() {
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
