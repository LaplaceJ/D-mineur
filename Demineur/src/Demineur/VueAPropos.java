package Demineur;


import javax.swing.*;
import java.awt.*;

public class VueAPropos extends JFrame {

    protected JLabel Apropos=new JLabel(new ImageIcon("Apropos.png"));
    protected JPanel panelPano = new JPanel(new GridLayout(1,1));
    protected ImageIcon img = new ImageIcon("LogoFenetre.png");

    public VueAPropos() {

        setVisible(true);
        setSize(400,400);
        setResizable(false);
        setLocationRelativeTo(null);
        creerWidget();
        setTitle("A propos");
        setIconImage(img.getImage());

    }

    public void creerWidget() {


        panelPano.add(Apropos);


        setContentPane(panelPano);

    }

}