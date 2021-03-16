package com.greta.golf.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
@Getter
@Setter
@Entity
@Table(name = "GOLF")
public class Golf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private long id;
    @Basic
    @Column(name = "NAME",nullable = false)
    private String nom;
    @OneToMany(mappedBy = "golf")
    private Collection <Parcours> parcours;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Golf golf = (Golf) o;
        return id == golf.id && Objects.equals(nom, golf.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }


    @Override
    public String toString() {
        return "Golf{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
