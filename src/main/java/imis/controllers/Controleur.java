package imis.controllers;

import imis.entities.Entreprise;
import imis.entities.Fonction;
import imis.services.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String createEntreprisePost() {
       
        return "hello";
    }

    @GetMapping("createFonction")
    public String createFonctionGet(){
        return "createFonction";
    }

    @PostMapping("createFonction")
    public String createFonctionPost(){
        return "hello";
    }

    @GetMapping("createContact")
    public String createContactGet(Model model){
        model.addAttribute("entreprises", facade.getAllEntreprise());
        model.addAttribute("fonctions", facade.getAllFonction());
        return "createContact";
    }

    @PostMapping("createContact")
    public String createContactPost(){
        //  ajouter les paramètres de la méthode
        //  créer la méthode dans la facade
        return "hello";
    }

    @GetMapping("plusContact")
    public String plusContact(Model model){
        model.addAttribute("e", facade.getEntreprisePlusCont());
        return "plusContact";
    }

    @GetMapping("parMotCle")
    public String parMotCle(Model model, String mot){
        model.addAttribute("entreprises", facade.getEntrepriseMotCle(mot));
        return "entreprises";
    }
}
