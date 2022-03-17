package com.example.demo.controller;

import com.example.demo.dto.ReaderDto;
import com.example.demo.service.ReaderService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("v1/reader")
@Slf4j
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ReaderDto> getReaderById(
            @NotNull @PathVariable("id") Long id) {
        log.info("Received a call to get reader by id for id: {}.", id);
        return ok().body(readerService.getReader(id));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addReader(@RequestBody ReaderDto readerDto) {
        log.info("Received a call to add reader.");
        readerService.addReader(readerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
