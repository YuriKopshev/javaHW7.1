package ru.netology.conditionalapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConditionalAppApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private TestRestTemplate restTemplate1;

    private static final GenericContainer<?> myApp = new GenericContainer<>("devapp").withExposedPorts(8080);
    private static final GenericContainer<?> myApp1 = new GenericContainer<>("prodapp").withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        myApp.start();
        myApp1.start();
    }

    @Test
    void checkDevProfile() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:"
                + myApp.getMappedPort(8080), String.class);
        assertEquals("current profile is dev", entity.getBody());
    }

    @Test
    void checkProductionProfile() {
        ResponseEntity<String> entity1 = restTemplate1.getForEntity("http://localhost:"
                + myApp1.getMappedPort(8081), String.class);
        assertEquals("Current profile is production", entity1.getBody());
    }
}
