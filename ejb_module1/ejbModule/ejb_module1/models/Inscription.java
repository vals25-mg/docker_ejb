package ejb_module1.models;

public class Inscription {
    private int id;
    private int idAnneeScolaire;
    private int idFiliere;
    private String idEleve;
    private double moyenne;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdAnneeScolaire() { return idAnneeScolaire; }
    public void setIdAnneeScolaire(int idAnneeScolaire) { this.idAnneeScolaire = idAnneeScolaire; }

    public int getIdFiliere() { return idFiliere; }
    public void setIdFiliere(int idFiliere) { this.idFiliere = idFiliere; }

    public String getIdEleve() { return idEleve; }
    public void setIdEleve(String idEleve) { this.idEleve = idEleve; }

    public double getMoyenne() { return moyenne; }
    public void setMoyenne(double moyenne) { this.moyenne = moyenne; }
}
