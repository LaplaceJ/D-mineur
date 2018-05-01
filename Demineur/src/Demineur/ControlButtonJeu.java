package Demineur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ControlButtonJeu extends MouseAdapter implements ActionListener {

    private Model model;
    private Score score;
    private Chrono chrono;

    private VueJeu vueJeu;
    private VueMenuChoixPersonnalise vueMenuChoixPersonnalise;

    private ControlMenuChoixTaille controlMenuChoixTaille;

    private Icone icon;

    private int cptClick;

    private boolean nomCorrect;

    public ControlButtonJeu(Model model, VueJeu vueJeu) {

        this.model = model;
        this.vueJeu = vueJeu;

        chrono = new Chrono(vueJeu.labelChrono);
        icon = new Icone(model, vueJeu);
        score = new Score(vueJeu);

        this.vueJeu.setButtonControler(this);
        this.vueJeu.setMouseControler(this);

        System.out.println("dÃ©but");
        cptClick = 0;
        nomCorrect = false;

        this.model.setTabJeu();
        System.out.println(model);

    }

    /**
     * Control pour le moment le menu
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //Choisit la dificultÃ© facile taille 5x5 avec 4 mines
        if (e.getSource() == vueJeu.facile) {

            System.out.println("facile");
            changementTaille("9", "9", "10");

        }

        //Choisit la dificultÃ© moyenne taille 10x10 avec 10 mines
        if (e.getSource() == vueJeu.moyen) {

            System.out.println("moyen");
            changementTaille("16", "16", "40");

        }

        //Choisit la dificultÃ© difficile taille 15x15 avec 20 mines
        if (e.getSource() == vueJeu.difficile) {

            System.out.println("difficile");
            changementTaille("30", "16", "99");

        }

        //Envoie sur la page de paramÃ©trage personnel
        if (e.getSource() == vueJeu.perso) {

            vueJeu.setVisible(false);
            vueMenuChoixPersonnalise = new VueMenuChoixPersonnalise(model);
            vueMenuChoixPersonnalise.setVisible(true);
            new ControlChoixPersonnalise(model, vueMenuChoixPersonnalise);

        }

        //Affiche la fanetre Ã  propos
        if (e.getSource() == vueJeu.itemApropos) {
            new VueAPropos();
        }

        // Affiche la fenetre des règles du jeu
        if (e.getSource() == vueJeu.regles) {
            new RegleJeu();
        }

        //Pour recommencer une nouvelle partie
        if (e.getSource() == vueJeu.nouvellePartie) {

            vueJeu.setVisible(false);
            vueJeu = new VueJeu(model);
            new ControlButtonJeu(model, vueJeu);
            vueJeu.setVisible(true);

        }

        //Choisir le thÃ¨me classique
        if (e.getSource() == vueJeu.themeClassique) {
            vueJeu.setVisible(false);
            model.setTheme(1);
            vueJeu = new VueJeu(model);
            new ControlButtonJeu(model, vueJeu);
            vueJeu.setVisible(true);
        }

        //Choisir le thÃ¨me dark
        if (e.getSource() == vueJeu.themeBlack) {
            vueJeu.setVisible(false);
            model.setTheme(2);
            vueJeu = new VueJeu(model);
            new ControlButtonJeu(model, vueJeu);
            vueJeu.setVisible(true);
        }

        //Choisir le thÃ¨me printemps
        if (e.getSource() == vueJeu.themePrintemps) {
            vueJeu.setVisible(false);
            model.setTheme(3);
            vueJeu = new VueJeu(model);
            new ControlButtonJeu(model, vueJeu);
            vueJeu.setVisible(true);
        }

        //Choisir le thÃ¨me windows
        if (e.getSource() == vueJeu.themeWindows) {
            vueJeu.setVisible(false);
            model.setTheme(4);
            vueJeu = new VueJeu(model);
            new ControlButtonJeu(model, vueJeu);
            vueJeu.setVisible(true);
        }


        //Afficahge des scores
        Collection collection = new ArrayList();
        String meilleurNom1 = "", meilleurNom2 = "", meilleurNom3 = "";
        String meilleurScore1 = "", meilleurScore2 = "", meilleurScore3 = "";
        String fichier = "", categorie = "";

        //Afficher les 3 meilleurs scores pour le mode facile
        if (e.getSource() == vueJeu.score5x5) {
            fichier = "score5x5.txt";
            categorie = "5 x 5";
        }

        //Afficher les 3 meilleurs scores pour le mode moyen
        if (e.getSource() == vueJeu.score10x10) {
            fichier = "score10x10.txt";
            categorie = "10 x 10";
        }

        //Afficher les 3 meilleurs scores pour le mode difficile
        if (e.getSource() == vueJeu.score15x15) {
            fichier = "score15x15.txt";
            categorie = "15 x 15";
        }

        score = new Score(vueJeu);

        try {

            score.rangerScore(fichier);

            //On regarde si il existe un meilleur score
            //collection.contains(score.getListFinal().get(0))
            if (score.getListFinal().size() >= 1) {
                meilleurNom1 = score.getListFinal().get(0)[0];
                meilleurScore1 = score.getListFinal().get(0)[1];
            } else {
                meilleurNom1 = "name1";
                meilleurScore1 = "score1";
            }

            //On regarde si il existe un 2e meilleur score
            if (score.getListFinal().size() >= 2) {
                meilleurNom2 = score.getListFinal().get(1)[0];
                meilleurScore2 = score.getListFinal().get(1)[1];
            } else {
                meilleurNom2 = "name2";
                meilleurScore2 = "score2";
            }

            //On regarde si il existe un 3e meilleur score
            if (score.getListFinal().size() >= 3) {
                meilleurNom3 = score.getListFinal().get(2)[0];
                meilleurScore3 = score.getListFinal().get(2)[1];
            } else {
                meilleurNom3 = "name3";
                meilleurScore3 = "score3";
            }

            //Appel la fenetre d'affichage des score
            vueJeu.creerBoiteDialogScore(categorie, "1- " + meilleurNom1 + "=>" + meilleurScore1
                    + "\n2- " + meilleurNom2 + "=>" + meilleurScore2
                    + "\n3- " + meilleurNom3 + "=>" + meilleurScore3, fichier);

        } catch (IOException exp) {
            exp.printStackTrace();
        }

    }

    /**
     * Permet le changement de taille du tableau et change aussi le nombre de mines par rapport Ã  la taille
     *
     * @param hauteur
     * @param largeur
     * @param nbrMine
     */
    public void changementTaille(String hauteur, String largeur, String nbrMine) {

        vueJeu.setVisible(false);

        try {
            model.setTailleX(largeur);
        } catch (IsNotNumeric isNotNumeric) {
            isNotNumeric.printStackTrace();
        } catch (IsOutLimit isOutLimit) {
            isOutLimit.printStackTrace();
        }

        try {
            model.setTailleY(hauteur);
        } catch (IsNotNumeric isNotNumeric) {
            isNotNumeric.printStackTrace();
        } catch (IsOutLimit isOutLimit) {
            isOutLimit.printStackTrace();
        }

        try {
            model.setNbBombe(nbrMine);
        } catch (IsNotNumeric isNotNumeric) {
            isNotNumeric.printStackTrace();
        } catch (IsOutLimit isOutLimit) {
            isOutLimit.printStackTrace();
        }

        vueJeu = new VueJeu(model);
        vueJeu.setVisible(true);
        new ControlButtonJeu(model, vueJeu);

    }

    /**
     * Pour savoir si on fait un clique droit ou un clique gauche
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

        cptClick++;
        System.out.println("Nombre de clic : " + cptClick);
        //vueJeu.labelCompteur.setText("Compteur: " + cptClick);

        //Si c'est le 1er clic on gÃ©nÃ¨re le jeu et on dÃ©marre le chrono
        for (int i = 0; i < model.getTailleY(); i++) {
            for (int j = 0; j < model.getTailleX(); j++) {
                if (e.getSource() == vueJeu.buttons[i][j]) {
                    if (cptClick == 1) {
                        model.generationJeu(j + 1, i + 1);
                        chrono.start();
                    }
                }
            }
        }

        if (e.getButton() == 1) {
            try {
                clicGauche(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (IsNotName isNotName) {
                isNotName.printStackTrace();
            } catch (IsNotGoodName isNotGoodName) {
                isNotGoodName.printStackTrace();
            }
        }

        if (e.getButton() == 3) {
            try {
                clicDroit(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (IsNotName isNotName) {
                isNotName.printStackTrace();
            } catch (IsNotGoodName isNotGoodName) {
                isNotGoodName.printStackTrace();
            }
        }

        for (int i = 1; i < model.getTailleX() + 1; i++) {
            for (int j = 1; j < model.getTailleY() + 1; j++) {
                if (model.getTabJeu()[i][j].isDrapeau() && model.getTabJeu()[i][j].isEstUneMine()) {
                    System.out.print("S");
                } else if (model.getTabJeu()[i][j].isEstUneMine()) {
                    System.out.print("M");
                } else if (model.getTabJeu()[i][j].isDrapeau()) {
                    System.out.print("D");
                } else {
                    System.out.print("X");
                }
                System.out.print("\t");
            }
            System.out.print("\n");
        }

    }

    /**
     * GÃ¨re les cliques gauches
     */
    public void clicGauche(MouseEvent e) throws IOException, IsNotGoodName, IsNotName {

        System.out.println("clic gauche");

        boolean win = true;

        for (int i = 0; i < model.getTailleY(); i++) {
            for (int j = 0; j < model.getTailleX(); j++) {
                //Envoie les informations au model
                if (e.getSource() == vueJeu.buttons[i][j]) {
                    if (model.isStart()) {
                        win = model.receptionClique(j + 1, i + 1);
                    }
                }
            }
        }

        System.out.println(model);

        setIcon();

        //Quand on gagne
        quandOnGagne(win);

    }

    /**
     * GÃ¨re les cliques droits
     */
    public void clicDroit(MouseEvent e) throws IOException, IsNotGoodName, IsNotName {

        System.out.println("clic droit");

        boolean win = true;

        for (int i = 0; i < model.getTailleY(); i++) {
            for (int j = 0; j < model.getTailleX(); j++) {
                //Envoie les informations au model
                if (e.getSource() == vueJeu.buttons[i][j]) {
                    System.out.println("Control clic droit x = " + (j + 1) + " y = " + (i + 1));
                    model.cliqueDrapeau(j + 1, i + 1);
                    vueJeu.setNbrADecouvrir(model.getNbaDecouvrir());
                    System.out.println("Bombe à découvrir : " + vueJeu.getNbrADecouvrir());
                    vueJeu.labelCompteur.setText("Compteur: " + vueJeu.getNbrADecouvrir());
                }
            }
        }

        System.out.println(model);

        setIcon();

        //Quand on gagne
        quandOnGagne(win);

    }

    /**
     * Permet de savoir quand on gagne ou on perd
     * Quand on gagne une fenetre s'affiche pour enregistrer le pseudo
     * Quand on perd un fenetre s'ouvre pour dire qu'on a perdu
     *
     * @param win
     * @throws IOException
     */
    private void quandOnGagne(boolean win) throws IOException, IsNotName, IsNotGoodName {

        //Cas oÃ¹ on perd en marchand sur une mine


        if (!win) {

            boolean allow;

            chrono.stopChrono();

            vueJeu.creerBoiteDialogDefaite();

            for (int i = 1; i < model.getTailleX() + 1; i++) {
                for (int j = 1; j < model.getTailleY() + 1; j++) {

                    if (model.getTabJeu()[i][j].isDrapeau() && !model.getTabJeu()[i][j].isEstUneMine()){
                        //allow = model.receptionClique(i, j);
                        System.out.println("Azerty");
                        System.out.println("j = " + j + " i = " + i);
                        switch (vueJeu.getTheme()) {
                            case 1:
                                icon.caseClassiqueDrapeauFaux(j - 1, i - 1);
                                break;
                            case 2:
                                icon.caseDarkDrapeauFaux(j - 1, i - 1);
                                break;
                            case 3:
                                icon.casePrintempsDrapeauFaux(j - 1, i - 1);
                                break;
                            case 4:
                                icon.caseWindowsDrapeauFaux(j - 1, i - 1);
                                break;
                        }

                    }

                    if (model.getTabJeu()[i][j].isDrapeau() && model.getTabJeu()[i][j].isEstUneMine()){
                        switch (vueJeu.getTheme()) {
                            case 1:
                                icon.caseClassiqueDrapeau(j - 1, i - 1);
                                break;
                            case 2:
                                icon.caseDarkDrapeau(j - 1, i - 1);
                                break;
                            case 3:
                                icon.casePrintempsDrapeau(j - 1, i - 1);
                                break;
                            case 4:
                                icon.caseWindowsDrapeau(j - 1, i - 1);
                                break;
                        }
                    }

                    if (model.getTabJeu()[i][j].isEstUneMine() && !model.getTabJeu()[i][j].isDrapeau()) {
                        allow = model.receptionClique(i, j);
                        switch (vueJeu.getTheme()) {
                            case 1:
                                icon.caseClassiqueMine(j - 1, i - 1);
                                break;
                            case 2:
                                icon.caseDarkMine(j - 1, i - 1);
                                break;
                            case 3:
                                icon.casePrintempsMine(j - 1, i - 1);
                                break;
                            case 4:
                                icon.caseWindowsMine(j - 1, i - 1);
                                break;
                        }
                    }

                }
            }

            for (int i = 0; i < vueJeu.buttons.length; i++) {
                for (int j = 0; j < vueJeu.buttons[i].length; j++) {
                    vueJeu.buttons[i][j].removeMouseListener(this);
                }
            }

        } else if (model.estGagner()) {

                chrono.stopChrono();

                setIcon();

                for (int i = 0; i < vueJeu.buttons.length; i++) {
                    for (int j = 0; j < vueJeu.buttons[i].length; j++) {
                        vueJeu.buttons[i][j].removeMouseListener(this);
                    }
                }

                try {
                    //Affiche la fenetre pour inscrire son pseudo et enregistre le score par rapport Ã  la taille du tableau
                    System.out.println("Nom correct : " + nomCorrect);
                    vueJeu.creerBoiteDialogVictoire();
                    score.setStringChrono(chrono.toString());
                    score.setNomJoueur(vueJeu.getNomJoueur());
                    nomCorrect = true;
                    //Pour le 5 x 5
                    if (vueJeu.buttons.length == 5 && vueJeu.buttons[0].length == 5) {
                        score.ecrireScore("score5x5.txt");
                    }
                    //Pour le 10 x 10
                    else if (vueJeu.buttons.length == 10 && vueJeu.buttons[0].length == 10) {
                        score.ecrireScore("score10x10.txt");
                    }
                    //Pour le 15 x 15
                    else if (vueJeu.buttons.length == 15 && vueJeu.buttons[0].length == 15) {
                        score.ecrireScore("score15x15.txt");
                    }
                    //Pour les parties paramÃ©trÃ©es
                    else {
                        JOptionPane dialogVictoire = new JOptionPane();
                        JOptionPane.showMessageDialog(null, "Bravo vous avez gagné !", "Victoire", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (IsNotGoodName isNotGoodName) {
                    vueJeu.creerBoiteDialogErreurPseudo(isNotGoodName.toString());
                } catch (IsNotName isNotName) {
                    vueJeu.creerBoiteDialogErreurPseudo(isNotName.toString());
                }

            }

        }

        /**
         * Permet le rafraichissement de la page
         */

    public void setIcon() {

        System.out.println("Hauteur = " + model.getTailleY());
        System.out.println("Largeur = " + model.getTailleX());

        for (int i = 1; i < model.getTailleY() + 1; i++) {
            for (int j = 1; j < model.getTailleX() + 1; j++) {

                if (model.getTabJeu()[j][i].isDrapeau()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassiqueDrapeau(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDarkDrapeau(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintempsDrapeau(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindowsDrapeau(i - 1, j - 1);
                            break;
                    }

                } else if (model.getTabJeu()[j][i].isDecouvert() && model.getTabJeu()[j][i].isEstUneMine()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassiqueMine(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDarkMine(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintempsMine(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindowsMine(i - 1, j - 1);
                            break;
                    }

                } else if (model.getTabJeu()[j][i].getNbMineAutour() == 0 && model.getTabJeu()[j][i].isDecouvert()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassiqueVide(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDarkVide(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintempsVide(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindowsVide(i - 1, j - 1);
                            break;
                    }

                } else if (model.getTabJeu()[j][i].getNbMineAutour() == 1 && model.getTabJeu()[j][i].isDecouvert()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassique1(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDark1(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintemps1(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindows1(i - 1, j - 1);
                            break;
                    }

                } else if (model.getTabJeu()[j][i].getNbMineAutour() == 2 && model.getTabJeu()[j][i].isDecouvert()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassique2(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDark2(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintemps2(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindows2(i - 1, j - 1);
                            break;
                    }

                } else if (model.getTabJeu()[j][i].getNbMineAutour() == 3 && model.getTabJeu()[j][i].isDecouvert()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassique3(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDark3(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintemps3(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindows3(i - 1, j - 1);
                            break;
                    }

                } else if (model.getTabJeu()[j][i].getNbMineAutour() == 4 && model.getTabJeu()[j][i].isDecouvert()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassique4(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDark4(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintemps4(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindows4(i - 1, j - 1);
                            break;
                    }

                } else if (model.getTabJeu()[j][i].getNbMineAutour() == 5 && model.getTabJeu()[j][i].isDecouvert()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassique5(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDark5(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintemps5(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindows5(i - 1, j - 1);
                            break;
                    }

                } else if (model.getTabJeu()[j][i].getNbMineAutour() == 6 && model.getTabJeu()[j][i].isDecouvert()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassique6(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDark6(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintemps6(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindows6(i - 1, j - 1);
                            break;
                    }

                } else if (model.getTabJeu()[j][i].getNbMineAutour() == 7 && model.getTabJeu()[j][i].isDecouvert()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassique7(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDark7(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintemps7(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindows7(i - 1, j - 1);
                            break;
                    }

                } else if (model.getTabJeu()[j][i].getNbMineAutour() == 8 && model.getTabJeu()[j][i].isDecouvert()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassique8(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDark8(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintemps8(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindows8(i - 1, j - 1);
                            break;
                    }

                } else if (!model.getTabJeu()[j][i].isDecouvert() && !model.getTabJeu()[j][i].isDrapeau()) {

                    switch (vueJeu.getTheme()) {
                        case 1:
                            icon.caseClassiqueCache(i - 1, j - 1);
                            break;
                        case 2:
                            icon.caseDarkCache(i - 1, j - 1);
                            break;
                        case 3:
                            icon.casePrintempsCache(i - 1, j - 1);
                            break;
                        case 4:
                            icon.caseWindowsCache(i - 1, j - 1);
                            break;
                    }

                }

            }
        }

    }

}