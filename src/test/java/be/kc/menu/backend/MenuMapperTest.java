package be.kc.menu.backend;


import be.kc.menu.backend.domain.Category;
import be.kc.menu.backend.domain.Ingredient;
import be.kc.menu.backend.domain.Instruction;
import be.kc.menu.backend.domain.Menu;
import be.kc.menu.backend.dto.MenuDto;
import be.kc.menu.backend.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MenuMapperTest {

    @Autowired
    MenuMapper menuMapper;

    @Test
    public void mainSuccessScenarioTest() {
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

        MenuDto result = menuMapper.map(given);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(given.getName());
        assertThat(result.getCategoryName()).isEqualTo(given.getCategory().getName());
    }
}