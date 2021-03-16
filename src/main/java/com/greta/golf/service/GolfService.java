package com.greta.golf.service;

import com.google.common.collect.Lists;
import com.greta.golf.dao.*;
import com.greta.golf.formdata.*;
import com.greta.golf.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GolfService {
    GolfRepository golfRepository;
    ParcoursRepository parcoursRepository;
    TrouRepository trouRepository;
    GroupeRepository groupeRepository;
    UserRepository userRepository;

    @Autowired
    public GolfService(GolfRepository golfRepository,
                       ParcoursRepository parcoursRepository,
                       TrouRepository trouRepository,
                       GroupeRepository groupeRepository,
                       UserRepository userRepository) {
        this.golfRepository = golfRepository;
        this.parcoursRepository = parcoursRepository;
        this.trouRepository = trouRepository;
        this.groupeRepository = groupeRepository;
        this.userRepository = userRepository;
    }

    //    Trou----------------------------------------------------------------------------------------------------------
    public List<Trou> getTrous() {
        return Lists.newArrayList(trouRepository.findAll());
    }

    public Trou getTrou(Long id) {
        return trouRepository.findById(id).orElse(new Trou());
    }

    public void deleteTrou(Long id) {
        trouRepository.deleteById(id);
    }

    public void saveTrou(TrouFormDTO trouFormDTO){
        Trou trouDB = trouRepository.findById(trouFormDTO.getId()).orElse(new Trou());
        trouDB.setNom(trouFormDTO.getNom());
        trouDB.setNumTrou(trouFormDTO.getNumTrou());
        trouDB.setPar(trouFormDTO.getPar());
        trouDB.setParcours(parcoursRepository.findById(trouFormDTO.getParcoursId()).get());

        trouRepository.save(trouDB);
    }


    //    Parcours------------------------------------------------------------------------------------------------------
    public List<Parcours> getParcours() {
        return Lists.newArrayList(parcoursRepository.findAll());
    }

    public Parcours geParcour(Long id) {
        return parcoursRepository.findById(id).orElse(new Parcours());
    }

    public void deleteParcour(Long id) {
        parcoursRepository.deleteById(id);
    }

    public void saveParcour(ParcoursFormDTO parcoursFormDTO) {
        Parcours parcoursDB = parcoursRepository.findById(parcoursFormDTO.getId()).orElse(new Parcours());
        parcoursDB.setNom(parcoursFormDTO.getNom());
        parcoursDB.setGolf(golfRepository.findById(parcoursFormDTO.getGolfId()).get());

        parcoursRepository.save(parcoursDB);
    }


    //   Golf-----------------------------------------------------------------------------------------------------------
    public List<Golf> getGolfs() {
        return Lists.newArrayList(golfRepository.findAll());
    }

    public Golf getGolf(Long id) {
        return golfRepository.findById(id).orElse(new Golf());
    }

    public void deleteGolf(Long id) {
        golfRepository.deleteById(id);
    }

    public List<Golf> getGolfByNom(String nom){return golfRepository.findGolfByNom(nom);}

    public void saveGolf(GolfFormDTO golfFormDTO) {
        Golf golfDB = golfRepository.findById(golfFormDTO.getId()).orElse(new Golf());
        golfDB.setNom(golfFormDTO.getNom());

        golfRepository.save(golfDB);
    }

    //Groupe-------------------------------------------------------------------------------------------------------------
        public List<Groupe> getGroupes(){ return Lists.newArrayList(groupeRepository.findAll());}
        public Groupe getGroupe(Long id){return groupeRepository.findById(id).orElse(new Groupe());}
        public void deleteGroupe(Long id) {
        groupeRepository.deleteById(id);
    }
        public void saveGroupe(GroupeFormDTO groupeFormDTO) {
        Groupe groupeDB = groupeRepository.findById(groupeFormDTO.getId()).orElse(new Groupe());
        groupeDB.setNom(groupeFormDTO.getNom());
        groupeDB.setRole(groupeFormDTO.getRole());

        groupeRepository.save(groupeDB);
    }

    //User-------------------------------------------------------------------------------------------------------------
    public List<User> getusers(){ return Lists.newArrayList(userRepository.findAll());}
    public User getUser(Long id){return userRepository.findById(id).orElse(new User());}
    public void deleteUser(Long id) { userRepository.deleteById(id); }
    public void saveUser(UserFormDTO userFormDTO){
        User userDB = userRepository.findById(userFormDTO.getId()).orElse(new User());
        userDB.setActive(userFormDTO.isActive());
        userDB.setEmail(userFormDTO.getEmail());
        userDB.setLogin(userFormDTO.getLogin());
        userDB.setPassword(userFormDTO.getPassword());

        userRepository.save(userDB);
    }

}
