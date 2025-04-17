package PRATIQUONS1_BDD_POO;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VolDAO volDAO = new VolDAO();
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;

        while (cont) {
            System.out.println("MENU");
            System.out.println("1. Afficher tous les vols");
            System.out.println("2. Ajouter un nouveau vol");
            System.out.println("3. Modifier la destination d’un vol");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
            
            int choix;

            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide");
                continue;
            }

            switch (choix) {
                case 1:
                    System.out.println("Affichage de tous les vols : ");
                    volDAO.getAllVols().forEach(vol -> System.out.println(vol));
                    break;

                case 2:
                    System.out.println("Ajouter un nouveau vol : ");
                    System.out.print("Numéro du vol : ");
                    String numeroVol = scanner.nextLine();
                    System.out.print("Ville de départ : ");
                    String villeDepart = scanner.nextLine();
                    System.out.print("Ville d'arrivée : ");
                    String villeArrive = scanner.nextLine();
                    Vol nouveauVol = new Vol(numeroVol, villeDepart, villeArrive);
                    volDAO.ajouterVol(nouveauVol);
                    System.out.println("Vol ajouté avec succès !");
                    break;

                case 3:
                    System.out.println("Modifier la destination d’un vol : ");
                    System.out.print("Numéro du vol à modifier : ");
                    String numVolModifier = scanner.nextLine();
                    System.out.print("Nouvelle destination (ville d'arrivée) : ");
                    String nouvelleDestination = scanner.nextLine();
                    volDAO.modifierDestination(numVolModifier, nouvelleDestination);
                    System.out.println("Destination modifiée avec succès !");
                    break;

                case 4:
                   
                    cont = false;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 4.");
                    break;
            }
        }

        scanner.close();
    }


	}


