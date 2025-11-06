package ejb_module1.models;

public class Eleve {
    private String id;
    private String nom;
    private int redoublement;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getRedoublement() { return redoublement; }
    public void setRedoublement(int redoublement) { this.redoublement = redoublement; }
}

