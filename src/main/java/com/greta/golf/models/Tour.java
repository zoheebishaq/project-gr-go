package com.greta.golf.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateTour;
    private int nbJoueurPartie;
    private int numTour;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateTour() {
        return dateTour;
    }

    public void setDateTour(Date dateTour) {
        this.dateTour = dateTour;
    }

    public int getNbJoueurPartie() {
        return nbJoueurPartie;
    }

    public void setNbJoueurPartie(int nbJoueurPartie) {
        this.nbJoueurPartie = nbJoueurPartie;
    }

    public int getNumTour() {
        return numTour;
    }

    public void setNumTour(int numTour) {
        this.numTour = numTour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return id == tour.id && nbJoueurPartie == tour.nbJoueurPartie && numTour == tour.numTour && dateTour.equals(tour.dateTour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTour, nbJoueurPartie, numTour);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", dateTour=" + dateTour +
                ", nbJoueurPartie=" + nbJoueurPartie +
                ", numTour=" + numTour +
                '}';
    }
}
