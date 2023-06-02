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

    // Méthodes d'initialisation du Graphe
    public Graphe(List<Station> stations, List<Itineraire> itineraires) {
        this.stations = stations;
        this.itineraires = itineraires;
        graphe = new HashMap<>();

        // Initialisation du graphe avec toutes les stations et leurs relations
        for (Station station : stations) {
            Map<Station, Integer> relations = new HashMap<>();
            for (Itineraire itineraire : itineraires) {
                ajoutRelation(station, relations, itineraire);
            }
            graphe.put(station, relations);
        }
    }

    private void ajoutRelation(Station station, Map<Station, Integer> relations, Itineraire itineraire) {
        Station depart = itineraire.getDepart();
        Station arrivee = itineraire.getArrivee();
        if (depart.equals(station)) {
            relations.put(arrivee, itineraire.getDuree());
        }
        else if (arrivee.equals(station)) {
            relations.put(depart, itineraire.getDuree());
        }
    }


    public Itineraire algoPlusCourtChemin(Station depart, Station arrivee) {
        Map<Station, Integer> durees = new HashMap<>();
        List<Itineraire> itineraires = new ArrayList<>();
        List<Station> visitees = new ArrayList<>();
    
        for (Station station : stations) {
            durees.put(station, Integer.MAX_VALUE);
        }
        durees.put(depart, 0);
    
        Station stationActuelle = depart;
        boolean fin = false;
        while (!fin) {
            visitees.add(stationActuelle);
    
            getItinerairesStationsVoisines(durees, itineraires, visitees, stationActuelle);
    
            Station prochaineStation = null;
            int dureeMin = Integer.MAX_VALUE;
            for (Itineraire itineraire : itineraires) {
                Station station = itineraire.getArrivee();
                int duree = itineraire.getDuree();
                if (!visitees.contains(station) && duree < dureeMin) {
                    prochaineStation = station;
                    dureeMin = duree;
                }
            }
            if (prochaineStation == null) {
                break; // Aucune station accessible non visitée
            }
            stationActuelle = prochaineStation;
            fin = visitees.contains(arrivee);
        }
    
        // Itinéraire le plus court
        Itineraire itinerairePlusCourt = new Itineraire(depart, arrivee);
        List<Station> stationsIntermediaires = new ArrayList<>();
        Station station = arrivee;
        int duree = 0;
        while (station != depart) {
            if(station != arrivee){
                stationsIntermediaires.add(0, station);
            }
            for (Itineraire i : itineraires) {
                if (i.getArrivee() == station) {
                    station = i.getDepart();
                    duree += i.getDuree();
                    break;
                }
            }
        }
    
        itinerairePlusCourt.setStationsIntermediaires(stationsIntermediaires);
        itinerairePlusCourt.setDuree(duree);
        return itinerairePlusCourt;
    }

    private void getItinerairesStationsVoisines(Map<Station, Integer> durees, List<Itineraire> itineraires, List<Station> visitees, Station stationActuelle) {
        for (Station stationVoisine : getStationsVoisines(stationActuelle)) {
            if (!visitees.contains(stationVoisine)) {
                Itineraire chemin = null;
                for (Itineraire i : getItineraires()) {
                    if (i.verifItineraire(stationActuelle, stationVoisine)) {
                        chemin = i;
                        break;
                    }
                }
                int duree = durees.get(stationActuelle) + chemin.getDuree();
                if (duree < durees.get(stationVoisine)) {
                    durees.put(stationVoisine, duree);
                    itineraires.add(chemin);
                }
            }
        }
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
            ajoutRelation(station, relations, itineraire);
        }
        graphe.put(station, relations);
    }

    public Station calculerStationPlusProche(double positionAbs, double positionOrd) {
        Station stationPlusProche = null;
        double distanceMin = Double.MAX_VALUE;
    
        for (Station station : stations) {
            double distance = Math.abs(station.getAbscisse() - positionAbs) + Math.abs(station.getOrdonnee() - positionOrd);
    
            if (distance < distanceMin) {
                distanceMin = distance;
                stationPlusProche = station;
            }
        }
    
        return stationPlusProche;
    }

    public Itineraire calculerItineraireMoinsChangementLignes(Station depart, Station arrivee) {
        List<Itineraire> itinerairesPossibles = new ArrayList<>();
    
        // Recherche de tous les itinéraires possibles entre les stations de départ et d'arrivée
        for (Itineraire itineraire : itineraires) {
            if (itineraire.getDepart().equals(depart) && itineraire.getArrivee().equals(arrivee)) {
                itinerairesPossibles.add(itineraire);
            }
        }
    
        // Vérification des itinéraires avec le moins de changement de lignes
        Itineraire itineraireMoinsChangementLignes = null;
        int minChangementsLignes = Integer.MAX_VALUE;
    
        for (Itineraire itineraire : itinerairesPossibles) {
            List<Station> stationsIntermediaires = itineraire.getStationsIntermediaires();
            int changementsLignes = calculerNombreChangementsLignes(stationsIntermediaires);
    
            if (changementsLignes < minChangementsLignes) {
                minChangementsLignes = changementsLignes;
                itineraireMoinsChangementLignes = itineraire;
            }
        }
    
        return itineraireMoinsChangementLignes;
    }
    
    private int calculerNombreChangementsLignes(List<Station> stations) {
        int changementsLignes = 0;
        String ligneCourante = null;
    
        for (Station station : stations) {
            String ligneStation = ((Station) station.getLigne()).getNom();
    
            if (ligneCourante != null && !ligneCourante.equals(ligneStation)) {
                changementsLignes++;
            }
    
            ligneCourante = ligneStation;
        }
    
        return changementsLignes;
    }

    public Itineraire algoItineraireAvecPassages(Station depart, Station arrivee, List<Station> stationsPassage) {
        
        Itineraire itineraireAvecPassage = null;

        // Vérification si les stations de départ, d'arrivée et les stations de passage sont présentes dans le graphe
        if (!stations.contains(depart) || !stations.contains(arrivee) || !stations.containsAll(stationsPassage)) {
            // L'une des stations spécifiées n'existe pas dans le graphe, retourner une liste vide
            return null;
        }
        
        // Calcul des itinéraires en passant par chaque station de passage
        for (Station stationPassage : stationsPassage) {
            // Vérification si la station de passage est différente de la station de départ et d'arrivée
            if (!stationPassage.equals(depart) && !stationPassage.equals(arrivee)) {
                // Calcul de l'itinéraire de départ à station de passage
                Itineraire itineraireDepartPassage = algoPlusCourtChemin(depart, stationPassage);
                
                // Calcul de l'itinéraire de station de passage à arrivée
                Itineraire itinerairePassageArrivee = algoPlusCourtChemin(stationPassage, arrivee);
                
                // Vérification si les deux itinéraires existent
                if (itineraireDepartPassage != null && itinerairePassageArrivee != null) {
                    // Création d'un nouvel itinéraire en combinant les deux itinéraires
                    itineraireAvecPassage = new Itineraire(depart, arrivee, null,
                        itineraireDepartPassage.getDuree() + itinerairePassageArrivee.getDuree());
                    
                    // Ajout des stations intermédiaires en excluant la première station de l'itinéraire de passage
                    List<Station> stationsIntermediaires = new ArrayList<>(itineraireDepartPassage.getStationsIntermediaires());
                    stationsIntermediaires.remove(stationsIntermediaires.size() - 1);
                    stationsIntermediaires.addAll(itinerairePassageArrivee.getStationsIntermediaires());
                    itineraireAvecPassage.setStationsIntermediaires(stationsIntermediaires);
                }
            }
        }
        
        return itineraireAvecPassage;
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