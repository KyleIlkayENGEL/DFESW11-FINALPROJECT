package com.example.demo.controller;

import com.example.demo.domain.Reader;
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
        return ok().body(readerService.getReader(id));
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Reader> addReader(@RequestBody ReaderDto readerDto) {
      Reader reader =  readerService.addReader(readerDto);
      return  ok().body(reader);
    }
}
