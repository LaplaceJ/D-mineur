package Demineur;

import javax.swing.*; // Pour les composants graphiques que l'on ajoutera dans la méthode creerWidget
import java.awt.*;    // Pour la JFrame
import java.awt.event.*;

public class VueMenuChoixPersonnalise extends JFrame {

    private  Model model;

    protected JPanel panelPano = new JPanel();
    protected JPanel panelGlobal = new JPanel(new GridLayout(2,1,10,30));
    protected JPanel panelSousGlobal1 = new JPanel(new GridLayout(3,2,10,30));
    protected JPanel panelSousGlobal2 = new JPanel(new GridLayout(2,1,10,30));
    protected JPanel panelHauteur = new JPanel();
    protected JPanel panelLargeur = new JPanel();
    protected JPanel panelPourcentMine = new JPanel();
    protected JLabel labelHauteur = new JLabel("Hauteur");
    protected JLabel labelLargeur = new JLabel("Largeur");
    protected JLabel labelPourcentMine = new JLabel("Nombre de mines");
    protected JTextField jtHauteur = new JTextField();
    protected JTextField jtLargeur = new JTextField();
    protected JTextField jtPourcentMine = new JTextField();
    protected JButton demarrer = new JButton(new ImageIcon("Image_Taille/Demarrer.png"));
    protected JButton annuler = new JButton(new ImageIcon("Image_Taille/Annuler.png"));
    protected JLabel t = new JLabel("Personnalise ton démineur");
    protected Font f = new Font("Serif", Font.ITALIC, 20);
    protected  JOptionPane jop;
    protected ImageIcon img = new ImageIcon("LogoFenetre.png");

    private int theme;

    public VueMenuChoixPersonnalise(Model model) {

        this.model = model;
        this.theme = model.getTheme();

        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Démineur");
        setIconImage(img.getImage());

        creerWidget();

    }

    public int getTheme() {
        return theme;
    }

    public void creerWidget() {

        t.setFont(f);

        jtHauteur.setColumns(10);
        jtLargeur.setColumns(10);
        jtPourcentMine.setColumns(10);

        demarrer.setPreferredSize(new Dimension(170, 60));
        annuler.setPreferredSize(new Dimension(170, 60));




        switch(theme) {

            case 1:
                panelGlobal.setBackground(Color.GRAY);
                panelSousGlobal1.setBackground(Color.GRAY);
                panelSousGlobal2.setBackground(Color.GRAY);
                panelHauteur.setBackground(Color.GRAY);
                panelLargeur.setBackground(Color.GRAY);
                panelPourcentMine.setBackground(Color.GRAY);
                panelPano.setBackground(Color.GRAY);

                break;
            case 2:
                t.setForeground(new Color(255, 255, 255));
                labelHauteur.setForeground(new Color(255, 255, 255));
                labelLargeur.setForeground(new Color(255, 255, 255));
                labelPourcentMine.setForeground(new Color(255, 255, 255));
                panelGlobal.setBackground(new Color(0, 0, 0));
                panelSousGlobal1.setBackground(new Color(0, 0, 0));
                panelSousGlobal2.setBackground(new Color(0, 0, 0));
                panelHauteur.setBackground(new Color(0, 0, 0));
                panelLargeur.setBackground(new Color(0, 0, 0));
                panelPourcentMine.setBackground(new Color(0, 0, 0));
                panelPano.setBackground(new Color(0, 0, 0));
                break;
            case 3:
                panelGlobal.setBackground(new Color(254, 254, 226));
                panelSousGlobal1.setBackground(new Color(254, 254, 226));
                panelSousGlobal2.setBackground(new Color(254, 254, 226));
                panelHauteur.setBackground(new Color(254, 254, 226));
                panelLargeur.setBackground(new Color(254, 254, 226));
                panelPourcentMine.setBackground(new Color(254, 254, 226));
                panelPano.setBackground(new Color(254, 254, 226));
                break;
            case 4:
                panelGlobal.setBackground(new Color(15, 157, 232));
                panelSousGlobal1.setBackground(new Color(15, 157, 232));
                panelSousGlobal2.setBackground(new Color(15, 157, 232));
                panelHauteur.setBackground(new Color(15, 157, 232));
                panelLargeur.setBackground(new Color(15, 157, 232));
                panelPourcentMine.setBackground(new Color(15, 157, 232));
                panelPano.setBackground(new Color(15, 157, 232));
                break;
        }

        panelPano.add(t);
        panelHauteur.add(labelHauteur);
        panelHauteur.add(jtHauteur);
        panelLargeur.add(labelLargeur);
        panelLargeur.add(jtLargeur);
        panelSousGlobal1.add(panelHauteur);
        panelSousGlobal1.add(panelLargeur);
        panelPourcentMine.add(labelPourcentMine);
        panelPourcentMine.add(jtPourcentMine);
        panelSousGlobal1.add(panelPourcentMine);
        panelGlobal.add(panelSousGlobal1);
        panelSousGlobal2.add(demarrer);
        panelSousGlobal2.add(annuler);
        panelGlobal.add(panelSousGlobal2);
        panelPano.add(panelGlobal);

        setContentPane(panelPano);

    }

    public void afficheErreur1(String s){

        jop = new JOptionPane();
        jop.showMessageDialog(null, s, "Erreur", JOptionPane.ERROR_MESSAGE);

    }

    public void afficheErreur2(String s){

        jop = new JOptionPane();
        jop.showMessageDialog(null, s, "Erreur", JOptionPane.ERROR_MESSAGE);

    }

    public void afficheErreur3(String s){

        jop = new JOptionPane();
        jop.showMessageDialog(null, s, "Erreur", JOptionPane.ERROR_MESSAGE);

    }

    public void setButtonControler(ActionListener listener){

        demarrer.addActionListener(listener);
        annuler.addActionListener(listener);

    }

}
