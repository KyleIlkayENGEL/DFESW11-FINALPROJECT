package com.example.demo.service;

import com.example.demo.domain.Rental;
import com.example.demo.dto.RentalDto;
import com.example.demo.repository.RentalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;

import static com.example.demo.dto.BookItemStatus.DESTROYED;

@Service
@Slf4j
public class RentalService {

  @Autowired
  private RentalRepository rentalRepository;

  @Autowired
  private BookItemService bookItemService;

  @Autowired
  private ReaderService readerService;

  public void rentABook(RentalDto rentalDto) {
    log.info("Method rentABook started.");
    readerService.getReaderById(rentalDto.getReaderId());

    if (bookItemService.getBookItemById(rentalDto.getBookItemId()).getStatus() == DESTROYED) {
      throw new RuntimeException("This book item has been destroyed.");
    }

    if (rentalRepository.countByReaderIdAndReturnTimeIsNull(rentalDto.getReaderId()) >= 5) {
      throw new EntityNotFoundException("You reached maximum rental count.");
    }

    Rental rental = Rental.builder()
            .bookItemId(rentalDto.getBookItemId())
            .rentalTime(new Timestamp(System.currentTimeMillis()))
            .build();

    rentalRepository.save(rental);
  }

  public Rental getRentalById(Long id) {
    log.info("Method getRentalById started for id: {}", id);
    return rentalRepository
        .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Rental not found."));
  }
  public RentalDto getRentalDtoById(Long id) {
    log.info("Method getRentalById started for id: {}", id);
    Rental rental = getRentalById(id);
    return RentalDto.builder()
            .bookItemId(rental.getBookItemId())
            .readerId(rental.getReaderId())
            .build();
  }

  public void returnABook(Long id) {
    log.info("Method returnABook started for id: {}", id);
    Rental rental = getRentalById(id);

    if (rental.getReturnTime() != null) {
      throw new RuntimeException("This rental has already returned.");
    }
    rental.setReturnTime(new Timestamp(System.currentTimeMillis()));
    rentalRepository.save(rental);
  }
}
