package com.example.demo.repository;

import com.example.demo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

  Optional<Book> findById(Long id);

  List<Book> findByTitle(String title);

  List<Book> findByAuthor(String author);
}
