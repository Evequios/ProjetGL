package gl.vetb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StationProcheTests {
    Graphe g;

    @Test
    public void testCalculerStationPlusProche() {
        // Création des stations
        Station s1 = new Station("Station 1", null, false, 0, 1, 2);
        Station s2 = new Station("Station 2", null, false, 0, 4, 6);
        Station s3 = new Station("Station 3", null, false, 0, 3, 1);
        Station s4 = new Station("Station 4", null, false, 0, 7, 3);

        // Création de la liste de stations
        List<Station> stations = new ArrayList<>();
        stations.add(s1);
        stations.add(s2);
        stations.add(s3);
        stations.add(s4);
        List<Itineraire> itineraires = List.of();
        g = new Graphe(stations, itineraires);
        // Position pour le calcul de la station la plus proche
        double positionX = 5;
        double positionY = 2;

        // Appel de la méthode pour calculer la station la plus proche
        Station stationPlusProche = g.calculerStationPlusProche(positionX, positionY);

        // Vérification du résultat
        assertEquals(s3, stationPlusProche);
    }

    @Test
    public void testCalculerStationPlusProche_ListeVide() {
        List<Station> stations = new ArrayList<>(); // Crée une liste vide de stations
        double positionX = 10.0;
        double positionY = 5.0;
        List<Itineraire> itineraires = List.of();
        g = new Graphe(stations, itineraires);

        Station stationPlusProche = g.calculerStationPlusProche(positionX, positionY);
        assertNull(stationPlusProche, "La station la plus proche devrait être null");
    }

    @Test
    public void testCalculerStationPlusProche_ListeUneSeuleStation() {
        Station s1 = new Station("Station 1", null, false, 0, 1, 2);
        List<Station> stations = new ArrayList<>();
        stations.add(s1);
        double positionX = 3;
        double positionY = 4;
        List<Itineraire> itineraires = List.of();
        g = new Graphe(stations, itineraires);


        Station stationPlusProche = g.calculerStationPlusProche(positionX, positionY);

        assertEquals(s1, stationPlusProche);
    }
}