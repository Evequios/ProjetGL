package gl.vetb;

import java.util.List;
import java.util.Map;

public class Itineraire {
    private Station depart;
    private Station arrivee;
    private List<Station> stationsIntermediaires;
    private int duree;
    // Ce Map permettra de stocker les horaires de passage des rames pour chaque ligne de métro. 
    // La clé du Map est un objet de type Ligne représentant une ligne de métro, 
    // et la valeur associée est une liste d'objets Horaire représentant les horaires de passage.
    private Map<Ligne, List<Horaire>> horaires;
    
    public Itineraire(Station depart, Station arrivee, List<Station> stationsIntermediaires, int duree, Map<Ligne, List<Horaire>> horaires) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.stationsIntermediaires = stationsIntermediaires;
        this.duree = duree;
        this.horaires = horaires;
    }

    public Itineraire(Station depart, Station arrivee){
        this.depart = depart;
        this.arrivee = arrivee;
        this.stationsIntermediaires = List.of();
        this.duree = 0;
    }

    public Station getDepart() {
        return depart;
    }

    public void setDepart(Station depart) {
        this.depart = depart;
    }

    public Station getArrivee() {
        return arrivee;
    }

    public void setArrivee(Station arrivee) {
        this.arrivee = arrivee;
    }

    public List<Station> getStationsIntermediaires() {
        return stationsIntermediaires;
    }

    public void setStationsIntermediaires(List<Station> stationsIntermediaires) {
        this.stationsIntermediaires = stationsIntermediaires;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Boolean verifItineraire(Station depart, Station arrivee){
        return (this.depart == depart && this.arrivee == arrivee);
    }

    public int calculDureeItineraireSimple (){
        return getDepart().getTempsArret() + getDuree();
    }
    
    public Map<Ligne, List<Horaire>> getHoraires() {
        return horaires;
    }

    public void setHoraires(Map<Ligne, List<Horaire>> horaires) {
        this.horaires = horaires;
    }
}