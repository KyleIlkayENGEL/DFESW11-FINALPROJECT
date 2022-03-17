package com.example.demo.repository;

import com.example.demo.dto.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookItemRepository extends JpaRepository<BookItem, Long> {

  Optional<BookItem> findById(Long id);

  List<BookItem> findByBookId(Long bookId);
}
