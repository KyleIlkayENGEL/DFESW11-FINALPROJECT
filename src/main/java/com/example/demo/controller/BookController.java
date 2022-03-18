package com.example.demo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDto;
import com.example.demo.service.BookService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/book")
@Slf4j
@Validated
public class BookController {

  @Autowired
  private BookService bookService;

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Book> addBook(@RequestBody @Valid BookDto bookDto) {
   Book book =  bookService.addBookDto(bookDto);
   return  ok().body(book);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<BookDto> getBookById(
      @NotNull @PathVariable("id") Long id) {
    return ok().body(bookService.getBookDtoById(id));
  }

  @GetMapping(path = "/byTitle", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<BookDto>> getBookByTitle(
      @NotNull @NotBlank @RequestParam String title) {
    return ok().body(bookService.getBookByTitle(title));
  }

  @GetMapping(path = "/byAuthor", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<BookDto>> getBookByAuthor(
      @NotNull @NotBlank @RequestParam String author) {
    return ok().body(bookService.getBookByAuthor(author));
  }
}
