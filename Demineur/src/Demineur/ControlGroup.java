package Demineur;

public class ControlGroup {

    private Model model;

    private VueMenuDemineur vueMenuDemineur;
    private VueMenuChoixTaille vueMenuChoixTaille;
    private VueMenuChoixPersonnalise vueMenuChoixPersonnalise;
    private VueJeu vueJeu;

    private ControlMenuDemineur controlMenuDemineur;
    private ControlMenuChoixTaille controlMenuChoixTaille;
    private ControlChoixPersonnalise controlChoixPersonnalise;
    private ControlButtonJeu controlButtonJeu;

    public ControlGroup(Model model){

        this.model = model;

        vueMenuDemineur = new VueMenuDemineur();
        vueMenuDemineur.setVisible(true);

        vueMenuChoixTaille = new VueMenuChoixTaille(model);
        vueMenuChoixPersonnalise = new VueMenuChoixPersonnalise(model);
        vueJeu = new VueJeu(model);

        controlMenuDemineur = new ControlMenuDemineur(model, vueMenuDemineur, vueMenuChoixTaille);
        controlMenuChoixTaille = new ControlMenuChoixTaille(model, vueMenuChoixTaille, vueMenuChoixPersonnalise);
        controlButtonJeu = new ControlButtonJeu(model, vueJeu);

    }

}
