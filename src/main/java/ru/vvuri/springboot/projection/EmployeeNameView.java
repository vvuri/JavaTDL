package ru.vvuri.springboot.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeNameView {
    // возыращаем несколько полей в одном
    @Value("#{target.id + ' ' + target.firstName}")
    String getFirstName();

    String getLastName();
}
