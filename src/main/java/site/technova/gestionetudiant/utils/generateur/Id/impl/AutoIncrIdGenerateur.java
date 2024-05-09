package site.technova.gestionetudiant.utils.generateur.Id.impl;

import org.springframework.stereotype.Component;

import site.technova.gestionetudiant.utils.generateur.Id.IdGenerateur;

@Component
public class AutoIncrIdGenerateur implements IdGenerateur {
    private long compter;

    @Override
    public String genererId() {
        // TODO Auto-generated method stub
        return Long.toString(compter++);
    }

}
