package Demineur;

public class Cell {

    private int nbMineAutour;
    private boolean estUneMine;
    private boolean accepteMine;
    private boolean estUnBord ;
    private boolean drapeau;
    private boolean decouvert ;

    public Cell() {
        nbMineAutour = 0 ;
        estUneMine = false ;
        accepteMine = true ;
        estUnBord =false ;
        drapeau = false;
        decouvert = false;
    }

    public boolean isEstUnBord() {
        return estUnBord;
    }

    public void setEstUnBord(boolean estUnBord) {
        this.estUnBord = estUnBord;
    }

    public void setNbMineAutour() {
        nbMineAutour ++;
    }

    public void setEstUneMine(boolean estUneMine) {
        this.estUneMine = estUneMine;
        accepteMine = false ;
    }

    public void setAccepteMine(boolean accepteMine) {
        this.accepteMine = accepteMine;
    }

    public int getNbMineAutour() {
        return nbMineAutour;
    }

    public boolean isEstUneMine() {
        return estUneMine;
    }

    public boolean isAccepteMine() {
        return accepteMine;
    }

    public boolean isDrapeau(){
        return drapeau;
    }

    public void setDrapeau(boolean drapeau) {
        this.drapeau = drapeau;
    }

    public boolean isDecouvert() {
        return decouvert;
    }

    public void setDecouvert(boolean decouvert) {
        this.decouvert = decouvert;
    }

    public String toString() {
        if (!estUnBord){
            if (estUneMine ){
                return "X";
            }else{
                return "" + nbMineAutour ;
            }
        }
        return "N" ;
    }

    @Override
    public boolean equals(Object obj) {
        return(obj.equals(null));

    }

}
