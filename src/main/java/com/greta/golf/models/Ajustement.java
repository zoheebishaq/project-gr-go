package com.greta.golf.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class Ajustement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tempsAjustement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTempsAjustement() {
        return tempsAjustement;
    }

    public void setTempsAjustement(int tempsAjustement) {
        this.tempsAjustement = tempsAjustement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ajustement that = (Ajustement) o;
        return tempsAjustement == that.tempsAjustement && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tempsAjustement);
    }

    @Override
    public String toString() {
        return "Ajustement{" +
                "id=" + id +
                ", tempsAjustement=" + tempsAjustement +
                '}';
    }
}
