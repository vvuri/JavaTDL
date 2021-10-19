package ru.vvuri.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import ru.vvuri.springboot.IntegrationTestBase;
import ru.vvuri.springboot.entity.EmployeeEntity;

import java.util.Optional;

import static org.testng.Assert.assertTrue;

public class EmployeeRepositoryTest extends IntegrationTestBase {

    private static final Integer IVAN_ID = 1;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testFindById() {
        Optional<EmployeeEntity> employee = employeeRepository.findById(IVAN_ID);
        assertTrue(employee.isPresent());
    }
}