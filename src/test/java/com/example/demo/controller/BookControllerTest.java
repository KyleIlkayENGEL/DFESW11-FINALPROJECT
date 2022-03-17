package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDto;
import com.example.demo.service.BookService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.demo.TestConstants.BOOK_AUTHOR;
import static com.example.demo.TestConstants.BOOK_TITLE;
import static com.example.demo.service.BookServiceTest.buildBook;
import static com.example.demo.service.BookServiceTest.buildBookDto;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

  @Mock
  private BookService bookService;

  @InjectMocks
  private BookController bookController;

  @Test
  public void addBook_success() {
    BookDto bookDto = buildBookDto();
    doNothing().when(bookService).addBookDto(bookDto);

    bookController.addBook(bookDto);

    verify(bookService).addBookDto(bookDto);
  }

  @Test
  public void getBookById_success() {
    BookDto bookDto = buildBookDto();
    when(bookService.getBookDtoById(1L)).thenReturn(bookDto);

    bookController.getBookById(1L);

    verify(bookService).getBookDtoById(1L);
  }

  @Test
  public void getBookByTitle_success() {
    BookDto bookDto = buildBookDto();
    when(bookService.getBookByTitle(BOOK_TITLE)).thenReturn(List.of(bookDto));

    bookController.getBookByTitle(BOOK_TITLE);

    verify(bookService).getBookByTitle(BOOK_TITLE);
  }

  @Test
  public void getBookByAuthor_success() {
    BookDto bookDto = buildBookDto();
    when(bookService.getBookByAuthor(BOOK_AUTHOR)).thenReturn(List.of(bookDto));

    bookController.getBookByAuthor(BOOK_AUTHOR);

    verify(bookService).getBookByAuthor(BOOK_AUTHOR);
  }
}
