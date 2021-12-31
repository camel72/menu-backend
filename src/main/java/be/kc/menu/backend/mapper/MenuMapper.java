package be.kc.menu.backend.mapper;

import be.kc.menu.backend.domain.Menu;
import be.kc.menu.backend.dto.MenuDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
public interface MenuMapper {

    @Mapping(target = "categoryName", source="category.name")
    MenuDto map(Menu menu);

    Menu map(MenuDto menu);
}
