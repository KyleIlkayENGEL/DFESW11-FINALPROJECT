package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

  Optional<Reader> findById(Long id);
}
