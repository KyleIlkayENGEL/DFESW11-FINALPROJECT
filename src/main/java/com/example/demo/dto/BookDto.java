package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto implements Serializable {

  @NotNull
  @NotBlank
  private String title;

  @NotNull
  @NotBlank
  private String author;

  private int publicationYear;
}
