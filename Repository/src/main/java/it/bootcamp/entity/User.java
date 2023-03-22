package it.bootcamp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname", length = 40)
    private String surname;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "patronymic", length = 40)
    private String patronymic;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(final Long id, final String surname, final String name,
                final String patronymic, final String email, final Role role) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
        this.role = role;
    }

    public User() {
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

    public void setId(final Long id) {
        this.id = id;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final User user;

        public Builder() {
            user = new User();
        }

        public Builder id(final Long id){
            user.setId(id);
            return this;
        }
        public Builder surname(final String surname){
            user.setSurname(surname);
            return this;
        }

        public Builder name(final String name){
            user.setName(name);
            return this;
        }

        public Builder patronymic(final String patronymic){
            user.setPatronymic(patronymic);
            return this;
        }

        public Builder email(final String email){
            user.setEmail(email);
            return this;
        }

        public Builder role(final Role role){
            user.setRole(role);
            return this;
        }

        public User build(){
            return user;
        }
    }
}
