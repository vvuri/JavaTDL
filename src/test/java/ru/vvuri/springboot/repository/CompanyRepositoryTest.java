package ru.vvuri.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;
import ru.vvuri.springboot.entity.CompanyEntity;

import java.util.Optional;

import static org.testng.Assert.*;

@ActiveProfiles("test")
@SpringBootTest
@Transactional  // позволяет откатывать тесты после выполнения
public class CompanyRepositoryTest extends AbstractTestNGSpringContextTests {

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
}