package ejb_module1.models;

public class AnneeScolaire {
    private int id;
    private int anneeDebut;
    private int anneeFin;

    // Getters / Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAnneeDebut() { return anneeDebut; }
    public void setAnneeDebut(int anneeDebut) { this.anneeDebut = anneeDebut; }

    public int getAnneeFin() { return anneeFin; }
    public void setAnneeFin(int anneeFin) { this.anneeFin = anneeFin; }
}

