package gl.vetb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphe {
    private List<Station> stations;
    private List<Itineraire> itineraires;
    private Map<String, Map<String, Integer>> graphe; // HashMap avec les distances entre les stations

    public Graphe(List<Station> stations, List<Itineraire> itineraires) {
        this.stations = stations;
        this.itineraires = itineraires;
        graphe = new HashMap<>();

        // Initialisation du graphe avec toutes les stations et leurs relations
        for (Station station : stations) {
            String nom = station.getNom();
            Map<String, Integer> relations = new HashMap<>();
            for (Itineraire itineraire : itineraires) {
                Station depart = itineraire.getDepart();
                Station arrivee = itineraire.getArrivee();
                if (depart.equals(station)) {
                    relations.put(arrivee.getNom(), itineraire.getDuree());
                }
                else if (arrivee.equals(station)) {
                    relations.put(depart.getNom(), itineraire.getDuree());
                }
            }
            graphe.put(nom, relations);
        }
    }

    // Méthode pour ajouter une station au graphe avec ses relations
    public void ajouterStation(Station station, List<Itineraire> itineraires) {
        String nom = station.getNom();
        Map<String, Integer> relations = new HashMap<>();
        for (Itineraire itineraire : itineraires) {
            Station depart = itineraire.getDepart();
            Station arrivee = itineraire.getArrivee();
            if (depart.equals(station)) {
                relations.put(arrivee.getNom(), itineraire.getDuree());
            }
            else if (arrivee.equals(station)) {
                relations.put(depart.getNom(), itineraire.getDuree());
            }
        }
        graphe.put(nom, relations);
    }

    // Méthode pour récupérer les relations d'une station donnée
    public Map<String, Integer> getRelations(String nom) {
        return graphe.get(nom);
    }

    // Getters and setters
    public Map<String, Map<String, Integer>> getGraphe() {
        return graphe;
    }

    public void setGraphe(Map<String, Map<String, Integer>> graphe) {
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
