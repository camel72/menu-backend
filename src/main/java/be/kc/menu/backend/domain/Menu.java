package be.kc.menu.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredientsList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Instruction> instructionsList;
}
