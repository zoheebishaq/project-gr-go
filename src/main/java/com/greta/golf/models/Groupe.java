package com.greta.golf.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private Long id;
    @Basic
    @Column(name="NAME",nullable = false,length = 50)
    private String nom;
    @Basic
    @Column(name="ROLE",nullable = false,length = 50)
    private String role;
    @ManyToMany(mappedBy = "groupes")
    private Set<User>users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groupe groupe1 = (Groupe) o;
        return id.equals(groupe1.id) && nom.equals(groupe1.nom) && role.equals(groupe1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, role);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
