package gl.vetb;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CreationGraphe {

    public Graphe creationGraphe(){
        List<Station> listStations = new ArrayList<Station>();

        // Création des lignes
        Ligne l1 = new Ligne("Ligne 1", false);
        Ligne l2 = new Ligne("Ligne 2", false);
        Ligne l3 = new Ligne("Ligne 3", false);

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
        Itineraire iPontoiseClichy = new Itineraire(listStations.get(0), listStations.get(1), null, 90);
        
        Itineraire iClichyPontoise = new Itineraire(listStations.get(1), listStations.get(0), null, 90);
        Itineraire iClichyTrocadero = new Itineraire(listStations.get(1), listStations.get(2), null, 180);
        Itineraire iClichyCergy = new Itineraire(listStations.get(1), listStations.get(10), null, 120);
        Itineraire iClichyClignancourt = new Itineraire(listStations.get(1), listStations.get(11), null, 180);

        Itineraire iTrocaderoClichy = new Itineraire(listStations.get(2), listStations.get(1), null, 180);
        Itineraire iTrocaderoOrleans = new Itineraire(listStations.get(2), listStations.get(3), null, 120);
        
        Itineraire iOrleansTrocadero = new Itineraire(listStations.get(3), listStations.get(2), null, 120);
        Itineraire iOrleansBercy = new Itineraire(listStations.get(3), listStations.get(4), null, 210);
        Itineraire iOrleansAusterlitz = new Itineraire(listStations.get(3), listStations.get(7), null, 90);
        Itineraire iOrleansIssy = new Itineraire(listStations.get(3), listStations.get(8), null, 210);
        
        Itineraire iBercyOrleans = new Itineraire(listStations.get(4), listStations.get(3), null, 210);
        Itineraire iBercyAusterlitz = new Itineraire(listStations.get(4), listStations.get(7), null, 150);
        Itineraire iBercyVincennes = new Itineraire(listStations.get(4), listStations.get(5), null, 90);
        Itineraire iBercyIssy = new Itineraire(listStations.get(4), listStations.get(8), null, 270);

        Itineraire iVincennesBercy = new Itineraire(listStations.get(5), listStations.get(4), null, 90);

        Itineraire iBobignyAusterlitz = new Itineraire(listStations.get(6), listStations.get(7), null, 210);

        Itineraire iAusterlitzBobigny = new Itineraire(listStations.get(7), listStations.get(6), null, 210);
        Itineraire iAusterlitzOrleans = new Itineraire(listStations.get(7), listStations.get(3), null, 90);
        Itineraire iAusterlitzBercy = new Itineraire(listStations.get(7), listStations.get(4), null, 150);
        Itineraire iAusterlitzClignancourt = new Itineraire(listStations.get(7), listStations.get(11), null, 180);

        Itineraire iIssyOrleans = new Itineraire(listStations.get(8), listStations.get(3), null, 210);
        Itineraire iIssyBercy = new Itineraire(listStations.get(8), listStations.get(4), null, 210);
        Itineraire iIssyAntony = new Itineraire(listStations.get(8), listStations.get(9), null, 90);
        Itineraire iIssyVersailles = new Itineraire(listStations.get(8), listStations.get(12), null, 120);

        Itineraire iAntonyIssy = new Itineraire(listStations.get(9), listStations.get(8), null, 90);

        Itineraire iCergyClichy = new Itineraire(listStations.get(10), listStations.get(1), null, 120);
        
        Itineraire iClignancourtClichy = new Itineraire(listStations.get(11), listStations.get(1), null, 180);
        Itineraire iClignancourtAusterlitz = new Itineraire(listStations.get(11), listStations.get(7), null, 180);

        Itineraire iVersaillesIssy = new Itineraire(listStations.get(12), listStations.get(8), null, 120);

        // Liste des itinéraires entre les stations
        List<Itineraire> listItineraires = new ArrayList<>(Arrays.asList(iPontoiseClichy, iClichyPontoise, iClichyTrocadero, iClichyCergy, iClichyClignancourt,
            iTrocaderoClichy, iTrocaderoOrleans,  iOrleansTrocadero,iOrleansBercy, iOrleansAusterlitz, iOrleansIssy, iBercyOrleans, iBercyAusterlitz, iBercyVincennes, iBercyIssy,
            iVincennesBercy, iBobignyAusterlitz, iAusterlitzBobigny, iAusterlitzOrleans, iAusterlitzBercy, iAusterlitzClignancourt, iIssyOrleans, iIssyBercy,
            iIssyAntony, iIssyVersailles, iAntonyIssy, iCergyClichy, iClignancourtClichy, iClignancourtAusterlitz, iVersaillesIssy
        ));

        //Creation du Graphe
        Graphe metro = new Graphe(listStations, listItineraires);
        return metro;

        // // Création des lignes
        // Ligne l1 = new Ligne("Ligne 1", false);
        // Ligne l2 = new Ligne("Ligne 2", false);
        // Ligne l3 = new Ligne("Ligne 3", false);

        // // Création des listes de lignes
        // // Permet d'indiquer les lignes sur lesquelles se trouvent les stations.
        // ArrayList<Ligne> lignes1 = new ArrayList<>(Arrays.asList(l1));
        // ArrayList<Ligne> lignes2 = new ArrayList<>(Arrays.asList(l2));
        // ArrayList<Ligne> lignes3 = new ArrayList<>(Arrays.asList(l3));
        // ArrayList<Ligne> lignes1_2 = new ArrayList<>(Arrays.asList(l1,l2));
        // ArrayList<Ligne> lignes1_3 = new ArrayList<>(Arrays.asList(l1,l3));
        // ArrayList<Ligne> lignes2_3 = new ArrayList<>(Arrays.asList(l2,l3)); 

        // // Création des stations
        // Station s1 = new Station("Pontoise", lignes1, false, 60, 4, 13);
        // Station s2 = new Station("Clichy", lignes1_3, false, 70, 4, 11);
        // Station s3 = new Station("Trocadéro", lignes1, false, 65, 6, 8);
        // Station s4 = new Station("Orléans", lignes1_2, false, 85, 8, 7);
        // Station s5 = new Station("Bercy", lignes1_3, false, 75, 12, 5);
        // Station s6 = new Station("Vincennes", lignes1, false, 90, 14, 5);
        // Station s7 = new Station("Bobigny", lignes2, false, 80, 13, 10);
        // Station s8 = new Station("Austerlitz", lignes2_3, false, 95, 10, 7);
        // Station s9 = new Station("Issy", lignes2_3, false, 50, 6, 3);
        // Station s10 = new Station("Antony", lignes2, false, 55, 6, 1);
        // Station s11 = new Station("Cergy", lignes3, false, 45, 1, 11);
        // Station s12 = new Station("Clignancourt", lignes3, false, 100, 9, 11);
        // Station s13 = new Station("Versailles", lignes3, false, 45, 3, 3);

        // // Création des chemins entre les stations
        // Itineraire iPontoiseClichy = new Itineraire(s1, s2, null, 90);
        
        // Itineraire iClichyPontoise = new Itineraire(s2, s1, null, 90);
        // Itineraire iClichyTrocadero = new Itineraire(s2, s3, null, 180);
        // Itineraire iClichyCergy = new Itineraire(s2, s11, null, 120);
        // Itineraire iClichyClignancourt = new Itineraire(s2, s12, null, 180);

        // Itineraire iTrocaderoClichy = new Itineraire(s3, s2, null, 180);
        // Itineraire iTrocaderoOrleans = new Itineraire(s3, s4, null, 120);
        
        // Itineraire iOrleansTrocadero = new Itineraire(s4, s3, null, 120);
        // Itineraire iOrleansBercy = new Itineraire(s4, s5, null, 210);
        // Itineraire iOrleansAusterlitz = new Itineraire(s4, s8, null, 90);
        // Itineraire iOrleansIssy = new Itineraire(s4, s9, null, 210);
        
        // Itineraire iBercyOrleans = new Itineraire(s5, s4, null, 210);
        // Itineraire iBercyAusterlitz = new Itineraire(s5, s8, null, 150);
        // Itineraire iBercyVincennes = new Itineraire(s5, s6, null, 90);
        // Itineraire iBercyIssy = new Itineraire(s5, s9, null, 270);

        // Itineraire iVincennesBercy = new Itineraire(s6, s5, null, 90);

        // Itineraire iBobignyAusterlitz = new Itineraire(s7, s8, null, 210);

        // Itineraire iAusterlitzBobigny = new Itineraire(s8, s7, null, 210);
        // Itineraire iAusterlitzOrleans = new Itineraire(s8, s4, null, 90);
        // Itineraire iAusterlitzBercy = new Itineraire(s8, s5, null, 150);
        // Itineraire iAusterlitzClignancourt = new Itineraire(s8, s12, null, 180);

        // Itineraire iIssyOrleans = new Itineraire(s9, s4, null, 210);
        // Itineraire iIssyBercy = new Itineraire(s9, s5, null, 210);
        // Itineraire iIssyAntony = new Itineraire(s9, s10, null, 90);
        // Itineraire iIssyVersailles = new Itineraire(s9, s13, null, 120);

        // Itineraire iAntonyIssy = new Itineraire(s10, s9, null, 90);

        // Itineraire iCergyClichy = new Itineraire(s11, s2, null, 120);
        
        // Itineraire iClignancourtClichy = new Itineraire(s12, s2, null, 180);
        // Itineraire iClignancourtAusterlitz = new Itineraire(s12, s8, null, 180);

        // Itineraire iVersaillesIssy = new Itineraire(s13, s9, null, 120);

        // // Liste des stations
        // List<Station> listStations = new ArrayList<>(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13));

        // // Liste des itinéraires entre les stations
        // List<Itineraire> listItineraires = new ArrayList<>(Arrays.asList(iPontoiseClichy, iClichyPontoise, iClichyTrocadero, iClichyCergy, iClichyClignancourt,
        //     iTrocaderoClichy, iTrocaderoOrleans,  iOrleansTrocadero,iOrleansBercy, iOrleansAusterlitz, iOrleansIssy, iBercyOrleans, iBercyAusterlitz, iBercyVincennes, iBercyIssy,
        //     iVincennesBercy, iBobignyAusterlitz, iAusterlitzBobigny, iAusterlitzOrleans, iAusterlitzBercy, iAusterlitzClignancourt, iIssyOrleans, iIssyBercy,
        //     iIssyAntony, iIssyVersailles, iAntonyIssy, iCergyClichy, iClignancourtClichy, iClignancourtAusterlitz, iVersaillesIssy
        // ));

        // //Creation du Graphe
        // Graphe metro = new Graphe(listStations, listItineraires);
        // return metro;
    }

}
