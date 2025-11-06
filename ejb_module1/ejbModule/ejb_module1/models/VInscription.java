package ejb_module1.models;

public class VInscription {
    private int id;
    private String idEleve;
    private String nom;
    private int redoublement;
    private int idFiliere;
    private String filiereNom;
    private int anneeDebut;
    private int anneeFin;
    private double moyenne;

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getIdEleve() { return idEleve; }
    public void setIdEleve(String idEleve) { this.idEleve = idEleve; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getRedoublement() { return redoublement; }
    public void setRedoublement(int redoublement) { this.redoublement = redoublement; }

    public int getIdFiliere() { return idFiliere; }
    public void setIdFiliere(int idFiliere) { this.idFiliere = idFiliere; }

    public String getFiliereNom() { return filiereNom; }
    public void setFiliereNom(String filiereNom) { this.filiereNom = filiereNom; }

    public int getAnneeDebut() { return anneeDebut; }
    public void setAnneeDebut(int anneeDebut) { this.anneeDebut = anneeDebut; }

    public int getAnneeFin() { return anneeFin; }
    public void setAnneeFin(int anneeFin) { this.anneeFin = anneeFin; }

    public double getMoyenne() { return moyenne; }
    public void setMoyenne(double moyenne) { this.moyenne = moyenne; }
}

