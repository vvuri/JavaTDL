package ru.vvuri.zero.step5.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLogin {
    String email;
    String password;
}