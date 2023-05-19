package gl.vetb;

import java.util.List;

public class Station {
    private String nom;
    private List<Ligne> ligne;
    private boolean incident;
    private int tempsArret;
    private int abscisse;
    private int ordonnee;

    public Station(String nom, List<Ligne> ligne, boolean incident, int tempsArret, int abscisse, int ordonnee) {
        this.nom = nom;
        this.ligne = ligne;
        this.incident = incident;
        this.tempsArret = tempsArret;
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
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

    public int getTempsArret() {
        return tempsArret;
    }

    public void setTempsArret(int tempsArret) {
        this.tempsArret = tempsArret;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    public List<Ligne> getLigne() {
        return ligne;
    }

    public void setLigne(List<Ligne> ligne) {
        this.ligne = ligne;
    }
}
