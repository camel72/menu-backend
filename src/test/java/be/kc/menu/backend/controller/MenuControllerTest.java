package be.kc.menu.backend.controller;

import be.kc.menu.backend.domain.Category;
import be.kc.menu.backend.dto.MenuDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuControllerTest {
    private static final String SERVER_URL = "http://localhost:";
    private static String CONTEXT_URL = "/rest/v1/menu";

    @LocalServerPort
    int port;

    @Autowired
    private MenuController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void smokeTest() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void saveMenu(){
        MenuDto menuDto = MenuDto.builder()
                .categoryName("testCat")
                .name("testName")
                .build();

        ResponseEntity response = restTemplate.postForEntity(SERVER_URL + port + CONTEXT_URL + "/save", menuDto, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
