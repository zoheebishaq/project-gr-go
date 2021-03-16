package com.greta.golf.dao;

import com.greta.golf.models.Parcours;
import com.greta.golf.models.Trou;
import org.springframework.data.repository.CrudRepository;

public interface ParcoursRepository extends CrudRepository<Parcours, Long> {
}
