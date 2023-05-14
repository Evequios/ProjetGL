package gl.vetb;

public class Station {
    private String nom;
    private boolean incident;
    private int tempsArret;
    private int abscisse;
    private int ordonnee;

    public Station(String nom, boolean incident, int tempsArret, int abscisse, int ordonnee) {
        this.nom = nom;
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

}
