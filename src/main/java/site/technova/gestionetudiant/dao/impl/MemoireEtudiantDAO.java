package site.technova.gestionetudiant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import site.technova.gestionetudiant.dao.EtudiantDAO;
import site.technova.gestionetudiant.model.Etudiant;

@Repository
public class MemoireEtudiantDAO implements EtudiantDAO {
    private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

    @Override
    public void persister(Etudiant etudiant) {
        etudiants.add(etudiant);
        System.out.println("Affichage de la liste des etudiants: ");
        System.out.println(etudiants);
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    @Override
    public ArrayList<Etudiant> recupererTous() {
        return etudiants;
    }

    @Override
    public void miseAJour(Etudiant etudiant) {
        for (int i = 0; i < etudiants.size(); i++) {
            if (etudiants.get(i).getId() == etudiant.getId()) {
                Etudiant ancienEtudiant = etudiants.get(i);
                ancienEtudiant.setNom(etudiant.getNom());
                ancienEtudiant.setPrenom(etudiant.getPrenom());
            }
        }
    }

    @Override
    public Etudiant recupererParId(String id) {
        for (int i = 0; i < etudiants.size(); i++) {
            if (etudiants.get(i).getId() == id) {
                return etudiants.get(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<Etudiant> recupererParNom(String nom) {
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        for (int i = 0; i < etudiants.size(); i++) {
            if (etudiants.get(i).getNom() == nom) {
                etudiants.add(etudiants.get(i));
            }
        }
        return etudiants;
    }

    @Override
    public List<Etudiant> recupererParPrenom(String prenom) {
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        for (int i = 0; i < etudiants.size(); i++) {
            if (etudiants.get(i).getNom() == prenom) {
                etudiants.add(etudiants.get(i));
            }
        }
        return etudiants;
    }

    @Override
    public List<Etudiant> recupererParNomEtPrenom(String nom, String prenom) {
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        for (int i = 0; i < etudiants.size(); i++) {
            if (etudiants.get(i).getNom() == prenom && etudiants.get(i).getPrenom() == prenom) {
                etudiants.add(etudiants.get(i));
            }
        }
        return etudiants;
    }
}
