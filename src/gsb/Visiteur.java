    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package gsb;

    import java.time.LocalDate;

    
    public class Visiteur {

        private String id;
        private String nom;
        private String prenom;
        private String login;
        private String mdp;
        private String adresse;
        private String cp;
        private String ville;
        private LocalDate dateEmbauche;

        public Visiteur(String id, String nom, String prenom, String login, String mdp, String adresse, String cp, String ville, LocalDate dateEmbauche) {
            this.id = id;
            this.nom = nom;
            this.prenom = prenom;
            this.login = login;
            this.mdp = mdp;
            this.adresse = adresse;
            this.cp = cp;
            this.ville = ville;
            this.dateEmbauche = dateEmbauche;
        }

        
        public Visiteur(String login) {
        this.login = login;
    }

        /**
         * @return the id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return the nom
         */
        public String getNom() {
            return nom;
        }

        /**
         * @param nom the nom to set
         */
        public void setNom(String nom) {
            this.nom = nom;
        }

        /**
         * @return the prenom
         */
        public String getPrenom() {
            return prenom;
        }

        /**
         * @param prenom the prenom to set
         */
        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        /**
         * @return the login
         */
        public String getLogin() {
            return login;
        }

        /**
         * @param login the login to set
         */
        public void setLogin(String login) {
            this.login = login;
        }

        /**
         * @return the mdp
         */
        public String getMdp() {
            return mdp;
        }

        /**
         * @param mdp the mdp to set
         */
        public void setMdp(String mdp) {
            this.mdp = mdp;
        }

        /**
         * @return the adresse
         */
        public String getAdresse() {
            return adresse;
        }

        /**
         * @param adresse the adresse to set
         */
        public void setAdresse(String adresse) {
            this.adresse = adresse;
        }

        /**
         * @return the cp
         */
        public String getCp() {
            return cp;
        }

        /**
         * @param cp the cp to set
         */
        public void setCp(String cp) {
            this.cp = cp;
        }

        /**
         * @return the ville
         */
        public String getVille() {
            return ville;
        }

        /**
         * @param ville the ville to set
         */
        public void setVille(String ville) {
            this.ville = ville;
        }

        /**
         * @return the dateEmbauche
         */
        public LocalDate getDateEmbauche() {
            return dateEmbauche;
        }

        /**
         * @param dateEmbauche the dateEmbauche to set
         */
        public void setDateEmbauche(LocalDate dateEmbauche) {
            this.dateEmbauche = dateEmbauche;
        }



    }
