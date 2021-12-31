package be.kc.menu.backend.service;

import be.kc.menu.backend.domain.Menu;
import be.kc.menu.backend.dto.MenuDto;
import be.kc.menu.backend.mapper.MenuMapper;
import be.kc.menu.backend.repository.MenuRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Getter
public class MenuService {

    private MenuMapper menuMapper;
    private MenuRepository menuRepository;

    public List<MenuDto> getMenus() {
        return menuRepository.findAll().stream()
                .map(menu -> menuMapper.map(menu))
                .collect(Collectors.toList());
    }

    public MenuDto saveMenu(MenuDto menuDto) {
        Menu menu = menuMapper.map(menuDto);
        Menu savedMenu = menuRepository.save(menu);
        return menuMapper.map(savedMenu);
    }
}