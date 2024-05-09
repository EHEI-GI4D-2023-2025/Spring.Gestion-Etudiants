package site.technova.gestionetudiant.mapper.row;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import site.technova.gestionetudiant.model.Etudiant;

public class EtudiantRowMapper implements RowMapper<Etudiant> {

    @Override
    public Etudiant mapRow(ResultSet rs, int ligne) throws SQLException {
        Etudiant etudiant = new Etudiant(
                rs.getString("nom"),
                rs.getString("prenom"));
        etudiant.setId(rs.getString("id"));
        return etudiant;
    }

}