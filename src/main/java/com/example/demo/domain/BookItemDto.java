package com.example.demo.domain;

import com.example.demo.dto.BookItemStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookItemDto implements Serializable {

  @NotNull
  private Long bookId;

  @Valid
  @NotNull
  private BookItemStatus status;
}
