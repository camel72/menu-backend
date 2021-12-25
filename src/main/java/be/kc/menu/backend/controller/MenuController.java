package be.kc.menu.backend.controller;

import be.kc.menu.backend.dto.MenuDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/menu")
public class MenuController {

  @GetMapping("/getMenus")
  List<MenuDto> getMenus() {
    return null;
  }
}
