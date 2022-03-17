package com.example.demo.controller;

import com.example.demo.domain.Reader;
import com.example.demo.dto.ReaderDto;
import com.example.demo.service.ReaderService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.demo.TestConstants.READER_LASTNAME;
import static com.example.demo.TestConstants.READER_NAME;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ReaderControllerTest {

  @Mock
  private ReaderService readerService;

  @InjectMocks
  private ReaderController readerController;

  @Test
  public void addReader_success() {
    ReaderDto readerDto = buildReaderDto();
    Reader reader = buildReader();
    doNothing().when(readerService).addReader(reader);

    readerController.addReader(readerDto);

    verify(readerService).addReader(readerDto);
  }

  @Test
  public void getReaderById_success() {
    ReaderDto readerDto = buildReaderDto();
    Reader reader = buildReader();
    when(readerService.getReader(1L)).thenReturn(readerDto);

    readerController.getReaderById(1L);

    verify(readerService).getReader(1L);
  }

  public static ReaderDto buildReaderDto() {
    return ReaderDto.builder().name(READER_NAME).lastName(READER_LASTNAME).build();
  }

  public static Reader buildReader() {
    return Reader.builder().id(1L).name(READER_NAME).lastName(READER_LASTNAME).build();
  }

}
