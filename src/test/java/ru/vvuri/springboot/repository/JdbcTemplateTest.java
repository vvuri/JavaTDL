package ru.vvuri.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.testng.annotations.Test;
import ru.vvuri.springboot.IntegrationTestBase;
import ru.vvuri.springboot.entity.CompanyEntity;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class JdbcTemplateTest extends IntegrationTestBase {

    private static final String INSERT_SQL = "INSERT INTO company (name) VALUES (?);";
    private static final String DELETE_RETURNING_SQL = "DELETE FROM company WHERE name = ? RETURNING * ;";

    @Autowired
    private JdbcOperations jdbcOperations;

    @Test
    void testInsert() {
        int result = jdbcOperations.update(INSERT_SQL, "Microsoft");
        assertEquals(result, 1);
    }

    @Test
    void testDeleteWithReturning() {
        String companyName = "Microsoft";
        jdbcOperations.update(INSERT_SQL, companyName);

        List<CompanyEntity> result =  jdbcOperations.query(DELETE_RETURNING_SQL,
                (rs, rowNum) -> CompanyEntity.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .build(), companyName);
        assertEquals(result.stream().count(), 1);
    }
}
