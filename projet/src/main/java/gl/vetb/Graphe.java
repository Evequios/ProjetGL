package gl.vetb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphe {
    private Map<String, Map<String, Integer>> graphe; // HashMap avec les distances entre les stations

    public Graphe(List<Station> stations, List<Itineraire> itineraires) {
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
} 
