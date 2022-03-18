package com.example.demo.controller;

import com.example.demo.dto.RentalDto;
import com.example.demo.service.RentalService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("v1/rental")
@Slf4j
@Validated
public class RentalController {

  @Autowired
  private RentalService rentalService;

  @PostMapping(path = "/rent", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> rentABook(@RequestBody @Valid RentalDto rentalDto) {
    rentalService.rentABook(rentalDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<RentalDto> getRentalById(
      @NotNull @PathVariable("id") Long id) {
    return ok().body(rentalService.getRentalDtoById(id));
  }

  @PutMapping(path = "/return/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> returnABook(@NotNull @RequestParam Long id) {
    rentalService.returnABook(id);
    return ok().build();
  }
}
