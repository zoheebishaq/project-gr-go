package com.greta.golf.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
@Getter
@Setter
@Entity
@Table(name = "PARCOURS")
public class Parcours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private long id;
    @Basic
    @Column(name = "NAME")
    private String nom;
    @ManyToOne
    @JoinColumn(name = "GOLF_ID")
    private Golf golf;

    @OneToMany(mappedBy = "parcours")
    private Collection <Trou> trous;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcours parcours = (Parcours) o;
        return id == parcours.id && nom.equals(parcours.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    @Override
    public String toString() {
        return "Parcours{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
