package site.technova.gestionetudiant.dao;

import java.util.List;

import site.technova.gestionetudiant.model.Etudiant;

public interface EtudiantDAO {
    public void persister(Etudiant etudiant);

    public void miseAJour(Etudiant etudiant);

    public List<Etudiant> recupererTous();

    public Etudiant recupererParId(String id);
}
