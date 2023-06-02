package gl.vetb;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CreationGraphe {

    public Graphe creationGraphe(){
        List<Station> listStations = new ArrayList<Station>();

        // Création des lignes
        Ligne l1 = new Ligne("Ligne 1", false, null);
        Ligne l2 = new Ligne("Ligne 2", false, null);
        Ligne l3 = new Ligne("Ligne 3", false, null);

        listStations.add(new Station("Pontoise", Arrays.asList(l1), false, 60, 4, 13));
        listStations.add(new Station("Clichy", Arrays.asList(l1, l3), false, 70, 4, 11));
        listStations.add(new Station("Trocadéro", Arrays.asList(l1), false, 65, 6, 8));
        listStations.add(new Station("Orléans", Arrays.asList(l1, l2), false, 85, 8, 7));
        listStations.add(new Station("Bercy", Arrays.asList(l1, l3), false, 75, 12, 5));
        listStations.add(new Station("Vincennes", Arrays.asList(l1), false, 90, 14, 5));
        listStations.add(new Station("Bobigny", Arrays.asList(l2), false, 80, 13, 10));
        listStations.add(new Station("Austerlitz", Arrays.asList(l2, l3), false, 95, 10, 7));
        listStations.add(new Station("Issy", Arrays.asList(l2, l3), false, 50, 6, 3));
        listStations.add(new Station("Antony", Arrays.asList(l2), false, 55, 6, 1));
        listStations.add(new Station("Cergy", Arrays.asList(l3), false, 45, 1, 11));
        listStations.add(new Station("Clignancourt", Arrays.asList(l3), false, 100, 9, 11));
        listStations.add(new Station("Versailles", Arrays.asList(l3), false, 45, 3, 3));

        // Création des chemins entre les stations
        Itineraire iPontoiseClichy = new Itineraire(listStations.get(0), listStations.get(1), null, 90, null);
        
        Itineraire iClichyPontoise = new Itineraire(listStations.get(1), listStations.get(0), null, 90, null);
        Itineraire iClichyTrocadero = new Itineraire(listStations.get(1), listStations.get(2), null, 180, null);
        Itineraire iClichyCergy = new Itineraire(listStations.get(1), listStations.get(10), null, 120, null);
        Itineraire iClichyClignancourt = new Itineraire(listStations.get(1), listStations.get(11), null, 180, null);

        Itineraire iTrocaderoClichy = new Itineraire(listStations.get(2), listStations.get(1), null, 180, null);
        Itineraire iTrocaderoOrleans = new Itineraire(listStations.get(2), listStations.get(3), null, 120, null);
        
        Itineraire iOrleansTrocadero = new Itineraire(listStations.get(3), listStations.get(2), null, 120, null);
        Itineraire iOrleansBercy = new Itineraire(listStations.get(3), listStations.get(4), null, 210, null);
        Itineraire iOrleansAusterlitz = new Itineraire(listStations.get(3), listStations.get(7), null, 90, null);
        Itineraire iOrleansIssy = new Itineraire(listStations.get(3), listStations.get(8), null, 210, null);
        
        Itineraire iBercyOrleans = new Itineraire(listStations.get(4), listStations.get(3), null, 210, null);
        Itineraire iBercyAusterlitz = new Itineraire(listStations.get(4), listStations.get(7), null, 150, null);
        Itineraire iBercyVincennes = new Itineraire(listStations.get(4), listStations.get(5), null, 90, null);
        Itineraire iBercyIssy = new Itineraire(listStations.get(4), listStations.get(8), null, 270, null);

        Itineraire iVincennesBercy = new Itineraire(listStations.get(5), listStations.get(4), null, 90, null);

        Itineraire iBobignyAusterlitz = new Itineraire(listStations.get(6), listStations.get(7), null, 210, null);

        Itineraire iAusterlitzBobigny = new Itineraire(listStations.get(7), listStations.get(6), null, 210, null);
        Itineraire iAusterlitzOrleans = new Itineraire(listStations.get(7), listStations.get(3), null, 90, null);
        Itineraire iAusterlitzBercy = new Itineraire(listStations.get(7), listStations.get(4), null, 150, null);
        Itineraire iAusterlitzClignancourt = new Itineraire(listStations.get(7), listStations.get(11), null, 180, null);

        Itineraire iIssyOrleans = new Itineraire(listStations.get(8), listStations.get(3), null, 210, null);
        Itineraire iIssyBercy = new Itineraire(listStations.get(8), listStations.get(4), null, 210, null);
        Itineraire iIssyAntony = new Itineraire(listStations.get(8), listStations.get(9), null, 90, null);
        Itineraire iIssyVersailles = new Itineraire(listStations.get(8), listStations.get(12), null, 120, null);

        Itineraire iAntonyIssy = new Itineraire(listStations.get(9), listStations.get(8), null, 90, null);

        Itineraire iCergyClichy = new Itineraire(listStations.get(10), listStations.get(1), null, 120, null);
        
        Itineraire iClignancourtClichy = new Itineraire(listStations.get(11), listStations.get(1), null, 180, null);
        Itineraire iClignancourtAusterlitz = new Itineraire(listStations.get(11), listStations.get(7), null, 180, null);

        Itineraire iVersaillesIssy = new Itineraire(listStations.get(12), listStations.get(8), null, 120, null);

        // Liste des itinéraires entre les stations
        List<Itineraire> listItineraires = new ArrayList<>(Arrays.asList(iPontoiseClichy, iClichyPontoise, iClichyTrocadero, iClichyCergy, iClichyClignancourt,
            iTrocaderoClichy, iTrocaderoOrleans,  iOrleansTrocadero,iOrleansBercy, iOrleansAusterlitz, iOrleansIssy, iBercyOrleans, iBercyAusterlitz, iBercyVincennes, iBercyIssy,
            iVincennesBercy, iBobignyAusterlitz, iAusterlitzBobigny, iAusterlitzOrleans, iAusterlitzBercy, iAusterlitzClignancourt, iIssyOrleans, iIssyBercy,
            iIssyAntony, iIssyVersailles, iAntonyIssy, iCergyClichy, iClignancourtClichy, iClignancourtAusterlitz, iVersaillesIssy
        ));

        //Creation du Graphe
        Graphe metro = new Graphe(listStations, listItineraires);
        return metro;
    }

}
