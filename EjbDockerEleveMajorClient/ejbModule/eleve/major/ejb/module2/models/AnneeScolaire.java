package eleve.major.ejb.module2.models;

import java.io.Serializable;

public class AnneeScolaire implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id; 
	private int anneeDebut; 
	private int anneeFin; 
	
	public int getId() { return id; } 
	public void setId(int id) { this.id = id; } 
	public int getAnneeDebut() { return anneeDebut; } 
	public void setAnneeDebut(int anneeDebut) { this.anneeDebut = anneeDebut; } 
	public int getAnneeFin() { return anneeFin; } 
	public void setAnneeFin(int anneeFin) { this.anneeFin = anneeFin; }
}
