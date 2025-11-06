package ejb_module1.ejb;

import jakarta.ejb.Stateless;
import jakarta.annotation.Resource;
import javax.sql.DataSource;

import ejb_module1.models.VInscription;

import java.sql.*;
import java.util.*;


@Stateless
public class InscriptionService {

    @Resource(lookup = "java:/jdbc/eleveDS")
    private DataSource ds;

    public List<VInscription> getClassementsByAnnee(int anneeDebut) throws SQLException {
        List<VInscription> list = new ArrayList<>();
        String sql = """
            SELECT id, id_eleve, nom, redoublement, id_filiere, filiere_nom, 
                   annee_debut, annee_fin, moyenne
            FROM v_inscriptions
            WHERE annee_debut = ?
            ORDER BY moyenne DESC, redoublement ASC
        """;

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, anneeDebut);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    VInscription v = new VInscription();
                    v.setId(rs.getInt("id"));
                    v.setIdEleve(rs.getString("id_eleve"));
                    v.setNom(rs.getString("nom"));
                    v.setRedoublement(rs.getInt("redoublement"));
                    v.setIdFiliere(rs.getInt("id_filiere"));
                    v.setFiliereNom(rs.getString("filiere_nom"));
                    v.setAnneeDebut(rs.getInt("annee_debut"));
                    v.setAnneeFin(rs.getInt("annee_fin"));
                    v.setMoyenne(rs.getDouble("moyenne"));
                    list.add(v);
                }
            }
        }
        return list;
    }


    public List<VInscription> getMajorDesMajorsByAnnee(int anneeDebut) throws SQLException {
    List<VInscription> majors = new ArrayList<>();
    String sql = """
        WITH ranked_inscriptions AS (
            SELECT id, id_eleve, nom, redoublement, id_filiere, filiere_nom, 
                   annee_debut, annee_fin, moyenne,
                   RANK() OVER (ORDER BY moyenne DESC, redoublement ASC) AS rank
            FROM v_inscriptions
            WHERE annee_debut = ?
        )
        SELECT id, id_eleve, nom, redoublement, id_filiere, filiere_nom, 
               annee_debut, annee_fin, moyenne
        FROM ranked_inscriptions
        WHERE rank = 1
    """;

    try (Connection conn = ds.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, anneeDebut);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                VInscription major = new VInscription();
                major.setId(rs.getInt("id"));
                major.setIdEleve(rs.getString("id_eleve"));
                major.setNom(rs.getString("nom"));
                major.setRedoublement(rs.getInt("redoublement"));
                major.setIdFiliere(rs.getInt("id_filiere"));
                major.setFiliereNom(rs.getString("filiere_nom"));
                major.setAnneeDebut(rs.getInt("annee_debut"));
                major.setAnneeFin(rs.getInt("annee_fin"));
                major.setMoyenne(rs.getDouble("moyenne"));
                majors.add(major);
            }
        }
    }
    return majors;
}


}

