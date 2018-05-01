package Demineur;

import javax.swing.*; // Pour les composants graphiques que l'on ajoutera dans la méthode creerWidget
import java.awt.*;    // Pour la JFrame
import java.awt.event.*;

public class VueMenuChoixTaille extends JFrame {

    private Model model;

    protected JPanel panelPano = new JPanel();
    protected JPanel panelBouton1 = new JPanel();
    protected JPanel panelBouton2 = new JPanel();
    protected JPanel panelBouton3 = new JPanel();
    protected JPanel panelBouton4 = new JPanel();
    protected JPanel panelBouton = new JPanel(new GridLayout(2,2));
    protected JPanel panelTitre = new JPanel();
    protected JButton boutonTaille1 = new JButton(new ImageIcon("Image_Taille/Facile.png"));
    protected JButton boutonTaille2 = new JButton(new ImageIcon("Image_Taille/Moyen.png"));
    protected JButton boutonTaille3 = new JButton(new ImageIcon("Image_Taille/Difficile.png"));
    protected JButton boutonTaille4 = new JButton(new ImageIcon("Image_Taille/Personalise.png"));
    protected JButton boutonRetour = new JButton(new ImageIcon("Image_Taille/Retour.png"));
    protected JLabel t = new JLabel("Choix de la taille");
    protected Font f = new Font("Serif", Font.ITALIC, 36);
    protected ImageIcon img = new ImageIcon("LogoFenetre.png");

    private int theme ;

    public VueMenuChoixTaille(Model model) {

        this.model = model;
        this.theme = model.getTheme();
        setSize(380,440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Démineur");
        setIconImage(img.getImage());

        creerWidget();

    }

    public  int getTheme(){
        return theme;
    }

    public void creerWidget() {

        t.setFont(f);

        boutonTaille1.setPreferredSize(new Dimension(140, 140));
        boutonTaille2.setPreferredSize(new Dimension(140, 140));
        boutonTaille3.setPreferredSize(new Dimension(140, 140));
        boutonTaille4.setPreferredSize(new Dimension(140, 140));
        boutonRetour.setPreferredSize(new Dimension(80,30));

        switch(theme) {

            case 1:
                panelPano.setBackground(Color.LIGHT_GRAY);
                panelBouton.setBackground(Color.LIGHT_GRAY);
                panelBouton1.setBackground(Color.LIGHT_GRAY);
                panelBouton2.setBackground(Color.LIGHT_GRAY);
                panelBouton3.setBackground(Color.LIGHT_GRAY);
                panelBouton4.setBackground(Color.LIGHT_GRAY);
                panelTitre.setBackground(Color.LIGHT_GRAY);
                break;
            case 2:
                t.setForeground(new Color(255, 255, 255));
                panelPano.setBackground(new Color(0, 0, 0));
                panelBouton.setBackground(new Color(0, 0, 0));
                panelBouton1.setBackground(new Color(0, 0, 0));
                panelBouton2.setBackground(new Color(0, 0, 0));
                panelBouton3.setBackground(new Color(0, 0, 0));
                panelBouton4.setBackground(new Color(0, 0, 0));
                panelTitre.setBackground(new Color(0, 0, 0));
                break;
            case 3:
                panelPano.setBackground(new Color(254, 254, 226));
                panelBouton.setBackground(new Color(254, 254, 226));
                panelBouton1.setBackground(new Color(254, 254, 226));
                panelBouton2.setBackground(new Color(254, 254, 226));
                panelBouton3.setBackground(new Color(254, 254, 226));
                panelBouton4.setBackground(new Color(254, 254, 226));
                panelTitre.setBackground(new Color(254, 254, 226));
                break;
            case 4:
                panelPano.setBackground(new Color(15, 157, 232));
                panelBouton.setBackground(new Color(15, 157, 232));
                panelBouton1.setBackground(new Color(15, 157, 232));
                panelBouton2.setBackground(new Color(15, 157, 232));
                panelBouton3.setBackground(new Color(15, 157, 232));
                panelBouton4.setBackground(new Color(15, 157, 232));
                panelTitre.setBackground(new Color(15, 157, 232));
                break;

        }

        panelTitre.add(t);
        panelPano.add(panelTitre);
        panelBouton1.add(boutonTaille1);
        panelBouton2.add(boutonTaille2);
        panelBouton3.add(boutonTaille3);
        panelBouton4.add(boutonTaille4);
        panelBouton.add(panelBouton1);
        panelBouton.add(panelBouton2);
        panelBouton.add(panelBouton3);
        panelBouton.add(panelBouton4);
        panelPano.add(panelBouton);
        panelPano.add(boutonRetour);

        setContentPane(panelPano);

    }

    public void setButtonControler(ActionListener listener) {

        boutonTaille1.addActionListener(listener);
        boutonTaille2.addActionListener(listener);
        boutonTaille3.addActionListener(listener);
        boutonTaille4.addActionListener(listener);
        boutonRetour.addActionListener(listener);

    }

}