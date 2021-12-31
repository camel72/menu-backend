package be.kc.menu.backend.controller;

import be.kc.menu.backend.dto.MenuDto;
import be.kc.menu.backend.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/rest/v1/menu")
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/getMenus")
    private List<MenuDto> getMenus() {
        return menuService.getMenus();
    }

    @PostMapping("/saveMenu")
    private void saveMenu(@RequestBody MenuDto menuDto) {
        menuService.saveMenu(menuDto);
    }
}
