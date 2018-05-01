package Demineur;

import javax.swing.*; // Pour les composants graphiques que l'on ajoutera dans la méthode creerWidget
import java.awt.*;    // Pour la JFrame
import java.awt.event.*;

public class VueMenuDemineur extends JFrame {

    protected JPanel panelPano = new JPanel();
    protected JPanel panelClassique = new JPanel();
    protected JPanel panelDark = new JPanel();
    protected JPanel panelPrintemps = new JPanel();
    protected JPanel panelWindowns = new JPanel();
    protected JPanel panelBouton = new JPanel(new GridLayout(4, 1, 2, 10));
    protected JPanel panelTitre = new JPanel();
    protected JButton boutonClassique = new JButton(new ImageIcon("Image_Choix_Theme/ThemeClassique.png"));
    protected JButton boutonDark = new JButton(new ImageIcon("Image_Choix_Theme/ThemeDark.png"));
    protected JButton boutonPrintemps = new JButton(new ImageIcon("Image_Choix_Theme/ThemePrintemps.png"));
    protected JButton boutonWindows = new JButton(new ImageIcon("Image_Choix_Theme/ThemeWindows.png"));
    protected JLabel t = new JLabel(new ImageIcon("DemineurTitre.png"));
    protected Font f = new Font("Serif", Font.PLAIN, 30);
    protected ImageIcon img = new ImageIcon("LogoFenetre.png");

    public VueMenuDemineur() {

        setSize(400,590);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Démineur");
        setIconImage(img.getImage());
        creerWidget();


    }

    public void creerWidget() {

        t.setFont(f);

        boutonClassique.setPreferredSize(new Dimension(360, 100));
        boutonDark.setPreferredSize(new Dimension(360, 100));
        boutonPrintemps.setPreferredSize(new Dimension(360, 100));
        boutonWindows.setPreferredSize(new Dimension(360, 100));


        panelTitre.add(t);
        panelPano.add(panelTitre);
        panelClassique.add(boutonClassique);
        panelDark.add(boutonDark);
        panelPrintemps.add(boutonPrintemps);
        panelWindowns.add(boutonWindows);
        panelBouton.add(boutonClassique);
        panelBouton.add(boutonDark);
        panelBouton.add(boutonPrintemps);
        panelBouton.add(boutonWindows);
        panelPano.add(panelBouton);

        setContentPane(panelPano);

    }

    public void setButtonControler(ActionListener listener) {

        boutonClassique.addActionListener(listener);
        boutonDark.addActionListener(listener);
        boutonPrintemps.addActionListener(listener);
        boutonWindows.addActionListener(listener);

    }

}