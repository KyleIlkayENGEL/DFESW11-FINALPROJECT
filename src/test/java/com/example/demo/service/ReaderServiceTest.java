package com.example.demo.service;

import com.example.demo.domain.Reader;
import com.example.demo.repository.ReaderRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static com.example.demo.controller.ReaderControllerTest.buildReader;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ReaderServiceTest {

  @Mock
  private ReaderRepository readerRepository;

  @InjectMocks
  private ReaderService readerService;

  @Test
  public void addReader_success() {
    Reader reader = buildReader();
    when(readerRepository.save(reader)).thenReturn(null);

    readerService.addReader(reader);

    verify(readerRepository).save(reader);
  }

  @Test
  public void getReaderById_success() {
    Reader reader = buildReader();
    when(readerRepository.findById(1L)).thenReturn(of(reader));

    readerService.getReader(1L);

    verify(readerRepository).findById(1L);
  }

  @Test
  public void getReaderById_notFound() {
    when(readerRepository.findById(1L)).thenReturn(empty());

    assertThrows(EntityNotFoundException.class, () -> readerService.getReader(1L));
  }
}
