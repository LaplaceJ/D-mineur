package Demineur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenuDemineur implements ActionListener{

    private Model model;

    private VueMenuDemineur vueMenuDemineur;
    private VueMenuChoixTaille vueMenuChoixTaille;
    private VueMenuChoixPersonnalise vueMenuChoixPersonnalise;
    private ControlMenuChoixTaille controlMenuChoixTaille;
    private boolean passageAutorise;

    private int choixTheme;

    public ControlMenuDemineur(Model model, VueMenuDemineur vueMenuDemineur, VueMenuChoixTaille vueMenuChoixTaille){

        this.model = model;

        this.vueMenuDemineur = vueMenuDemineur;
        this.vueMenuChoixTaille = vueMenuChoixTaille;

        this.vueMenuDemineur.setButtonControler(this);

        this.passageAutorise = false;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //traite quand on appuie sur un bouton de l'acceuil pour choisir le thème que l'on veut
        if(e.getSource() == vueMenuDemineur.boutonClassique){
            System.out.println("Classique");
            choixTheme = 1;
            passageAutorise = true;
        }
        if(e.getSource() == vueMenuDemineur.boutonDark){
            System.out.println("Dark");
            choixTheme = 2;
            passageAutorise = true;
        }
        if(e.getSource() == vueMenuDemineur.boutonPrintemps){
            System.out.println("Printemps");
            choixTheme = 3;
            passageAutorise = true;
        }
        if(e.getSource() == vueMenuDemineur.boutonWindows){
            System.out.println("Windows");
            choixTheme = 4;
            passageAutorise = true;
        }

        if (passageAutorise) {
            //envoie sur la page pour choisir la taille
            vueMenuDemineur.setVisible(false);
            model.setTheme(choixTheme);
            vueMenuChoixTaille = new VueMenuChoixTaille(model);
            vueMenuChoixTaille.setVisible(true);
            controlMenuChoixTaille = new ControlMenuChoixTaille(model, vueMenuChoixTaille, vueMenuChoixPersonnalise);
        }

    }
}
