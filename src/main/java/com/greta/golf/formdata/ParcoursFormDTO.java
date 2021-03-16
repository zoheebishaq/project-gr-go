package com.greta.golf.formdata;

import com.greta.golf.models.Golf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParcoursFormDTO {
    private long id;
    private String nom;
    private long golfId;
}
