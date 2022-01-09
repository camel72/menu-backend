package be.kc.menu.backend.repository;

import be.kc.menu.backend.domain.Category;
import be.kc.menu.backend.domain.Ingredient;
import be.kc.menu.backend.domain.Instruction;
import be.kc.menu.backend.domain.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MenuRepositoryTest {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    EntityManager em;

    @Test
    void testSaveMenu() {
        Menu given = Menu.builder()
                .name("testName")
                .category(Category.builder().name("categoryName").build())
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
        assertThat(result.getCategory()).isNotNull();
        assertThat(result.getCategory().getName()).isEqualTo(given.getCategory().getName());
        assertThat(result.getIngredientsList()).isNotNull();
        assertThat(result.getIngredientsList().size()).isEqualTo(1);
        assertThat(result.getIngredientsList().get(0).getName()).isEqualTo(given.getIngredientsList().get(0).getName());
        assertThat(result.getIngredientsList().get(0).getAmount()).isEqualTo(given.getIngredientsList().get(0).getAmount());
        assertThat(result.getInstructionsList()).isNotNull();
        assertThat(result.getInstructionsList().size()).isEqualTo(1);
        assertThat(result.getInstructionsList().get(0).getDescription()).isEqualTo(given.getInstructionsList().get(0).getDescription());
    }

    @Test
    public void testGetMenus() {
        Menu given = Menu.builder()
                .name("testName")
                .category(Category.builder().name("categoryName").build())
                .ingredientsList(List.of(Ingredient.builder()
                        .name("testIngredientName")
                        .amount(1)
                        .build()))
                .instructionsList(List.of(Instruction.builder()
                        .description("instructionDescription")
                        .build()))
                .build();

        menuRepository.save(given);
        em.flush();
        List<Menu> result = menuRepository.findAll();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
        Menu menu = result.get(0);
        assertThat(menu.getName()).isEqualTo(given.getName());
        assertThat(menu.getId()).isNotNull();
        assertThat(menu.getCategory()).isNotNull();
        assertThat(menu.getCategory().getName()).isEqualTo(given.getCategory().getName());
        assertThat(menu.getIngredientsList()).isNotNull();
        assertThat(menu.getIngredientsList().size()).isEqualTo(1);
        assertThat(menu.getIngredientsList().get(0).getName()).isEqualTo(given.getIngredientsList().get(0).getName());
        assertThat(menu.getIngredientsList().get(0).getAmount()).isEqualTo(given.getIngredientsList().get(0).getAmount());
        assertThat(menu.getInstructionsList()).isNotNull();
        assertThat(menu.getInstructionsList().get(0).getDescription()).isEqualTo(given.getInstructionsList().get(0).getDescription());
    }
}