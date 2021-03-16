package com.greta.golf.dao;

import com.greta.golf.models.Golf;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GolfRepository extends CrudRepository<Golf, Long> {
    List<Golf> findGolfByNom(String nom);
}
