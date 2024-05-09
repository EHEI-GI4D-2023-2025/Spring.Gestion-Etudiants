package site.technova.gestionetudiant.Controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import site.technova.gestionetudiant.exceptions.EtudiantIntrouvableException;
import site.technova.gestionetudiant.model.Etudiant;
import site.technova.gestionetudiant.service.EtudiantService;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    // Get by nom, get by id,

    @GetMapping
    public List<Etudiant> trouverTous() {
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, null, ex);
        }
        return etudiant;
    }

}
