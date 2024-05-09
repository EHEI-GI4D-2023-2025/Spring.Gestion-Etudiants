package site.technova.gestionetudiant.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import site.technova.gestionetudiant.dao.EtudiantDAO;
import site.technova.gestionetudiant.mapper.row.EtudiantRowMapper;
import site.technova.gestionetudiant.model.Etudiant;

@Repository
public class MySQLEtudiantDAO implements EtudiantDAO {

    // @Value("${jdbc.url.datasource}")
    // DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public MySQLEtudiantDAO() {
    }

    @Override
    public void persister(Etudiant etudiant) {
        String sql = "INSERT INTO etudiant values (?, ?, ?)";
        this.jdbcTemplate.update(sql, etudiant.getId(), etudiant.getPrenom(), etudiant.getNom());
    }

    @Override
    public List<Etudiant> recupererTous() {
        String sql = "SELECT * FROM etudiant";
        return this.jdbcTemplate.query(sql, new EtudiantRowMapper());
    }

    @Override
    public void miseAJour(Etudiant etudiant) {
        String sql = "UPDATE etudiant SET prenom=?, nom=? WHERE id=?";
        this.jdbcTemplate.update(sql, etudiant.getPrenom(), etudiant.getNom(), etudiant.getId());
    }

    @Override
    public Etudiant recupererParId(String id) {
        try {
            String sql = "SELECT * FROM etudiant WHERE id=?";
            return this.jdbcTemplate.queryForObject(sql, new EtudiantRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            // TODO: handle exception
            return null;
        }
    }

}
