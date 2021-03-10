package com.GestionBib;

import com.GestionBib.controller.GererLivre;
import com.GestionBib.controller.GererNvxEmprunt;
import com.GestionBib.entities.Emprunt;
import com.GestionBib.entities.Livre;
import com.GestionBib.service.ServiceImpl.DAOImplGererLivre;
import com.GestionBib.service.ServiceImpl.DAOImplGererNvxEmprunt;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int userChoice;
        GererLivre _serviceLivre = new GererLivre(new DAOImplGererLivre());
        GererNvxEmprunt _serviceEmprunt = new GererNvxEmprunt(new DAOImplGererNvxEmprunt());

        Livre livre = new Livre();
        Emprunt emprunt = new Emprunt();

        Scanner input = new Scanner(System.in);


        /*********************************************************/
        do {
            userChoice = menu();
            switch (userChoice) {
                case 0:
                    System.out.print("Voulez vous vraimment quitter l'application O/N ");
                    break;
                case 1:
                    System.out.println("Saisir ISBN du livre ");
                    livre.setISBN(input.nextLine());
                    System.out.println("Saisir Theme du livre ");
                    livre.setTheme(input.nextLine());
                    System.out.println("Saisir titre du livre ");
                    livre.setTitre(input.nextLine());
                    System.out.println("Saisir auteur du livre ");
                    livre.setAuteur(input.nextLine());

                    _serviceLivre.ajouter(livre);
                    break;
                case 2:
                    System.out.println("Saisir id Exemplaire ");
                    emprunt.setIdExemplaire(input.nextInt());
                    System.out.println("Saisir id Etudiant");
                    emprunt.setIdEtudiant(input.nextInt());

                    _serviceEmprunt.ajouter(emprunt);

                    break;
                case 3:
                    System.out.println("Saisir id livre a consulter ");
                    Livre showLivre = _serviceLivre.find(input.nextInt());
                    System.out.println("Livre id :" + showLivre.getId() + " - Titre : " + showLivre.getTitre() + " - Theme : " + showLivre.getTheme() + " - ISBN : " + showLivre.getISBN() + " - Auteur : " + showLivre.getAuteur());


                    break;
                case 4:
                    System.out.println("Saisir id livre a supprimer ");

                    _serviceLivre.delete(input.nextInt());

                    break;
                case 5:
                    System.out.println("Saisir id livre a modifier ");
                    livre.setId(input.nextInt());

                    System.out.println("Saisir Theme du livre ");
                    livre.setTheme(input.nextLine());
                    System.out.println("Saisir titre du livre ");
                    livre.setTitre(input.nextLine());
                    System.out.println("Saisir auteur du livre ");
                    livre.setAuteur(input.nextLine());
                    System.out.println("Saisir ISBN du livre ");
                    livre.setISBN(input.nextLine());
                    _serviceLivre.modifier(livre);

                    break;
                case 6:

                    List<Emprunt> em = _serviceEmprunt.findAll();
                    for (Emprunt emp : em) {
                        System.out.println("Emprunt id :" + emp.getIdEmprunt() + " - Etudiant Id : " + emp.getIdEtudiant() + " - Exemplaire Id : " + emp.getIdExemplaire());

                    }

                    break;

                default:
                    System.out.println("Mauvais numero de commande");
                    break;
            } // fin du switch
        } while (userChoice != 0);

    }

    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/

        System.out.println("-----------------------------------------------");
        System.out.println("1 : Ajout d’un nouveau livre  ");
        System.out.println("2 : Ajout d’un nouveau emprunt ");
        System.out.println("3 : Affichage livre selon id  ");
        System.out.println("4 : Suppression d’un livre.  ");
        System.out.println("5 : Modification d’un livre.  ");
        System.out.println("6 : Affichage de la liste des emprunts.  ");
        System.out.println("0 : quitter l'application ");

        System.out.print("\nVotre choix : ");

        selection = input.nextInt();
        return selection;
    }
}
