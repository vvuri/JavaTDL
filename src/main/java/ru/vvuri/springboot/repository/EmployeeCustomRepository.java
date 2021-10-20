package ru.vvuri.springboot.repository;

import ru.vvuri.springboot.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeCustomRepository {

    List<EmployeeEntity> findCustomQuery();
}
