package gl.vetb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Graphe metro = new CreationGraphe().creationGraphe();
        // List<Station> listStations = metro.getStations();
        // Itineraire cheminPlusCourt = metro.algoPlusCourtChemin(listStations.get(11), listStations.get(9));
        // System.out.println("Départ : " + cheminPlusCourt.getDepart().getNom());
        // System.out.println("Stations intermédiaires : ");
        // for(Station s : cheminPlusCourt.getStationsIntermediaires()){
        //     System.out.println(s.getNom());
        // }
        // System.out.println("Arrivée : " + cheminPlusCourt.getArrivee().getNom());
        // System.out.println("Durée : " + cheminPlusCourt.getDuree());
        
        Graphe metro = new CreationGraphe().creationGraphe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez-vous munir du plan du Metro");
        System.out.println("Veuillez indiquer votre position");
        System.out.println("Abscisse : ");
        int abscisse = 0;
        try{
            abscisse = scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.println("L'abscisse doit être un chiffre");
        }

        System.out.println("Ordonnée : ");
        int ordonnee = 0;
        try{
            ordonnee = scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.println("L'ordonnée doit être un chiffre");
        }
        
        Station depart = metro.calculerStationPlusProche(abscisse, ordonnee);
        System.out.println("Station la plus proche de votre position : " + depart.getNom());

        Station arrivee = null;
        while(arrivee == null){
            System.out.println("Veuillez entrer le nom de la station où vous voulez aller : ");
            String nomStation = scanner.next();
            
            for(Station s : metro.getStations()){
                if(s.getNom().equals(nomStation)){
                    arrivee = s;
                }
            }

            if(arrivee == null){
                System.out.println("La station n'existe pas, veuillez réessayer");
            }
        }

        System.out.println("Tapez 1 si vous voulez avoir le chemin le plus cours entre la station de départ et la station d'arrivée");
        System.out.println("Tapez 2 si vous souhaitez l'itinéraire avec le moins de changement de lignes");
        System.out.println("Tapez 3 si vous souhaitez un itinéraire avec des stations intermédiaires");

        int choix = scanner.nextInt();

        Itineraire chemin = null;
        Boolean valide = false;
        while(!valide){
            switch(choix){
                case 1 : 
                    valide = true;
                    chemin = metro.algoPlusCourtChemin(depart, arrivee);
                    break;

                case 2 :
                    valide = true;
                    chemin = metro.calculerItineraireMoinsChangementLignes(depart, arrivee);
                    break;

                case 3 :
                    valide = true;
                    System.out.println("Veuillez rentrer le nom des stations intermédiaires.");
                    System.out.println("Lorsque vous avez fini, tapez GO pour continuer");
                    List<Station> stationsPassage = new ArrayList<Station>();;
                    String input;
                    while(!(input = scanner.next()).equals("GO")){
                        input = scanner.next();
                        Station station = null;
                        for(Station s : metro.getStations()){
                            if(s.getNom().equals(input)){
                                station = s;
                                break;
                            }
                        }

                        if(station == null){
                            System.out.println("La station n'existe pas, veuillez réessayer");
                        }
                        else{
                            stationsPassage.add(station);
                        }
                    }
                    chemin = metro.algoItineraireAvecPassages(depart, arrivee, stationsPassage);
                    break;

                default : 
                    System.out.println("Veuillez entrer un choix valide");
                
            }
        }
        System.out.println("Départ : " + chemin.getDepart().getNom());
                System.out.println("Stations intermédiaires : ");
                for(Station s : chemin.getStationsIntermediaires()){
                    System.out.println(s.getNom());
                }
                System.out.println("Arrivée : " + chemin.getArrivee().getNom());
                System.out.println("Durée : " + chemin.getDuree());

    }
}
