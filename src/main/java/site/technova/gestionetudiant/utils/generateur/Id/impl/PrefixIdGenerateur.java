package site.technova.gestionetudiant.utils.generateur.Id.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import site.technova.gestionetudiant.utils.generateur.Id.IdGenerateur;

@Component
public class PrefixIdGenerateur implements IdGenerateur {

    @Value("${gestionetudiant.generateur.id.prefix}")
    private String prefix;
    private long compter;

    @Override
    public String genererId() {
        return prefix + compter++;
    }

}
