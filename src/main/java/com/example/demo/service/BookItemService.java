package com.example.demo.service;

import com.example.demo.domain.BookItemDto;
import com.example.demo.dto.BookItem;
import com.example.demo.dto.BookItemStatus;
import com.example.demo.repository.BookItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BookItemService {

  @Autowired
  private BookItemRepository bookItemRepository;

  @Autowired
  private BookService bookService;

  public void addBookItem(BookItem bookItem) {
    log.info("Method addBookItem started.");
    bookService.getBookById(bookItem.getBookId());
    bookItem.setStatus(BookItemStatus.AVAILABLE);
    bookItemRepository.save(bookItem);
  }

  public BookItemDto getBookItemById(Long id) {
    log.info("Method getBookItemById started for id: {}.", id);
    BookItem bookItem = bookItemRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Book Item not found"));
    return BookItemDto.builder()
            .bookId(bookItem.getBookId())
            .status(bookItem.getStatus())
            .build();
  }

  public List<BookItemDto> getBookItemByBookId(Long bookId) {
    log.info("Method getBookItemByBookId started for book id: {}.", bookId);
    bookService.getBookById(bookId);
    List<BookItem> bookItemList = bookItemRepository.findByBookId(bookId);

    if (bookItemList.isEmpty()) {
      throw new EntityNotFoundException("Book Item not found");
    }

    List<BookItemDto> bookItemDtoList = new ArrayList<>();
    for(BookItem bookItem : bookItemList) {
      BookItemDto bookItemDto = BookItemDto.builder()
              .bookId(bookItem.getBookId())
              .status(bookItem.getStatus())
              .build();
      bookItemDtoList.add(bookItemDto);
    }

    return bookItemDtoList;
  }

  public void updateBookItemAsDestroyed(Long id) {
    log.info("Method updateBookItemAsDestroyed started for id: {}.", id);
    BookItem bookItem = bookItemRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Book Item not found"));
    bookItem.setStatus(BookItemStatus.DESTROYED);
    bookItemRepository.save(bookItem);
  }
}
