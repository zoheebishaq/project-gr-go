package com.greta.golf.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
@Getter
@Setter
@Entity
@Table(name = "TROU")
public class Trou {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false)
    private long id;
    @Basic
    @Column(name = "NAME")
    private String nom;
    @Basic
    @Column(name = "PAR",nullable = false)
    private int par;
    @Basic
    @Column(name = "NUMTROU",nullable = false)
    private int numTrou;
    @ManyToOne
    @JoinColumn(name ="PARCOURS_ID")
    private Parcours parcours;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trou trou = (Trou) o;
        return id == trou.id && par == trou.par && numTrou == trou.numTrou && nom.equals(trou.nom) && Objects.equals(parcours, trou.parcours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, par, numTrou);
    }


    @Override
    public String toString() {
        return "Trou{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", par=" + par +
                ", numTrou=" + numTrou +
                '}';
    }
}

