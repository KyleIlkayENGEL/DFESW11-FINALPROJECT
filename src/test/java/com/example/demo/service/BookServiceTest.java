package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDto;
import com.example.demo.repository.BookRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

import static com.example.demo.TestConstants.*;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BookServiceTest {

  @Mock
  private BookRepository bookRepository;

  @InjectMocks
  private BookService bookService;

  @Test
  public void addBook_success() {
    Book book = buildBook();
    when(bookRepository.save(book)).thenReturn(null);

    bookService.addBook(book);

    verify(bookRepository).save(book);
  }

  @Test
  public void getBookById_success() {
    Book book = buildBook();
    when(bookRepository.findById(1L)).thenReturn(of(book));

    bookService.getBookById(1L);

    verify(bookRepository).findById(1L);
  }

  @Test
  public void getBookById_notFound() {
    when(bookRepository.findById(1L)).thenReturn(empty());

    assertThrows(EntityNotFoundException.class, () -> bookService.getBookById(1L));
  }

  @Test
  public void getBookByTitle_success() {
    Book book = buildBook();
    when(bookRepository.findByTitle(BOOK_TITLE)).thenReturn(List.of(book));

    bookService.getBookByTitle(BOOK_TITLE);

    verify(bookRepository).findByTitle(BOOK_TITLE);
  }

  @Test
  public void getBookByTitle_notFound() {
    when(bookRepository.findByTitle(BOOK_TITLE)).thenReturn(Collections.emptyList());

    assertThrows(EntityNotFoundException.class, () -> bookService.getBookByTitle(BOOK_TITLE));
  }

  @Test
  public void getBookByAuthor_success() {
    Book book = buildBook();
    when(bookRepository.findByAuthor(BOOK_AUTHOR)).thenReturn(List.of(book));

    bookService.getBookByAuthor(BOOK_AUTHOR);

    verify(bookRepository).findByAuthor(BOOK_AUTHOR);
  }

  @Test
  public void getBookByAuthor_notFound() {
    when(bookRepository.findByAuthor(BOOK_AUTHOR)).thenReturn(Collections.emptyList());

    assertThrows(EntityNotFoundException.class, () -> bookService.getBookByAuthor(BOOK_AUTHOR));
  }

  public static BookDto buildBookDto() {
    return BookDto.builder()
            .title(BOOK_TITLE)
            .author(BOOK_AUTHOR)
            .publicationYear(PUBLICATION_YEAR)
            .build();
  }

  public static Book buildBook() {
    return Book.builder()
            .id(1L)
            .title(BOOK_TITLE)
            .author(BOOK_AUTHOR)
            .publicationYear(PUBLICATION_YEAR)
            .build();
  }
}
