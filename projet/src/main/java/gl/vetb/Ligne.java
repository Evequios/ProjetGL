package gl.vetb;

public class Ligne {
    private String nom;
    private boolean incident;

    public Ligne(String nom, boolean incident) {
        this.nom = nom;
        this.incident = incident;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getIncident() {
        return incident;
    }

    public void setIncident(boolean incident) {
        this.incident = incident;
    }
}
