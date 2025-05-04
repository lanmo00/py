// src/main/java/com/example/demo/controller/BookController.java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    /**
     * 获取所有图书
     * @return 图书列表
     */
    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    /**
     * 创建新图书
     * @param newBook 图书数据
     * @return 已保存的图书
     */
    @PostMapping
    public Book createBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    // 其他端点省略...
}

// src/main/java/com/example/demo/model/Book.java
package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false)
    private String author;
    
    private Integer publicationYear;
}