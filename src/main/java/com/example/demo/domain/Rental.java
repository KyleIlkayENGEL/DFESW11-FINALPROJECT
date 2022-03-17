package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rental")
public class Rental {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotNull
  @Column(name = "book_item_id", nullable = false)
  private Long bookItemId;

  @NotNull
  @Column(name = "reader_id", nullable = false)
  private Long readerId;

  @NotNull
  @Column(name = "rental_time", nullable = false)
  private Timestamp rentalTime;

  @Column(name = "return_time")
  private Timestamp returnTime;
}
