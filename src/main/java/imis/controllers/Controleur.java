package imis.controllers;

import imis.entities.Entreprise;
import imis.entities.Fonction;
import imis.services.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class Controleur {
    @Autowired
    Facade facade;

    @RequestMapping("")
    public String root(){
        return "hello";
    }

    @GetMapping("createEntreprise")
    public String createEntrepriseGet(){
        return "createEntreprise";
    }

    @PostMapping("createEntreprise")
    public String createEntreprisePost(String nom, String siret, String adresse) {
        facade.nouveauEnt(nom, siret, adresse);
        return "hello";
    }

    @GetMapping("createFonction")
    public String createFonctionGet(){
        return "createFonction";
    }

    @PostMapping("createFonction")
    public String createFonctionPost(String intitule){
        facade.nouvelleFonction(intitule);
        return "hello";
    }

    @GetMapping("createContact")
    public String createContactGet(Model model){
        model.addAttribute("entreprises", facade.getAllEntreprise());
        model.addAttribute("fonctions", facade.getAllFonction());
        return "createContact";
    }

    @PostMapping("createContact")
    public String createContactPost(String nom, String prenom, String email, String telephone, Entreprise entreprise, Fonction fonction){
        facade.nouveauxContact(nom, prenom, email, telephone, entreprise, fonction);
        return "hello";
    }

    @GetMapping("plusContact")
    public String plusContact(Model model){
        model.addAttribute("entreprise", facade.getEntreprisePlusCont());
        return "plusContact";
    }

    @GetMapping("motcle")
    public String motcle(Model model, @RequestParam String motcle){
        model.addAttribute("entreprises", facade.getEntrepriseMotCle(motcle));
        return "entreprises";
    }
}
