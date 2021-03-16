package com.greta.golf.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Tournoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateTournoi;
    private String nom;
    private int nbTours;
    private String commentaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTournoi() {
        return dateTournoi;
    }

    public void setDateTournoi(Date dateTournoi) {
        this.dateTournoi = dateTournoi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbTours() {
        return nbTours;
    }

    public void setNbTours(int nbTours) {
        this.nbTours = nbTours;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournoi tournoi = (Tournoi) o;
        return nbTours == tournoi.nbTours && id.equals(tournoi.id) && dateTournoi.equals(tournoi.dateTournoi) && nom.equals(tournoi.nom) && commentaire.equals(tournoi.commentaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTournoi, nom, nbTours, commentaire);
    }
}
