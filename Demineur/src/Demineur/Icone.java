package Demineur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Icone extends JPanel {

    private VueJeu vueJeu;
    private Model model;

    public Icone(Model model, VueJeu vueJeu){

        this.model = model;
        this.vueJeu = vueJeu;

    }

    public void caseClassiqueCache(int i, int j){
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/caseNonDecouverte_Classique.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
    }

    public void caseClassique1(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/1_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseClassique2(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/2_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseClassique3(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/3_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseClassique4(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/4_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseClassique5(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/5_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseClassique6(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/6_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseClassique7(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/7_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseClassique8(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/8_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseClassiqueDrapeau(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/Drapeau_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseClassiqueDrapeauFaux(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/Drapeau_Classique_Faux.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseClassiqueVide(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/Vide_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseClassiqueMine(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Classique/Mine_Classique.png");
        System.out.print("i =" + i + " j = " + j);
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDarkCache(int i, int j){
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/caseNonDecouverte_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
    }

    public void caseDark1(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/1_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDark2(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/2_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDark3(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/3_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDark4(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/4_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDark5(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/5_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDark6(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/6_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDark7(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/7_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDark8(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/8_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDarkDrapeau(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/Drapeau_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDarkDrapeauFaux(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/Drapeau_Dark_Faux.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDarkVide(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/Vide_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseDarkMine(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Dark/Mine_Dark.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintempsCache(int i, int j){
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/caseNonDecouverte_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
    }

    public void casePrintemps1(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/1_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintemps2(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/2_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintemps3(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/3_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintemps4(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/4_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintemps5(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/5_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintemps6(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/6_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintemps7(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/7_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintemps8(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/8_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintempsDrapeau(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/Drapeau_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintempsDrapeauFaux(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/Drapeau_Printemps_Faux.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintempsVide(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/Vide_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void casePrintempsMine(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Printemps/Mine_Printemps.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindowsCache(int i, int j){
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/caseNonDecouverte_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
    }

    public void caseWindows1(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/1_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindows2(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/2_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindows3(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/3_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindows4(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/4_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindows5(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/5_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindows6(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/6_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindows7(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/7_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindows8(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/8_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindowsDrapeau(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/Drapeau_windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindowsDrapeauFaux(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/Drapeau_windows_Faux.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindowsVide(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/Vide_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

    public void caseWindowsMine(int i, int j) {
        ImageIcon imageIcon = new ImageIcon("Theme_Windows/Mine_Windows.png");
        vueJeu.buttons[i][j].setIcon(imageIcon);
        vueJeu.buttons[i][j].setPreferredSize(new Dimension(30,30));
        vueJeu.buttons[i][j].setBorder(null);
    }

}