package it.bootcamp.dto;

import it.bootcamp.entity.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserDto {
    private Long id;
    @Size(min = 1, max = 40, message = "Up to 40 latin letters allowed")
    @Pattern(regexp = "[a-zA-Z]*", message = "Only latin letters are allowed")
    private String surname;
    @Size(min = 1, max = 20, message = "Up to 20 latin letters allowed")
    @Pattern(regexp = "[a-zA-Z]*", message = "Only latin letters are allowed")
    private String name;
    @Size(min = 1, max = 40, message = "Up to 40 latin letters allowed")
    @Pattern(regexp = "[a-zA-Z]*", message = "Only latin letters are allowed")
    private String patronymic;
    @Email(message = "Not match email format")
    @Size(min = 1, max = 50, message = "Up to 50 latin letters allowed")
    private String email;
    private Role role;

    public UserDto(final Long id, final String surname, final String name,
                   final String patronymic, final String email, final Role role) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
        this.role = role;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final UserDto userDto;

        public Builder() {
            userDto = new UserDto();
        }

        public Builder id(final Long id) {
            userDto.setId(id);
            return this;
        }

        public Builder surname(final String surname) {
            userDto.setSurname(surname);
            return this;
        }

        public Builder name(final String name) {
            userDto.setName(name);
            return this;
        }

        public Builder patronymic(final String patronymic) {
            userDto.setPatronymic(patronymic);
            return this;
        }

        public Builder email(final String email) {
            userDto.setEmail(email);
            return this;
        }

        public Builder role(final Role role) {
            userDto.setRole(role);
            return this;
        }

        public UserDto build() {
            return userDto;
        }
    }
}
