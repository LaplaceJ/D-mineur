package Demineur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlChoixPersonnalise implements ActionListener {

    private  Model model;

    private VueMenuChoixPersonnalise vueMenuChoixPersonnalise;
    private VueMenuChoixTaille vueMenuChoixTaille;
    private VueMenuDemineur vueMenuDemineur;
    private VueJeu vueJeu;

    private boolean errorManqueHauteur;
    private boolean errorIsNotNumericHauteur;
    private boolean errorIsOutLimitHauteur;
    private boolean errorManqueLargeur;
    private boolean errorIsNotNumericLargeur;
    private boolean errorIsOutLimitLargeur;
    private boolean errorManqueMine;
    private boolean errorIsNotNumericMine;
    private boolean errorIsOutLimitMine;

    private String txtHauteur, txtLargeur, txtNbrMine;

    private int cptCestBon;

    public ControlChoixPersonnalise(Model model, VueMenuChoixPersonnalise vueMenuChoixPersonnalise){

        this.model = model;

        this.vueMenuChoixPersonnalise = vueMenuChoixPersonnalise;

        this.vueMenuChoixPersonnalise.setButtonControler(this);

        cptCestBon = 0;

        errorManqueHauteur = false;
        errorIsNotNumericHauteur = false;
        errorIsOutLimitHauteur = false;
        errorManqueLargeur = false;
        errorIsNotNumericLargeur = false;
        errorIsOutLimitLargeur = false;
        errorManqueMine = false;
        errorIsNotNumericMine = false;
        errorIsOutLimitMine = false;

    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if (e.getSource() == vueMenuChoixPersonnalise.demarrer){

            System.out.println("Démarer");

            txtHauteur = vueMenuChoixPersonnalise.jtHauteur.getText();
            txtLargeur = vueMenuChoixPersonnalise.jtLargeur.getText();
            txtNbrMine = vueMenuChoixPersonnalise.jtPourcentMine.getText();

            if (txtHauteur.equals("")){
                errorManqueHauteur = true;
            }
            else{
                try {
                    model.setTailleX(txtHauteur);
                    cptCestBon++;
                } catch (IsNotNumeric isNotNumeric) {
                    errorIsNotNumericHauteur = true;
                } catch (IsOutLimit isOutLimit) {
                    errorIsOutLimitHauteur = true;
                }
            }

            if (txtLargeur.equals("")){
                errorManqueLargeur = true;
            }
            else{
                try {
                    model.setTailleY(txtLargeur);
                    cptCestBon++;
                } catch (IsNotNumeric isNotNumeric) {
                    errorIsNotNumericLargeur = true;
                } catch (IsOutLimit isOutLimit) {
                    errorIsOutLimitLargeur = true;
                }
            }

            if (txtNbrMine.equals("")){
                errorManqueMine = true;
            }
            else{
                try {
                    model.setNbBombe(txtNbrMine);
                    cptCestBon++;
                } catch (IsNotNumeric isNotNumeric) {
                    errorIsNotNumericMine = true;
                } catch (IsOutLimit isOutLimit) {
                    errorIsOutLimitMine = true;
                }
            }

            System.out.println("Hauteur : " + model.getTailleY());
            System.out.println("Largeur : " + model.getTailleX());
            System.out.println("Nombre de mine : " + model.getNbBombe());

            if (errorManqueHauteur){
                vueMenuChoixPersonnalise.afficheErreur1("Il manque la hauteur.");
                errorManqueHauteur = false;
                cptCestBon = 0;
            }
            if (errorIsNotNumericHauteur){
                vueMenuChoixPersonnalise.afficheErreur2("La hauteur n'est pas sous le bon format.");
                errorIsNotNumericHauteur = false;
                cptCestBon = 0;
            }
            if (errorIsOutLimitHauteur){
                vueMenuChoixPersonnalise.afficheErreur3("Le nombre choisit est soit trop grand soit trop petit.");
                errorIsOutLimitHauteur = false;
                cptCestBon = 0;
            }
            if (errorManqueLargeur){
                vueMenuChoixPersonnalise.afficheErreur1("Il manque la largeur.");
                errorManqueLargeur = false;
                cptCestBon = 0;
            }
            if (errorIsNotNumericLargeur){
                vueMenuChoixPersonnalise.afficheErreur2("La largeur n'est pas sous le bon format.");
                errorIsNotNumericLargeur = false;
                cptCestBon = 0;
            }
            if (errorIsOutLimitLargeur){
                vueMenuChoixPersonnalise.afficheErreur3("Le nombre choisit est soit trop grand soit trop petit.");
                errorIsOutLimitLargeur = false;
                cptCestBon = 0;
            }
            if (errorManqueMine){
                vueMenuChoixPersonnalise.afficheErreur1("Il manque le nombre de mine(s).");
                errorManqueMine = false;
                cptCestBon = 0;
            }
            if (errorIsNotNumericMine){
                vueMenuChoixPersonnalise.afficheErreur2("La hauteur n'est pas sous le bon format.");
                errorIsNotNumericMine = false;
                cptCestBon = 0;
            }
            if (errorIsOutLimitMine){
                vueMenuChoixPersonnalise.afficheErreur3("Le nombre de mine(s) ne doit pas excéder la moitié du nombre de case.");
                errorIsOutLimitMine = false;
                cptCestBon = 0;
            }

            if (cptCestBon == 3) {
                vueMenuChoixPersonnalise.setVisible(false);
                vueJeu = new VueJeu(model);
                vueJeu.setVisible(true);
                new ControlButtonJeu(model, vueJeu);
            }

            System.out.println("cptCestBon : " + cptCestBon);

        }

        if (e.getSource() == vueMenuChoixPersonnalise.annuler){

            System.out.println("Annuler");
            vueMenuChoixPersonnalise.setVisible(false);
            vueMenuChoixTaille = new VueMenuChoixTaille(model);
            vueMenuChoixTaille.setVisible(true);
            new ControlMenuChoixTaille(model, vueMenuChoixTaille, vueMenuChoixPersonnalise);

        }

    }
}
