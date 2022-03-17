package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDto;
import com.example.demo.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public void addBook(Book book) {
    log.info("Method addBook started.");
    bookRepository.save(book);
  }

  public void addBookDto(BookDto bookDto) {
    log.info("Method addBook started.");
    Book book = new Book();
    book.setAuthor(bookDto.getAuthor());
    book.setTitle(bookDto.getTitle());
    book.setPublicationYear(bookDto.getPublicationYear());

    bookRepository.save(book);
  }

  public Book getBookById(Long id) {
    log.info("Method getBookById started for id: {}.", id);
    return bookRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Book not found"));
  }

  public BookDto getBookDtoById(Long id) {
    Book book = getBookById(id);
    BookDto bookDto = new BookDto();
    bookDto.setAuthor(book.getAuthor());
    bookDto.setTitle(book.getTitle());
    bookDto.setPublicationYear(book.getPublicationYear());
    return bookDto;
  }

  public List<BookDto> getBookByTitle(String title) {
    log.info("Method getBookByTitle started for title: {}.", title);
    List<Book> bookList = bookRepository.findByTitle(title);

    if (bookList.isEmpty()) {
      throw new EntityNotFoundException("Book not found");
    }

    List<BookDto> bookDtoList  = new ArrayList<>();

    for(Book book : bookList) {
      BookDto bookDto = new BookDto();
      bookDto.setAuthor(book.getAuthor());
      bookDto.setTitle(book.getTitle());
      bookDto.setPublicationYear(book.getPublicationYear());
      bookDtoList.add(bookDto);
    }

    return bookDtoList;
  }

  public List<BookDto> getBookByAuthor(String author) {
    log.info("Method getBookByAuthor started for author: {}.", author);
    List<Book> bookList = bookRepository.findByAuthor(author);

    if (bookList.isEmpty()) {
      throw new EntityNotFoundException("Book not found");
    }

    List<BookDto> bookDtoList  = new ArrayList<>();

    for(Book book : bookList) {
      BookDto bookDto = new BookDto();
      bookDto.setAuthor(book.getAuthor());
      bookDto.setTitle(book.getTitle());
      bookDto.setPublicationYear(book.getPublicationYear());
      bookDtoList.add(bookDto);
    }

    return bookDtoList;
  }
}
