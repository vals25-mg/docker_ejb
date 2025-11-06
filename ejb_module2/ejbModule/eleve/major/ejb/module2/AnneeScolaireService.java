package eleve.major.ejb.module2;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import eleve.major.ejb.module2.models.AnneeScolaire;
import jakarta.ejb.Stateful;

@Stateful
public class AnneeScolaireService implements AnneeScolaireServiceRemote {

	private List<AnneeScolaire> annees = new ArrayList<>();
	
	@Override
	public void lireCsv(String cheminCsv) throws Exception {
		 try (CSVReader reader = new CSVReader(new FileReader(cheminCsv))) {
	            String[] ligne;
	            reader.readNext(); // ignorer l'entête
	            while ((ligne = reader.readNext()) != null) {
	                AnneeScolaire a = new AnneeScolaire();
	                a.setId(Integer.parseInt(ligne[0]));
	                a.setAnneeDebut(Integer.parseInt(ligne[1]));
	                a.setAnneeFin(Integer.parseInt(ligne[2]));
	                annees.add(a);
	            }
	        }
	}

	@Override
	public List<AnneeScolaire> getAnnees() {
		return annees;
	}

}
