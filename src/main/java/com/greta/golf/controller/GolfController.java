package com.greta.golf.controller;

import com.greta.golf.formdata.GolfFormDTO;
import com.greta.golf.formdata.ParcoursFormDTO;
import com.greta.golf.models.Golf;
import com.greta.golf.models.Parcours;
import com.greta.golf.service.GolfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class GolfController {
    private GolfService golfService;

    @Autowired
    public GolfController(GolfService golfService) {
        this.golfService = golfService;
    }

    @GetMapping("/")
    public String index() {
        return "accueil";
    }

    //Golf--------------------------------------------------------------------------------------------------------------
    @GetMapping("/golf")
    public String golf(Model model) {
        model.addAttribute("golf", golfService.getGolfs());
        return "golfslist";
    }

    @GetMapping("/golf/{id}")
    public String golf(Model model, @PathVariable(name = "id") Long id) {
        Golf golf = golfService.getGolf(id);
        GolfFormDTO golfFormDTO = new GolfFormDTO();
        golfFormDTO.setId(golf.getId());
        golfFormDTO.setNom(golf.getNom());
        model.addAttribute("golfs", golfFormDTO);
        return "golfform";
    }

    @GetMapping("/golf/add")
    public String addGolf(Model model) {
        model.addAttribute("golfs", new GolfFormDTO());
        return "golfform";

    }

    @GetMapping("/golf/delete/{id}")
    public String deleteGolf(@PathVariable(name = "id") long id) {
        golfService.deleteGolf(id);
        return "redirect:/golf";
    }

    @PostMapping("/golf")
    public String postGolf(@ModelAttribute(name = "golf") GolfFormDTO golfFormDTO) {
        golfService.saveGolf(golfFormDTO);
        return "redirect:/golf";
    }


    //Parcour-----------------------------------------------------------------------------------------------------------
    //TODO
    @GetMapping("/parcour")
    public String parcour(Model model) {
        model.addAttribute("parcour", golfService.getParcours());
        return "parcourslist";
    }

    @GetMapping("/parcour/{id}")
    public String parcour(Model model, @PathVariable(name = "id") Long id) {
        Parcours parcours = golfService.geParcour(id);
        ParcoursFormDTO parcoursFormDTO = new ParcoursFormDTO();
        parcoursFormDTO.setId(parcours.getId());
        parcoursFormDTO.setNom(parcours.getNom());
        parcoursFormDTO.setGolfId(parcours.getGolf().getId());
        model.addAttribute("parcours",parcoursFormDTO);
        return "parcourform";
    }

    @GetMapping("/parcour/add")
    public String addParcour(Model model) {
        model.addAttribute("parcours", new ParcoursFormDTO());
        return "parcourform";

    }

    @GetMapping("/parcour/delete/{id}")
    public String deleteParcour(@PathVariable(name = "id") long id) {
        golfService.deleteParcour(id);
        return "redirect:/parcour";
    }

    @PostMapping("/parcour")
    public String postParcour(@ModelAttribute(name = "parcour") ParcoursFormDTO parcoursFormDTO) {
        golfService.saveParcour(parcoursFormDTO);
        return "redirect:/parcour";
    }


    //Trou--------------------------------------------------------------------------------------------------------------
    //TODO
    @GetMapping("/trou")
    public String indexTrou(Model model) {
        model.addAttribute("trou", golfService.getTrous());
        return "trouslist";
    }

    //Groupe------------------------------------------------------------------------------------------------------------
    @GetMapping("/admin/groupe")
    public String indexGroupe(Model model){
        model.addAttribute("groupes", golfService.getGroupes());
        return "listgroupe";
    }
}
