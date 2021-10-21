package ru.vvuri.springboot;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeClass;
import ru.vvuri.springboot.initialazer.Postgres;

@Sql("/sql/data.sql") // залить данные в таблицы
@ActiveProfiles("test")
@SpringBootTest
@ContextConfiguration(initializers = { Postgres.Initializer.class })  // запустить контейнер с базой данных
@Transactional  // позволяет откатывать тесты после выполнения
public abstract class IntegrationTestBase extends AbstractTestNGSpringContextTests {
    @BeforeClass
    static void init() {
        Postgres.container.start();
    }
}
