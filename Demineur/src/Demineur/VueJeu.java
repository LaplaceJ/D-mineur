package Demineur;

import javax.swing.*; // Pour les composants graphiques que l'on ajoutera dans la méthode creerWidget
import java.awt.*;    // Pour la JFrame
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;

public class VueJeu extends JFrame {

    private Model model;
    private Chrono chrono;
    private Score score;
    private String nomJoueur;

    private int largeurX;
    private int longueurY;
    protected JButton[][] buttons;

    protected JPanel panelGlobal;
    protected JPanel panelAffichage;
    protected JPanel panelChrono;
    protected JPanel panelCompteur;
    protected JPanel panelCenter;
    protected JPanel panelSouth;
    protected JPanel panelWest;
    protected JPanel panelEast;
    protected JPanel panelNorth;

    protected JLabel labelChrono;
    protected JLabel labelCompteur;

    protected JMenuItem itemApropos;
    protected JMenuItem nouvellePartie;
    protected JMenuItem facile;
    protected JMenuItem moyen;
    protected JMenuItem difficile;
    protected JMenuItem perso;
    protected JMenuItem themeClassique;
    protected JMenuItem themeBlack;
    protected JMenuItem themePrintemps;
    protected JMenuItem themeWindows;
    protected JMenuItem score5x5;
    protected JMenuItem score10x10;
    protected JMenuItem score15x15;
    protected JMenuItem regles;

    private JOptionPane dialogVictoire;
    private JOptionPane dialogDefaite;
    private JOptionPane dialogErreurPseudo;
    private JOptionPane dialogScore;

    private int theme;
    protected ImageIcon img = new ImageIcon("LogoFenetre.png");
    private int nbrADecouvrir;
    //private Icon bombe,drapeau,interrogation,numero1,numero2,numero3,numero4,numero5;

    public VueJeu(Model model) {

        this.model = model;
        this.theme = model.getTheme();
        score = new Score(this);
        nomJoueur = "";

        setResizable(false);
        initGrille();
        initAttribut();
        creerPlateau();
        creerMenu();

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Gestion de la fermeture
        setTitle("Démineur");
        setIconImage(img.getImage());

    }

    public int getTheme(){
        return theme;
    }

    public Chrono getChrono(){
        return chrono;
    }

    public Model getModel() { return model;}

    public String getNomJoueur() { return nomJoueur; }

    public int getNbrADecouvrir(){
        return nbrADecouvrir;
    }

    public void setNbrADecouvrir(int nbrADecouvrir){
        this.nbrADecouvrir = nbrADecouvrir;
    }

    public void initAttribut(){

        itemApropos = new JMenuItem("A propos");
        nouvellePartie = new JMenuItem(" Nouvelle Partie");
        facile = new JMenuItem("Facile");
        moyen = new JMenuItem("Moyen");
        difficile = new JMenuItem("Difficile");
        perso = new JMenuItem("Personalisee");
        themeClassique = new JMenuItem("Classique");
        themeBlack = new JMenuItem("Dark");
        themePrintemps = new JMenuItem("Printemps");
        themeWindows = new JMenuItem("Windows");
        score5x5 = new JMenuItem("9x9");
        score10x10 = new JMenuItem("16x16");
        score15x15 = new JMenuItem("16x30");
        regles = new JMenuItem("Règles du jeu");


        labelChrono = new JLabel("Chrono : 0.00");
        labelCompteur = new JLabel("Compteur: ");
        if (model.getTheme() == 2){
            labelChrono.setForeground(new Color(255, 255, 255));
            labelCompteur.setForeground(new Color(255, 255, 255));
        }
        chrono = new Chrono(labelChrono);
        panelChrono = new JPanel();
        panelCompteur = new JPanel();
        panelAffichage = new JPanel(new GridLayout(1, 2));

        panelEast = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelNorth = new JPanel();
        panelSouth = new JPanel();
        panelGlobal = new JPanel(new BorderLayout());

    }
    public void initGrille(){

        largeurX = model.getTailleY();
        longueurY = model.getTailleX();

        System.out.println("x = " + largeurX);
        System.out.println("y = " + longueurY);

        buttons = new JButton[largeurX][longueurY];

        for (int i =0 ; i<largeurX;i++){
            for (int j=0; j<longueurY;j++){

                switch (theme) {
                    case 1:

                        buttons[i][j]= new JButton(new ImageIcon("Theme_Classique/caseNonDecouverte_Classique.png"));
                        buttons[i][j].setPreferredSize(new Dimension(30,30));

                        break;
                    case 2:

                        buttons[i][j]= new JButton(new ImageIcon("Theme_Dark/caseNonDecouverte_Dark.png"));
                        buttons[i][j].setPreferredSize(new Dimension(30,30));

                        break;
                    case 3:

                        buttons[i][j]= new JButton(new ImageIcon("Theme_Printemps/caseNonDecouverte_Printemps.png"));
                        buttons[i][j].setPreferredSize(new Dimension(30,30));

                        break;
                    case 4:

                        buttons[i][j]= new JButton(new ImageIcon("Theme_Windows/caseNonDecouverte_Windows.png"));
                        buttons[i][j].setPreferredSize(new Dimension(30,30));

                }

            }
        }

    }

    public void creerPlateau(){


        JPanel plateau = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weighty = 1;
        gbc.weightx = 1;

        for ( int i = 0  ; i <largeurX ; i++){
            for (int j = 0 ; j <longueurY ; j++){
                gbc.gridx = i;
                gbc.gridy = j;
                plateau.add(buttons[i][j], gbc);
            }
        }

        switch(theme) {

            case 1:
                panelGlobal.setBackground(Color.GRAY);
                panelAffichage.setBackground(Color.GRAY);
                panelChrono.setBackground(Color.GRAY);
                panelCompteur.setBackground(Color.GRAY);
                panelNorth.setBackground(Color.GRAY);
                panelEast.setBackground(Color.GRAY);
                panelSouth.setBackground(Color.GRAY);
                panelWest.setBackground(Color.GRAY);
                break;
            case 2:
                panelGlobal.setBackground(new Color(0, 0, 0));
                panelAffichage.setBackground(new Color(0, 0, 0));
                panelChrono.setBackground(new Color(0, 0, 0));
                panelCompteur.setBackground(new Color(0, 0, 0));
                panelNorth.setBackground(new Color(0, 0, 0));
                panelEast.setBackground(new Color(0, 0, 0));
                panelSouth.setBackground(new Color(0, 0, 0));
                panelWest.setBackground(new Color(0, 0, 0));
                break;
            case 3:
                panelGlobal.setBackground(new Color(254, 254, 226));
                panelAffichage.setBackground(new Color(254, 254, 226));
                panelChrono.setBackground(new Color(254, 254, 226));
                panelCompteur.setBackground(new Color(254, 254, 226));
                panelNorth.setBackground(new Color(254, 254, 226));
                panelEast.setBackground(new Color(254, 254, 226));
                panelSouth.setBackground(new Color(254, 254, 226));
                panelWest.setBackground(new Color(254, 254, 226));
                break;
            case 4:
                panelGlobal.setBackground(new Color(115, 157, 232));
                panelAffichage.setBackground(new Color(115, 157, 232));
                panelChrono.setBackground(new Color(115, 157, 232));
                panelCompteur.setBackground(new Color(115, 157, 232));
                panelNorth.setBackground(new Color(115, 157, 232));
                panelEast.setBackground(new Color(115, 157, 232));
                panelSouth.setBackground(new Color(115, 157, 232));
                panelWest.setBackground(new Color(115, 157, 232));
                break;
        }

        panelChrono.add(labelChrono);
        panelCompteur.add(labelCompteur);
        panelAffichage.add(panelChrono);
        panelAffichage.add(panelCompteur);
        panelGlobal.add(panelAffichage, BorderLayout.NORTH);
        panelGlobal.add(panelEast, BorderLayout.EAST);
        panelCenter.add(plateau);
        panelGlobal.add(panelCenter, BorderLayout.CENTER);
        panelGlobal.add(panelWest, BorderLayout.WEST);
        panelGlobal.add(panelSouth, BorderLayout.SOUTH);

        setContentPane(panelGlobal);

    }

    public void creerMenu(){

        JMenuBar barMenu = new JMenuBar();

        JMenu menu1 = new JMenu("Partie");
        menu1.add(nouvellePartie);
        menu1.addSeparator();
        JMenu sousMenu1 = new JMenu("Difficulté");
        sousMenu1.add(facile);
        sousMenu1.add(moyen);
        sousMenu1.add(difficile);
        sousMenu1.add(perso);
        JMenu sousMenu2 = new JMenu("Thèmes");
        sousMenu2.add(themeClassique);
        sousMenu2.add(themeBlack);
        sousMenu2.add(themePrintemps);
        sousMenu2.add(themeWindows);
        menu1.add(sousMenu1);
        menu1.add(sousMenu2);

        JMenu menu2 = new JMenu("Meilleur score");
        menu2.add(score5x5);
        menu2.add(score10x10);
        menu2.add(score15x15);

        JMenu menu3 = new JMenu("?");
        menu3.add(regles);
        menu3.add(itemApropos);


        menu1.add(sousMenu1);
        barMenu.add(menu1);
        barMenu.add(menu2);
        barMenu.add(menu3);

        setJMenuBar(barMenu);

    }

    public void setButtonControler(ActionListener listener){

        itemApropos.addActionListener(listener);
        nouvellePartie.addActionListener(listener);
        facile.addActionListener(listener);
        moyen.addActionListener(listener);
        difficile.addActionListener(listener);
        perso.addActionListener(listener);
        themeClassique.addActionListener(listener);
        themeBlack.addActionListener(listener);
        themePrintemps.addActionListener(listener);
        themeWindows.addActionListener(listener);
        score5x5.addActionListener(listener);
        score10x10.addActionListener(listener);
        score15x15.addActionListener(listener);
        regles.addActionListener(listener);

    }

    public void setMouseControler(MouseListener listener){

        for (int i = 0; i < largeurX; i++) {
            for (int j = 0; j < longueurY; j++) {
                buttons[i][j].addMouseListener(listener);
            }
        }

    }

    public void creerBoiteDialogVictoire() throws IsNotGoodName, IsNotName, IOException {

        dialogVictoire = new JOptionPane();
        nomJoueur = JOptionPane.showInputDialog(null, "Bravo vous avez fini, indiquez votre nom pour enregistrer votre score.", "Victoire", JOptionPane.QUESTION_MESSAGE);
        System.out.println("Le nom du joueur est : " + nomJoueur);

    }

    public void creerBoiteDialogDefaite(){

        dialogDefaite = new JOptionPane();
        JOptionPane.showMessageDialog(null, "Boom ! Perdu", "Défaite", JOptionPane.OK_CANCEL_OPTION);

    }

    public void creerBoiteDialogErreurPseudo(String s){

        dialogErreurPseudo = new JOptionPane();
        JOptionPane.showMessageDialog(null, s, "Erreur dans le pseudo", JOptionPane.ERROR_MESSAGE);

    }

    public void creerBoiteDialogScore(String categorie, String scoreString, String fichier) throws IOException {

        Score score = new Score(this);

        score.rangerScore(fichier);

        dialogScore = new JOptionPane();
        JOptionPane.showMessageDialog(null, "Meilleur score : " + categorie + "\n\n" + scoreString, "Meilleur score", JOptionPane.PLAIN_MESSAGE);

    }


}