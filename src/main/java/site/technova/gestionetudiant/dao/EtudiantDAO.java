package site.technova.gestionetudiant.dao;

import java.util.List;

import site.technova.gestionetudiant.model.Etudiant;

public interface EtudiantDAO {
    public void persister(Etudiant etudiant);

    public void miseAJour(Etudiant etudiant);

    public List<Etudiant> recupererTous();

    public Etudiant recupererParId(String id);

    public List<Etudiant> recupererParNom(String nom);

    public List<Etudiant> recupererParPrenom(String prenom);

    public List<Etudiant> recupererParNomEtPrenom(String nom, String prenom);
}
