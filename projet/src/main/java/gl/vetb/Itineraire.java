package gl.vetb;

import java.util.List;

public class Itineraire {
    private Station depart;
    private Station arrivee;
    private List<Station> stationsIntermediaires;
    private int duree;

    public Itineraire(Station depart, Station arrivee, List<Station> stationsIntermediaires, int duree) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.stationsIntermediaires = stationsIntermediaires;
        this.duree = duree;
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
}