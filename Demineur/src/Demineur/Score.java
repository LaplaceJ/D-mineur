package Demineur;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Score {

    private String nomJoueur;
    private String score;
    private String fichier;
    private Chrono chrono;
    private VueJeu vueJeu;

    //C'est le déparateur, c'est à dire ce qui sépare le pseudo du score pour chaque ligne
    public final static String SEPARATOR = "_";

    /*
    Reçoit les lignes du fichier texte visé (chaque ligne comprend le pseudo de l'utilisateur
    et le score sous la forme anthony_23,34
     */
    private ArrayList<String> listLigne;

    /*
    Liste de tableau de String de taille 2
    Permet de séparrer le pseudo du score on passe de anthony_12,45 à [anthony, 12,45]
     */
    private ArrayList<String[]> listTab;

    /*
    Liste de String comportant que le score c'est-à-dire l'élément d'index 1 de chaque tableau
    Dans [anthony, 12,45] la liste récupère alors 12,45
     */
    private ArrayList<String> listScore;

    /*
    Liste de tableau de String de taille 2
    Dans listScore les score on été trié, on remet ensemble les pseudo et score correspondant
    On obtient de nouveau [anthony, 12,45], cette fois les scores sont rangé dans l'ordre.
     */
    private ArrayList<String[]> listFinal;

    public Score(VueJeu vueJeu) {

        this.vueJeu = vueJeu;

        score = "0";
        nomJoueur = "";

        listLigne = new ArrayList<>();
        listTab = new ArrayList<>();
        listScore = new ArrayList<>();
        listFinal = new ArrayList<>();

    }

    public String getFichier(){
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    /**
     * Retourne la liste final c'est à dire la liste avec les scores et les pseudo correspondant dans l'ordre
     * c'est à dire du score le plus petit au plus grand
     * @return listFinal
     */
    public ArrayList<String[]> getListFinal(){
        return listFinal;
    }

    /**
     * Vérifie si le pseudo de l'utilisateur est conforme
     * Sert lors del avictoire et que l'utilisateur rentre son pseudo
     * @param nomJoueur
     */
    public void setNomJoueur(String nomJoueur) throws IsNotGoodName, IsNotName {
        System.out.println("Je suis dans setNomJoueur");
        if (nomJoueur.equals("")) {
            System.out.println("Il ya une exeption 1");
            throw new IsNotName();
        }
        else {
            if (!nomJoueur.matches("[a-zA-Z]{2,20}")) {
                System.out.println("Il ya une exeption 2");
                throw new IsNotGoodName(nomJoueur);
            }
            else {
                System.out.println("Tout va bien je m'appelle : " + nomJoueur);
                this.nomJoueur = nomJoueur;
            }
        }
        System.out.println("Et moi je m'appelle : " + this.nomJoueur);
    }

    /**
     * Récupère le chrono
     * @param strChrono
     */
    public void setStringChrono(String strChrono){
        score = strChrono;
    }

    /**
     * Écrit les scores dans le fichier visé
     * @param fichier
     * @throws IOException
     */
    public void ecrireScore(String fichier) throws IOException {

        File file = new File(fichier);
        System.out.println("File : " + file);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

        bw.write(nomJoueur);
        bw.write("_");
        bw.write(score);
        bw.newLine();
        bw.close();

        System.out.println("nom du joueur : " + this.nomJoueur);
        System.out.println("score du joueur : " + this.score);
        afficheNomJoueur();

    }

    /**
     * Lit les scores dans le fichier visé et le rajoute dans la liste listLigne
     * @param fichier
     * @throws IOException
     */
    public void lireScore(String fichier) throws IOException {

        System.out.println("Je lis:" + fichier);

        String s;

        File file = new File(fichier);

        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((s = br.readLine()) != null) {
            listLigne.add(s);
        }

        br.close();

        for (int i = 0; i < listLigne.size(); i++) {
            System.out.println("Score ligne " + i + " : " + listLigne.get(i));
        }

    }

    /**
     * Permet de trier les scores et des les mettre en relation avec les pseudo
     * @param fichier
     * @throws IOException
     */
    public void rangerScore(String fichier) throws IOException {

        lireScore(fichier);

        //On met chaque ligne du fichier texte dans un tableau de taille 2
        String[] splitArray = null;
        String[] strListe = new String[listLigne.size()];
        for (int i = 0; i < listLigne.size(); i++){
            strListe[i] = listLigne.get(i);
            splitArray = strListe[i].split(SEPARATOR);
            System.out.println(splitArray[1]);
            listTab.add(splitArray);
            System.out.println(Arrays.toString(listTab.get(i)));
        }

        //On prend la partie score c'est-à-dire dans [anthony, 12,34] on prend 12,34
        for (int i = 0; i < listTab.size(); i++){
            listScore.add(listTab.get(i)[1]);
            System.out.println(listScore.get(i));
        }

        //trie les score dans l'ordre décroissant
        Collections.sort(listScore);
        for (int i = 0; i < listScore.size(); i++){
            System.out.println(listScore.get(i));
        }

        //On vient de trier les scores, on doit remettre les pseudo avec le score qui lui correspond
        for (int i = 0; i < listScore.size(); i++){
            for (int j = 0; j < listTab.size(); j++){
                if (listScore.get(i).equals(listTab.get(j)[1])){
                    String[] meilleur = new String[2];
                    //contient les noms
                    meilleur[0] = listTab.get(j)[0];
                    //contient les scores
                    meilleur[1] = listTab.get(j)[1];
                    //ajout dans la liste qui est cette fois rangée
                    listFinal.add(meilleur);
                }
            }
        }
        System.out.println(listFinal.size());
        for (int i = 0; i < listFinal.size(); i++){
            System.out.println("Meilleur score " + fichier + " : " + i);
            System.out.println(Arrays.toString(listFinal.get(i)));
        }

    }

    public void afficheNomJoueur(){

        System.out.println("JE TE DIT QUE LE JOUEUR S'APPELLE : " + nomJoueur);

    }

}
