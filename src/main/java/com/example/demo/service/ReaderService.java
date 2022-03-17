package com.example.demo.service;


import com.example.demo.domain.Reader;
import com.example.demo.dto.ReaderDto;
import com.example.demo.repository.ReaderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@Slf4j
public class ReaderService {

  @Autowired
  private ReaderRepository readerRepository;

  public void addReader(Reader reader) {
    log.info("Method addReader started.");
    readerRepository.save(reader);
  }

  private Reader getReaderById(Long id) {
    log.info("Method getReaderById started for id: {}", id);
    return readerRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Reader not found"));
  }

  public ReaderDto getReader(Long id) {
    Reader reader = getReaderById(id);
    ReaderDto readerDto  = new ReaderDto();
    readerDto.setName(reader.getName());
    readerDto.setLastName(reader.getLastName());
    return readerDto;
  }

  public void addReader(ReaderDto readerDto) {
    Reader reader = new Reader();
    reader.setName(readerDto.getName());
    reader.setLastName(readerDto.getLastName());
    readerRepository.save(reader);
  }
}
