package it.bootcamp.converter.impl;

import it.bootcamp.converter.Converter;
import it.bootcamp.dto.UserDto;
import it.bootcamp.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDto> {
    @Override
    public UserDto toDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .surname(entity.getSurname())
                .name(entity.getName())
                .patronymic(entity.getPatronymic())
                .email(entity.getEmail())
                .role(entity.getRole())
                .build();
    }

    @Override
    public User toEntity(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .surname(dto.getSurname())
                .name(dto.getName())
                .patronymic(dto.getPatronymic())
                .email(dto.getEmail())
                .role(dto.getRole())
                .build();
    }
}
