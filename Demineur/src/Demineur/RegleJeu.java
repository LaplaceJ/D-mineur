package Demineur;

import java.awt.*;
import javax.swing.*;
import java.awt.*;


public class RegleJeu extends JFrame {

    protected JLabel Regle =new JLabel(new ImageIcon("Regle.png"));
    protected JPanel panelPano = new JPanel(new GridLayout(1,1));
    protected ImageIcon img = new ImageIcon("LogoFenetre.png");




    public RegleJeu() {

        setVisible(true);
        setSize(800,800);
        setResizable(true);
        setLocationRelativeTo(null);
        creerWidget();
        setTitle("Règles du jeu");
        setIconImage(img.getImage());

    }

    public void  creerWidget(){

        panelPano.add(Regle);


        setContentPane(panelPano);
    }
}
