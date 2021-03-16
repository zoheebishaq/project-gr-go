package com.greta.golf.formdata;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrouFormDTO {
    private long id;
    private String nom;
    private int par;
    private int numTrou;
    private long parcoursId;
}
