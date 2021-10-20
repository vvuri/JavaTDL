package ru.vvuri.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vvuri.springboot.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    Optional<EmployeeEntity> findByFirstNameContaining(String firstName);

    // запрос по нескольким параметрам
    // весь запрос описан в имени, согласно правилами из
    // Spring JPA Documentation -> Query Creation
    // или можно написать через query запрос напрямую используя либо индекс параметра
    // @Query("select e from EmployeeEntity e where e.firstName = ?1 and e.salary = ?2")
    // либо предочтительно имя
    // @Query("select e from EmployeeEntity e where e.firstName = :name and e.salary = :salary")
    // можно также написать запрос как nativeQuery = true
    @Query(value = "select e.* from employee e where e.first_name = :name and e.salary = :salary", nativeQuery = true)
    List<EmployeeEntity> findAllByFirstNameAndSalary(@Param("name") String firstName, @Param("salary") Integer salary);
}
