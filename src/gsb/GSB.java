package gsb;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;


public class GSB {

    private static int compteurId = 41;

    public static void main(String[] args) {
        // Création de l'accès à la base de données
        AccesBdD accesBdD = new AccesBdD();
        VisiteurDAO visiteurDAO = new VisiteurDAO(accesBdD.getConnexion());

        // Création d'un nouvel utilisateur avec des informations de base
        Visiteur nouveauVisiteur = new Visiteur(
                "", //ID généré
                "Villachane",
                "Louis",
                "", // Le login sera généré
                "", // Mot de passe généré
                "123 Rue de la Paix",
                "75001",
                "Paris",
                LocalDate.of(2023, 1, 15)
        );

        // Vérification et génération d'un login unique
        String id = genererIdUnique(visiteurDAO);

        String login = genererLoginUnique(nouveauVisiteur, visiteurDAO);

        String mdp = genererMdpUnique();

        nouveauVisiteur.setLogin(login);

        nouveauVisiteur.setMdp(mdp);

        nouveauVisiteur.setId(id);

        // Affichage du login généré
        System.out.println("Login généré : " + nouveauVisiteur.getLogin());
        System.out.println("Mot de passe généré : " + nouveauVisiteur.getMdp());
        System.out.println("Mot de passe généré : " + nouveauVisiteur.getMdp());

        // Tu peux ensuite ajouter ici du code pour sauvegarder l'utilisateur dans la base de données si nécessaire
    }

    /**
     * Méthode pour générer un login unique en vérifiant la base de données via
     * VisiteurDAO.
     */
    public static String genererLoginUnique(Visiteur visiteur, VisiteurDAO visiteurDAO) {
        String baseLogin = (visiteur.getPrenom().charAt(0) + visiteur.getNom()).toLowerCase(); // Initiale du prénom + nom
        String login = baseLogin;
        int compteur = 1;

        // Récupération des logins existants via le DAO
        ArrayList<Visiteur> lesLogin = visiteurDAO.getLesLogin();

        // Boucle de vérification pour s'assurer que le login est unique
        boolean loginExistant = true;
        while (loginExistant) {
            loginExistant = false;
            for (Visiteur v : lesLogin) {
                if (v.getLogin().equals(login)) {
                    loginExistant = true;
                    break;
                }
            }
            // Si le login existe, on ajoute un nombre pour le rendre unique
            if (loginExistant) {
                login = baseLogin + compteur;
                compteur++;
            }
        }

        return login;
    }

    public static String genererIdUnique(VisiteurDAO visiteurDAO) {
        ArrayList<String> lesVisiteurs = visiteurDAO.getId(); // Récupère les IDs existants
        boolean idExistant;
        String id;

        do {
            idExistant = false;
            id = "f" + compteurId; // ID commence par "f41"

            // Vérifie si l'ID existe déjà dans la base de données
            for (String v : lesVisiteurs) {
                if (v.equals(id)) {
                    idExistant = true;  // L'ID existe déjà, il faut incrémenter
                    break;
                }
            }
            if (idExistant) {
                compteurId++; // Incrémente le compteur pour essayer un nouvel ID
            }
        } while (idExistant); // Si l'ID existe déjà, recommence avec un nouvel ID

        compteurId++; // Prépare l'incrément pour le prochain ID
        return id; // Retourne l'ID unique
    }

    public static String genererMdpUnique() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder lemdp = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            lemdp.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }

        return lemdp.toString();
    }

}
