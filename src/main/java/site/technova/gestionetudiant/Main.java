package site.technova.gestionetudiant;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        configurerGestionEtudiant();
    }

    private static void configurerGestionEtudiant() {
        SpringApplication.run(Main.class);
        ApplicationContext app = new AnnotationConfigApplicationContext(
                site.technova.gestionetudiant.configuration.AppConfig.class);
        // EtudiantService etudiantService = app.getBean("etudiantService",
        // EtudiantService.class);

        // INSERTION
        // Etudiant etudiant = new Etudiant("Mohamed-Amine", "Benali");
        // etudiantService.ajouter(etudiant);

        // MISE À JOUR
        // Etudiant e = new Etudiant("BENALI", "MedAmine");
        // e.setId("0");
        // etudiantService.miseAJour(e);

        // RECUPERER TOUTES LES ETUDIANTS
        // List<Etudiant> etudiants = etudiantService.recupererTous();
        // for (int i = 0; i < etudiants.size(); i++) {
        // System.out.println(etudiants.get(i));
        // }

        // RECUPERATION PAR IDENTIFIANT
        // Etudiant etudiantTrouver = etudiantService.recupererParId("00");
        // if (etudiantTrouver != null) {
        // System.out.println(etudiantTrouver);
        // }
    }
}
