package eleve.major.ejb.module2;

import java.util.List;

import eleve.major.ejb.module2.models.AnneeScolaire;
import jakarta.ejb.Remote;

@Remote
public interface AnneeScolaireServiceRemote {
	void lireCsv(String cheminCsv) throws Exception;
    List<AnneeScolaire> getAnnees();
}
