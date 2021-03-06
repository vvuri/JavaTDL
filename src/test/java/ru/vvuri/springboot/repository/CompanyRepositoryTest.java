package ru.vvuri.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import ru.vvuri.springboot.IntegrationTestBase;
import ru.vvuri.springboot.entity.CompanyEntity;

import java.util.Optional;

import static org.testng.Assert.*;

public class CompanyRepositoryTest extends IntegrationTestBase {

    private static final Integer APPLE_ID = 1;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void testGetById() {
        Optional<CompanyEntity> company = companyRepository.findById(APPLE_ID);
        assertTrue(company.isPresent());
        company.ifPresent(entity -> {
            assertEquals("Apple", entity.getName());
        });
    }

    @Test
    void testSave() {
        CompanyEntity company = CompanyEntity.builder()
                .name("Fitbit")
                .build();
        companyRepository.save(company);
        assertNotNull(company.getId());
    }

    // TODO:
    // @Transactional - не работет
    // есть ошибка  Spring Data JDBC now requires a Dialect for each database
}