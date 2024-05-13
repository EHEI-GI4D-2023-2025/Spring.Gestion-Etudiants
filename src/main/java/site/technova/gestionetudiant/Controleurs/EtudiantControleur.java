package site.technova.gestionetudiant.Controleurs;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import site.technova.gestionetudiant.exceptions.EtudiantIntrouvableException;
import site.technova.gestionetudiant.model.Etudiant;
import site.technova.gestionetudiant.service.EtudiantService;

@RestController
@RequestMapping("/etudiants")
public class EtudiantControleur {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> trouverTous(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String prenom) {
        if (nom != null && prenom != null) {
            return etudiantService.recupererParNomPrenom(nom, prenom);
        }
        if (nom != null) {
            return etudiantService.recupererParNom(nom);
        }
        if (prenom != null) {
            return etudiantService.recupererParPrenom(prenom);
        }
        return etudiantService.recupererTous();
    }

    @GetMapping("{id}")
    public Etudiant trouver(
            @PathVariable String id,
            HttpServletResponse reponse) throws EtudiantIntrouvableException {
        Etudiant etudiant = etudiantService.recupererParId(id);
        try {
            if (etudiant == null) {
                throw new EtudiantIntrouvableException();
            }
        } catch (EtudiantIntrouvableException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, ex);
        }
        return etudiant;
    }
}
