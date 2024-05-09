package site.technova.gestionetudiant.utils.generateur.Id.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import site.technova.gestionetudiant.utils.generateur.Id.IdGenerateur;

@Component
public class TimestampIdGenerateur implements IdGenerateur {

    @Override
    public String genererId() {
        Date date = new Date();
        long milliSecondes = date.getTime();
        return Long.toString(milliSecondes);
    }

}
