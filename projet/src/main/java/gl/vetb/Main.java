package gl.vetb;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // LocalTime.of(10,43,12)
        // Création d'une liste d'horaires pour la ligne 1
        List<Horaire> horairesLigne1 = new ArrayList<>();
        horairesLigne1.add(new Horaire(LocalTime.of(8, 00), LocalTime.of(8, 30)));
        horairesLigne1.add(new Horaire(LocalTime.of(8, 30), LocalTime.of(9, 00)));
        horairesLigne1.add(new Horaire(LocalTime.of(9, 00), LocalTime.of(9, 30)));
        // Création d'une liste d'horaires pour la ligne 2
        List<Horaire> horairesLigne2 = new ArrayList<>();
        horairesLigne2.add(new Horaire(LocalTime.of(6, 30), LocalTime.of(7, 30)));
        horairesLigne2.add(new Horaire(LocalTime.of(7, 30), LocalTime.of(8, 30)));
        horairesLigne2.add(new Horaire(LocalTime.of(8, 30), LocalTime.of(9, 30)));
        // Création d'une liste d'horaires pour la ligne 2
        List<Horaire> horairesLigne3 = new ArrayList<>();
        horairesLigne2.add(new Horaire(LocalTime.of(6, 00), LocalTime.of(6, 25)));
        horairesLigne2.add(new Horaire(LocalTime.of(7, 00), LocalTime.of(7, 25)));
        horairesLigne2.add(new Horaire(LocalTime.of(8, 00), LocalTime.of(8, 25)));

        // Création des lignes
        Ligne l1 = new Ligne("Ligne 1", false, horairesLigne1);
        Ligne l2 = new Ligne("Ligne 2", false, horairesLigne2);
        Ligne l3 = new Ligne("Ligne 3", false, horairesLigne3);

        // Création des listes de lignes
        // Permet d'indiquer les lignes sur lesquelles se trouvent les stations.
        ArrayList<Ligne> lignes1 = new ArrayList<>(Arrays.asList(l1));
        ArrayList<Ligne> lignes2 = new ArrayList<>(Arrays.asList(l2));
        ArrayList<Ligne> lignes3 = new ArrayList<>(Arrays.asList(l3));
        ArrayList<Ligne> lignes1_2 = new ArrayList<>(Arrays.asList(l1, l2));
        ArrayList<Ligne> lignes1_3 = new ArrayList<>(Arrays.asList(l1, l3));
        ArrayList<Ligne> lignes2_3 = new ArrayList<>(Arrays.asList(l2, l3));

        // Création des stations
        Station s1 = new Station("Pontoise", lignes1, false, 60, 4, 13);
        Station s2 = new Station("Clichy", lignes1_3, false, 70, 4, 11);
        Station s3 = new Station("Trocadéro", lignes1, false, 65, 6, 8);
        Station s4 = new Station("Orléans", lignes1_2, false, 85, 8, 7);
        Station s5 = new Station("Bercy", lignes1_3, false, 75, 12, 5);
        Station s6 = new Station("Vincennes", lignes1, false, 90, 14, 5);
        Station s7 = new Station("Bobigny", lignes2, false, 80, 13, 10);
        Station s8 = new Station("Austerlitz", lignes2_3, false, 95, 10, 7);
        Station s9 = new Station("Issy", lignes2_3, false, 50, 6, 3);
        Station s10 = new Station("Antony", lignes2, false, 55, 6, 1);
        Station s11 = new Station("Cergy", lignes3, false, 45, 1, 11);
        Station s12 = new Station("Clignancourt", lignes3, false, 100, 9, 11);
        Station s13 = new Station("Versailles", lignes3, false, 45, 3, 3);

        Map<Ligne, List<Horaire>> horaires1 = new HashMap<>();
        horaires1.put(l1, horairesLigne1);
        Map<Ligne, List<Horaire>> horaires2 = new HashMap<>();
        horaires2.put(l2, horairesLigne2);
        Map<Ligne, List<Horaire>> horaires3 = new HashMap<>();
        horaires2.put(l2, horairesLigne3);
        
        // Création des chemins entre les stations
        Itineraire iPontoiseClichy = new Itineraire(s1, s2, null, 90, horaires1);

        Itineraire iClichyPontoise = new Itineraire(s2, s1, null, 90, horaires2);
        Itineraire iClichyTrocadero = new Itineraire(s2, s3, null, 180, horaires3);
        Itineraire iClichyCergy = new Itineraire(s2, s11, null, 120, horaires1);
        Itineraire iClichyClignancourt = new Itineraire(s2, s12, null, 180, horaires1);

        Itineraire iTrocaderoClichy = new Itineraire(s3, s2, null, 180, horaires2);
        Itineraire iTrocaderoOrleans = new Itineraire(s3, s4, null, 120, horaires3);

        Itineraire iOrleansTrocadero = new Itineraire(s4, s3, null, 120, horaires1);
        Itineraire iOrleansBercy = new Itineraire(s4, s5, null, 210, horaires2);
        Itineraire iOrleansAusterlitz = new Itineraire(s4, s8, null, 90, horaires3);
        Itineraire iOrleansIssy = new Itineraire(s4, s9, null, 210, horaires1);

        Itineraire iBercyOrleans = new Itineraire(s5, s4, null, 210, horaires2);
        Itineraire iBercyAusterlitz = new Itineraire(s6, s8, null, 150, horaires3);
        Itineraire iBercyVincennes = new Itineraire(s5, s6, null, 90, horaires1);
        Itineraire iBercyIssy = new Itineraire(s5, s9, null, 270, horaires2);

        Itineraire iVincennesBercy = new Itineraire(s6, s5, null, 90, horaires3);

        Itineraire iBobignyAusterlitz = new Itineraire(s7, s8, null, 210, horaires1);

        Itineraire iAusterlitzBobigny = new Itineraire(s8, s7, null, 210, horaires2);
        Itineraire iAusterlitzOrleans = new Itineraire(s8, s4, null, 90, horaires3);
        Itineraire iAusterlitzBercy = new Itineraire(s8, s5, null, 150, horaires1);
        Itineraire iAusterlitzClignancourt = new Itineraire(s8, s12, null, 180, horaires2);

        Itineraire iIssyOrleans = new Itineraire(s9, s4, null, 210, horaires3);
        Itineraire iIssyBercy = new Itineraire(s9, s5, null, 210, horaires1);
        Itineraire iIssyAntony = new Itineraire(s9, s10, null, 90, horaires2);
        Itineraire iIssyVersailles = new Itineraire(s9, s13, null, 120, horaires3);

        Itineraire iAntonyIssy = new Itineraire(s10, s9, null, 90, horaires1);

        Itineraire iCergyClichy = new Itineraire(s11, s2, null, 120, horaires2);

        Itineraire iClignancourtClichy = new Itineraire(s12, s2, null, 180, horaires3);
        Itineraire iClignancourtAusterlitz = new Itineraire(s12, s8, null, 180, horaires1);

        Itineraire iVersaillesIssy = new Itineraire(s13, s9, null, 120, horaires2);

        // Liste des stations
        List<Station> listStations = new ArrayList<>(
                Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13));

        // Liste des itinéraires entre les stations
        List<Itineraire> listItineraires = new ArrayList<>(
                Arrays.asList(iPontoiseClichy, iClichyPontoise, iClichyTrocadero, iClichyCergy, iClichyClignancourt,
                        iTrocaderoClichy, iTrocaderoOrleans, iOrleansTrocadero, iOrleansBercy, iOrleansAusterlitz,
                        iOrleansIssy, iBercyOrleans, iBercyAusterlitz, iBercyVincennes, iBercyIssy,
                        iVincennesBercy, iBobignyAusterlitz, iAusterlitzBobigny, iAusterlitzOrleans, iAusterlitzBercy,
                        iAusterlitzClignancourt, iIssyOrleans, iIssyBercy,
                        iIssyAntony, iIssyVersailles, iAntonyIssy, iCergyClichy, iClignancourtClichy,
                        iClignancourtAusterlitz, iVersaillesIssy));

        // Creation du Graphe
        Graphe metro = new Graphe(listStations, listItineraires);

    }

    // Fonction pour demander l'heure de départ a l'utilisateur
    public static LocalTime demanderHeureDepart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer l'heure de départ (format HH:mm) : ");
        String heureDepartStr = scanner.nextLine();
        return LocalTime.parse(heureDepartStr);
    }

    // Affichage les horaires de passage pour chaque ligne d'itinéraire passé en
    // param.
    public static void afficherHorairesPassage(Itineraire itineraire) {
        System.out.println("Horaires de passage pour chaque ligne :");
        Map<Ligne, List<Horaire>> horaires = itineraire.getHoraires();

        for (Ligne ligne : horaires.keySet()) {
            System.out.println("Ligne : " + ligne.getNom());

            List<Horaire> horairesLigne = horaires.get(ligne);
            for (Horaire horaire : horairesLigne) {
                System.out.println("Heure de départ : " + horaire.getHeureDepart());
                System.out.println("Heure d'arrivée : " + horaire.getHeureArrivee());
            }

            System.out.println("-----------------------");
        }
    }

}
