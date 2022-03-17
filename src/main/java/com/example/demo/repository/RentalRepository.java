package com.example.demo.repository;

import com.example.demo.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

  Optional<Rental> findById(Long id);

  int countByReaderIdAndReturnTimeIsNull(Long readerId);
}
