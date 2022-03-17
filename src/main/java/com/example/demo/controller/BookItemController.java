package com.example.demo.controller;

import com.example.demo.domain.BookItemDto;
import com.example.demo.dto.BookItem;
import com.example.demo.service.BookItemService;
import com.example.demo.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    log.info("Received a call to add book item.");
    BookItem bookItem = BookItem.builder()
            .bookId(bookItemDto.getBookId())
            .status(bookItemDto.getStatus())
            .build();
    bookItemService.addBookItem(bookItem);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<BookItemDto> getBookItemById(
      @NotNull @ApiParam(required = true) @PathVariable("id") Long id) {
    log.info("Received a call to get book item by id for id: {}.", id);
    return ok().body(bookItemService.getBookItemById(id));
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<BookItemDto>> getBookItemByBookId(@NotNull @RequestParam Long bookId) {
    log.info("Received a call to get book item by id for book id: {}.", bookId);
    return ok().body(bookItemService.getBookItemByBookId(bookId));
  }

  @ApiOperation(
      value = "Update book item as destroyed by id",
      nickname = "updateBookItemAsDestroyed",
      response = ResponseEntity.class)
  @PutMapping(path = "/update/{id}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> updateBookItemAsDestroyed(@NotNull @RequestParam Long id) {
    log.info("Received a call to update book item as destroyed by id for id: {}.", id);
    bookItemService.updateBookItemAsDestroyed(id);
    return ok().build();
  }
}
