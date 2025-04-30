/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsb;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VisiteurDAO {

    private Connection connexion;

    public VisiteurDAO(Connection connexion) {
        this.connexion = connexion;
        System.out.println("📦 Connexion reçue dans VisiteurDAO : " + (connexion != null ? "OK" : "NULL"));

    }

    public ArrayList<Visiteur> getLesVisiteurs() {
        if (connexion == null) {
            throw new IllegalStateException("❌ Erreur critique : la connexion JDBC dans VisiteurDAO est null !");
        }
        
        ResultSet result = null;
        ArrayList<Visiteur> lesVisiteurs = new ArrayList<>();
        try {
            String sql = "select * from visiteur";
            Statement statement;
            statement = connexion.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Visiteur visiteur = new Visiteur(
                        result.getString(1), // id
                        result.getString(2), // nom
                        result.getString(3), // prenom
                        result.getString(4), // login
                        result.getString(5), // mdp
                        result.getString(6), // adresse
                        result.getString(7), // cp
                        result.getString(8), // Ville
                        result.getDate(9).toLocalDate()); // Date d'embauche);
                lesVisiteurs.add(visiteur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lesVisiteurs;

    }

    public ArrayList<Visiteur> getLesLogin() {
        ResultSet result = null;
        ArrayList<Visiteur> lesLogin = new ArrayList<>();
        try {
            String sql = "select login from visiteur";
            Statement statement;
            statement = connexion.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Visiteur visiteur = new Visiteur(result.getString(1));
                lesLogin.add(visiteur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lesLogin;
    }

    public ArrayList<String> getId() {
        ResultSet result = null;
        ArrayList<String> leId = new ArrayList<>();
        try {
            String sql = "select id from visiteur";
            Statement statement;
            statement = connexion.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                leId.add(result.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return leId;
    }

    public ArrayList<Visiteur> getLesMdp() {
        ResultSet result = null;
        ArrayList<Visiteur> lesMdp = new ArrayList<>();
        try {
            String sql = "select mdp from visiteur";
            Statement statement;
            statement = connexion.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Visiteur visiteur = new Visiteur(result.getString(1));
                lesMdp.add(visiteur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lesMdp;
    }

    public ArrayList<Visiteur> getVisiteursParId(int id) {
        ResultSet result = null;
        ArrayList<Visiteur> lesVisiteurs = new ArrayList<>();

        try {
            // Requête avec un filtre sur `id`
            String sql = "SELECT * FROM visiteur WHERE id = ?";
            PreparedStatement statement = (PreparedStatement) connexion.prepareStatement(sql);

            // Lier le paramètre
            statement.setInt(1, id);

            // Exécution de la requête
            result = statement.executeQuery();

            // Parcours des résultats
            while (result.next()) {
                Visiteur visiteur = new Visiteur(
                        result.getString(1), // id
                        result.getString(2), // nom
                        result.getString(3), // prenom
                        result.getString(4), // login
                        result.getString(5), // mdp
                        result.getString(6), // adresse
                        result.getString(7), // cp
                        result.getString(8), // Ville
                        result.getDate(9).toLocalDate() // Date d'embauche
                );
                lesVisiteurs.add(visiteur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesVisiteurs;
    }

    public ArrayList<Visiteur> getLesRecherches(String nomRecherche) {
        ResultSet result = null;
        ArrayList<Visiteur> lesVisiteurs = new ArrayList<>();

        try {
            // Préparation de la requête avec deux paramètres
            String sql = "SELECT * FROM visiteur WHERE id LIKE ? OR nom LIKE ?";
            PreparedStatement statement = (PreparedStatement) connexion.prepareStatement(sql);

            // Lier les paramètres pour le filtre
            String recherche = "%" + nomRecherche + "%"; // Pour autoriser la recherche partielle
            statement.setString(1, recherche); // Pour `id`
            statement.setString(2, recherche); // Pour `nom`

            // Exécution de la requête
            result = statement.executeQuery();

            // Parcours des résultats
            while (result.next()) {
                Visiteur visiteur = new Visiteur(
                        result.getString(1), // id
                        result.getString(2), // nom
                        result.getString(3), // prenom
                        result.getString(4), // login
                        result.getString(5), // mdp
                        result.getString(6), // adresse
                        result.getString(7), // cp
                        result.getString(8), // Ville
                        result.getDate(9).toLocalDate() // Date d'embauche
                );
                lesVisiteurs.add(visiteur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesBdD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesVisiteurs;
    }

}
