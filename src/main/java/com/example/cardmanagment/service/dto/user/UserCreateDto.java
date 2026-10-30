package com.example.cardmanagment.service.dto.user;

import com.example.cardmanagment.entity.enumed.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateDto {

    @NotBlank(message = "Поле email не должно быть пустым")
    @Email(message = "Некорректный формат email")
    private String email;

    @NotBlank(message = "Поле username обязательно для заполнения")
    @Size(min = 3, max = 25, message = "Username должно быть от 3 до 25 символов")
    private String username;

    @NotBlank(message = "Пароль обязателен для пользователя")
    @Size(min = 6, message = "Пароль должен содержать в себе минимум 6 символов")
    private String password;

    private RoleType roleType;
}
