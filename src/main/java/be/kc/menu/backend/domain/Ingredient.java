package be.kc.menu.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long Id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "AMOUNT")
  private Integer amount;
}
