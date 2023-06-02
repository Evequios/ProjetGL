package gl.vetb;

import java.util.List;

public class Ligne {
    private String nom;
    private boolean incident;
    // Cet attribut permettra de stocker les horaires de passage des rames pour une ligne spécifique.
    private List<Horaire> horaires;

    public Ligne(String nom, boolean incident, List<Horaire> horaires) {
        this.nom = nom;
        this.incident = incident;
        this.horaires = horaires;
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

    public List<Horaire> getHoraires() {
        return horaires;
    }

    public void setHoraires(List<Horaire> horaires) {
        this.horaires = horaires;
    }
}
