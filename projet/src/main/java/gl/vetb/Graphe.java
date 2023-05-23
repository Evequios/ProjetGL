package gl.vetb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Graphe {
    private List<Station> stations;
    private List<Itineraire> itineraires;
    private Map<Station, Map<Station, Integer>> graphe; // HashMap avec le temps de trajet entre les stations

    public Graphe(List<Station> stations, List<Itineraire> itineraires) {
        this.stations = stations;
        this.itineraires = itineraires;
        graphe = new HashMap<>();

        // Initialisation du graphe avec toutes les stations et leurs relations
        for (Station station : stations) {
            Map<Station, Integer> relations = new HashMap<>();
            for (Itineraire itineraire : itineraires) {
                Station depart = itineraire.getDepart();
                Station arrivee = itineraire.getArrivee();
                if (depart.equals(station)) {
                    relations.put(arrivee, itineraire.getDuree());
                }
                else if (arrivee.equals(station)) {
                    relations.put(depart, itineraire.getDuree());
                }
            }
            graphe.put(station, relations);
        }
    }

    public Itineraire algoPlusCourtChemin(Station depart, Station arrivee){
        Map<Station, Integer> durees = new HashMap<Station, Integer>();
        List<Itineraire> itineraires = new ArrayList<Itineraire>();
        List<Station> visitees = new ArrayList<Station>();

        for (Station station : stations){
            durees.put(station, Integer.MAX_VALUE);
        }
        durees.put(depart, 0);

        while(!visitees.contains(arrivee)){
            // A changer en Station currentStation = getPlusProcheStation()
            Station stationActuelle = new Station("a", null, false, 0, 0, 0);
            visitees.add(stationActuelle);

            for(Station stationVoisine : getStationsVoisines(stationActuelle)){
                if (!visitees.contains(stationVoisine)){
                    Itineraire chemin = null;
                    for(Itineraire i : getItineraires()){
                        if(i.getDepart() == stationActuelle && i.getArrivee() == stationVoisine){
                            chemin = i;
                            break;
                        }
                    }
                    int duree = durees.get(stationActuelle) + chemin.getDuree() + chemin.getDepart().getTempsArret();
                    if(duree < durees.get(stationVoisine)){
                        durees.put(stationVoisine, duree);
                        itineraires.add(chemin);
                    }
                }
            }
        }

        // Itinéraire le plus court
        Itineraire itinerairePlusCourt = new Itineraire(depart, arrivee, null, 0);
        List<Station> stationsIndermediaires = new ArrayList<Station>();
        Station station = arrivee;
        while(station != depart){
            stationsIndermediaires.add(0,station);
            for(Itineraire i : itineraires){
                if(i.getArrivee() == station){
                    station = i.getDepart();
                }
            }
        }
        
        itinerairePlusCourt.setStationsIntermediaires(stationsIndermediaires);
        return itinerairePlusCourt;
    }

    
    public List<Station> getStationsVoisines(Station station){
        List<Station> stationsVoisines = new ArrayList<Station>();
        for(Entry<Station, Integer> entry : getRelations(station).entrySet()){
            stationsVoisines.add(entry.getKey());
        }

        return stationsVoisines;
    }

    // Méthode pour ajouter une station au graphe avec ses relations
    public void ajouterStation(Station station, List<Itineraire> itineraires) {
        Map<Station, Integer> relations = new HashMap<>();
        for (Itineraire itineraire : itineraires) {
            Station depart = itineraire.getDepart();
            Station arrivee = itineraire.getArrivee();
            if (depart.equals(station)) {
                relations.put(arrivee, itineraire.getDuree());
            }
            else if (arrivee.equals(station)) {
                relations.put(depart, itineraire.getDuree());
            }
        }
        graphe.put(station, relations);
    }

    // Méthode pour récupérer les relations d'une station donnée
    public Map<Station, Integer> getRelations(Station station) {
        return graphe.get(station);
    }

    // Getters and setters
    public Map<Station, Map<Station, Integer>> getGraphe() {
        return graphe;
    }

    public void setGraphe(Map<Station, Map<Station, Integer>> graphe) {
        this.graphe = graphe;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Itineraire> getItineraires() {
        return itineraires;
    }

    public void setItineraires(List<Itineraire> itineraires) {
        this.itineraires = itineraires;
    }
} 
