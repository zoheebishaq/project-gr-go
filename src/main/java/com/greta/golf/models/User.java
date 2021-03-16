package com.greta.golf.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID",nullable = false)
    private Long id;
    @Basic
    @Column(name="NAME",nullable = false,length = 50)
    private String login;
    @Basic
    @Column(name="PASSWORD",nullable = false,length = 50)
    private String password;
    @Basic
    @Column(name="ACTIVE",nullable = false,length = 50)
    private boolean active;
    @Basic
    @Column(name="MAIL",nullable = false,length = 50)
    private String email;

    @ManyToMany(fetch =FetchType.EAGER)
            @JoinTable(name="USER_GROUP",
    joinColumns = @JoinColumn(name = "ID_USER",referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name = "ID_Group",referencedColumnName = "ID"))
    private Set<Groupe> groupes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Set<Groupe> groupes) {
        this.groupes = groupes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return active == user.active && id.equals(user.id) && login.equals(user.login) && password.equals(user.password) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, active, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", email='" + email + '\'' +
                '}';
    }
}
