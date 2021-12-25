package be.kc.menu.backend.repository;

import be.kc.menu.backend.domain.Ingredient;
import be.kc.menu.backend.domain.Instruction;
import be.kc.menu.backend.domain.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MenuRepositoryTest {

  @Autowired
  MenuRepository menuRepository;

  @Test
  void testSaveMenu() {
    Menu given = Menu.builder()
      .name("testName")
      .ingredientsList(List.of(Ingredient.builder()
        .name("testIngredientName")
        .amount(1)
        .build()))
      .instructionsList(List.of(Instruction.builder()
        .description("instructionDescription")
        .build()))
      .build();

    Menu result = menuRepository.save(given);

    assertThat(result).isNotNull();
    assertThat(result.getName()).isEqualTo(given.getName());
    assertThat(result.getId()).isNotNull();
    assertThat(result.getIngredientsList()).isNotNull();
    assertThat(result.getIngredientsList().size()).isEqualTo(1);
    assertThat(result.getIngredientsList().get(0).getName()).isEqualTo(given.getIngredientsList().get(0).getName());
    assertThat(result.getIngredientsList().get(0).getAmount()).isEqualTo(given.getIngredientsList().get(0).getAmount());
    assertThat(result.getInstructionsList()).isNotNull();
    assertThat(result.getInstructionsList().size()).isEqualTo(1);
    assertThat(result.getInstructionsList().get(0).getDescription()).isEqualTo(given.getInstructionsList().get(0).getDescription());

  }
}
