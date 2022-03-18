package com.example.demo.controller;

import com.example.demo.domain.BookItemDto;
import com.example.demo.dto.BookItem;
import com.example.demo.service.BookItemService;
import com.example.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("v1/bookItem")
@Slf4j
@Validated
public class BookItemController {

  @Autowired
  private BookItemService bookItemService;


  @Autowired
  private BookService bookService;

  @PostMapping(produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> addBookItem(@RequestBody @Valid BookItemDto bookItemDto) {
    BookItem bookItem = BookItem.builder()
            .bookId(bookItemDto.getBookId())
            .status(bookItemDto.getStatus())
            .build();
    bookItemService.addBookItem(bookItem);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<BookItemDto> getBookItemById(
      @NotNull @PathVariable("id") Long id) {
    return ok().body(bookItemService.getBookItemById(id));
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<BookItemDto>> getBookItemByBookId(@NotNull @RequestParam Long bookId) {
    return ok().body(bookItemService.getBookItemByBookId(bookId));
  }

  @PutMapping(path = "/update/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> updateBookItemAsDestroyed(@NotNull @RequestParam Long id) {
    bookItemService.updateBookItemAsDestroyed(id);
    return ok().build();
  }
}
