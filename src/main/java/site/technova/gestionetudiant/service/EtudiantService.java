package site.technova.gestionetudiant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import site.technova.gestionetudiant.dao.EtudiantDAO;
import site.technova.gestionetudiant.model.Etudiant;
import site.technova.gestionetudiant.utils.generateur.Id.IdGenerateur;

@Service
public class EtudiantService {

    @Autowired
    // @Qualifier("memoireEtudiantDAO")
    @Qualifier("mySQLEtudiantDAO")
    private EtudiantDAO etudiantDAO;

    @Autowired
    @Qualifier("autoIncrIdGenerateur")
    // @Qualifier("prefixIdGenerateur")
    // @Qualifier("timestampIdGenerateur")
    private IdGenerateur idGenerateur;

    public void ajouter(Etudiant etudiant) {
        etudiant.setId(idGenerateur.genererId());
        if (etudiant.getNom() == null || etudiant.getNom().isEmpty()) {
            System.out.println("Vous devez remplir le nom!");
            return;
        }
        if (etudiant.getPrenom() == null || etudiant.getPrenom().isEmpty()) {
            System.out.println("Vous devez remplir le prenom!");
            return;
        }
        etudiantDAO.persister(etudiant);
    }

    public void miseAJour(Etudiant etudiant) {
        if (etudiant.getNom() == null || etudiant.getNom().isEmpty()) {
            System.out.println("Vous devez remplir le nom!");
            return;
        }
        if (etudiant.getPrenom() == null || etudiant.getPrenom().isEmpty()) {
            System.out.println("Vous devez remplir le prenom!");
            return;
        }
        etudiantDAO.miseAJour(etudiant);
    }

    public List<Etudiant> recupererTous() {
        return etudiantDAO.recupererTous();
    }

    public Etudiant recupererParId(String id) {
        Etudiant e = etudiantDAO.recupererParId(id);
        if (e == null) {
            System.out.println("L'utilisateur avec l'identifiant \"" + id + "\" n'existe pas!");
            return null;
        }
        return e;
    }
}
