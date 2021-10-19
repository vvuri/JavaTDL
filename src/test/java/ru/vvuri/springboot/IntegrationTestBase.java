package ru.vvuri.springboot;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@SpringBootTest
@Transactional  // позволяет откатывать тесты после выполнения
public abstract class IntegrationTestBase extends AbstractTestNGSpringContextTests {
}
