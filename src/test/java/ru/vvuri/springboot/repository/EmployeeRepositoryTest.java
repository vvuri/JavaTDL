package ru.vvuri.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import ru.vvuri.springboot.IntegrationTestBase;
import ru.vvuri.springboot.entity.EmployeeEntity;
import ru.vvuri.springboot.projection.EmployeeNameView;
import ru.vvuri.springboot.projection.EmployeeNativeView;

import java.util.List;
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

    @Test
    void testFindByFirstName() {
        Optional<EmployeeEntity> employee = employeeRepository.findByFirstNameContaining("Petr");
        assertTrue(employee.isPresent());
    }

    @Test
    void testFindByFirstNameAndSalary() {
        List<EmployeeEntity> employee = employeeRepository.findAllByFirstNameAndSalary("Petr", 2500);
        assertTrue(employee.stream().count() == 1);
    }

    @Test
    void testFindBySalary() {
        List<EmployeeNameView> employee = employeeRepository.findAllBySalaryGreaterThan(500);
        assertTrue(employee.stream().count() == 2);
    }

    @Test
    void testFindBySalaryNative() {
        // Run in Debug mode
        // Alt + F8
        // employee.get(0).getFullName()  -> IvanIvanov
        List<EmployeeNativeView> employee = employeeRepository.findAllBySalaryGreaterThanNative(500);
        assertTrue(employee.stream().count() == 2);
    }

    @Test
    void testFindCustomQuery() {
        List<EmployeeEntity> customQuery = employeeRepository.findCustomQuery();
        assertTrue(customQuery.stream().count() == 0);
    }
}