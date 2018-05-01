package Demineur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenuChoixTaille implements ActionListener{

    private Model model;

    private VueMenuChoixTaille vueMenuChoixTaille;
    private VueMenuChoixPersonnalise vueMenuChoixPersonnalise;
    private VueMenuDemineur vueMenuDemineur;
    private VueJeu vueJeu;

    public ControlMenuChoixTaille(Model model, VueMenuChoixTaille vueMenuChoixTaille, VueMenuChoixPersonnalise vueMenuChoixPersonnalise){

        this.model = model;

        this.vueMenuChoixTaille = vueMenuChoixTaille;
        this.vueMenuChoixPersonnalise = vueMenuChoixPersonnalise;

        this.vueMenuChoixTaille.setButtonControler(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vueMenuChoixTaille.boutonTaille1){

            System.out.println("Bouton1");

            choixTaille("9", "9",  "10");

        }

        if (e.getSource() == vueMenuChoixTaille.boutonTaille2){

            System.out.println("Bouton2");

            choixTaille("16", "16",  "40");

        }

        if (e.getSource() == vueMenuChoixTaille.boutonTaille3){

            System.out.println("Bouton3");

            choixTaille("30", "16", "99");

        }

        if (e.getSource() == vueMenuChoixTaille.boutonTaille4){

            System.out.println("Bouton4");

            vueMenuChoixTaille.setVisible(false);
            vueMenuChoixPersonnalise = new VueMenuChoixPersonnalise(model);
            vueMenuChoixPersonnalise.setVisible(true);
            new ControlChoixPersonnalise(model, vueMenuChoixPersonnalise);

        }

        if (e.getSource() == vueMenuChoixTaille.boutonRetour){

            System.out.println("Retour");

            vueMenuChoixTaille.setVisible(false);
            vueMenuDemineur = new VueMenuDemineur();
            vueMenuDemineur.setVisible(true);
            new ControlMenuDemineur(model, vueMenuDemineur, vueMenuChoixTaille);

        }

        System.out.println("Hauteur : " + model.getTailleY());
        System.out.println("Largeur : " + model.getTailleX());
        System.out.println("Nombre de mine : " + model.getNbBombe());

    }

    public void choixTaille(String hauteur, String largeur ,String nbrMine){

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

        vueMenuChoixTaille.setVisible(false);
        vueJeu = new VueJeu(model);
        vueJeu.setVisible(true);
        new ControlButtonJeu(model, vueJeu);

    }

}
