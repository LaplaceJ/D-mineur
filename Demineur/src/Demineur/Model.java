package Demineur;

public class Model {

    private Cell[][] tabJeu = null;
    //private boolean[][] estDecouvert;
    //private boolean[][] estDrapeau;
    private int nbaDecouvrir;
    private int tailleX;
    private int tailleY;
    private int nbBombe;
    private boolean start = false;
    private int theme;

    public Model() {
        theme = 1;
    }

    /**
     * permet de connaitre le thème
     * @param theme
     */
    public void setTheme(int theme){
        this.theme = theme;
    }

    /**
     * Retourne le theme sius forme d'entier
     * 1 correspond au mode classique
     * 2 correspond au mode dark
     * 3 correspond au mode printemps
     * 4 correspond au mode windows
     * @return theme
     */
    public int getTheme(){
        return theme;
    }

    /**
     * renvoi le nombre de mine restante
     * @return nbaDecouvrir
     */
    public int getNbaDecouvrir(){
        return nbaDecouvrir;
    }

    /**
     * Modifier le nombre demine à découvrir
     * @param nbaDecouvrir
     */
    public void setNbaDecouvrir(int nbaDecouvrir) {
        this.nbaDecouvrir = nbaDecouvrir;
    }

    /**
     * donne la largeur du tableau
     * @return tailleX
     */
    public int getTailleX() {
        return tailleX;
    }

    /**
     * Vérifie si la largeur est conforme
     * Sert surtout lors du paramétrage du jeu par l'utilisateur pour vérifier qu'il indique bien un nombre entre 4 et 50
     * @param tailleX
     */
    public void setTailleX(String tailleX) throws IsNotNumeric, IsOutLimit{
        if (!tailleX.matches("^[0-9]*$")){
            throw  new IsNotNumeric(tailleX);
        }
        else {
            int x = Integer.parseInt(tailleX);
            if (x < 4 || x > 50){
                throw new IsOutLimit(x);
            }
            else {
                this.tailleX = x;
            }
        }
    }

    /**
     * donne la hauteur du tableau
     * @return tailleY
     */
    public int getTailleY() {
        return tailleY;
    }

    /**
     * Vérifie si la hauteur est conforme
     * Sert surtout lors du paramétrage du jeu par l'utilisateur pour vérifier qu'il indique bien un nombre entre 4 et 50
     * @param tailleY
     */
    public void setTailleY(String tailleY) throws IsNotNumeric, IsOutLimit{
        if (!tailleY.matches("^[0-9]*$")){
            throw  new IsNotNumeric(tailleY);
        }
        else {
            int y = Integer.parseInt(tailleY);
            if (y < 4 || y > 50){
                throw new IsOutLimit(y);
            }
            else {
                this.tailleY = y;
            }
        }
    }

    /**
     * donne le nombre de mine dans le  tableau
     * @return nbBombe
     */
    public int getNbBombe() {
        return nbBombe;
    }

    /**
     * Vérifie si le nombre de bombe est conforme
     * Sert surtout lors du paramétrage du jeu par l'utilisateur pour vérifier qu'il indique bien un nombre entre 4 et 50
     * @param nbBombe
     */
    public void setNbBombe(String nbBombe) throws  IsNotNumeric, IsOutLimit{
        if (!nbBombe.matches("^[0-9]*$")){
            throw  new IsNotNumeric(nbBombe);
        }
        else {
            int z = Integer.parseInt(nbBombe);
            if (z < 1 || z > ((tailleX * tailleY) / 2)){
                throw new IsOutLimit(z);
            }
            else {
                this.nbBombe = z;
            }
        }
    }

    /**
     * donne le tableau de jeu
     * @return tabJeu
     */
    public Cell[][] getTabJeu() { return tabJeu; }

    /**
     * initialise les tableau de jeu
     * Il faut faire ca au début de chaque nouvelle partie
     */
    public void setTabJeu() {
        //estDecouvert = new boolean[tailleX + 2][tailleY + 2];
        //estDrapeau = new boolean[tailleX + 2][tailleY + 2];
        tabJeu = new Cell[tailleX + 2][tailleY + 2];
        for (int i = 0; i < tailleX + 2; i++) {
            for (int j = 0; j < tailleY + 2; j++) {
                //estDrapeau[i][j] = false ;
                //estDecouvert[i][j] = false;
                tabJeu[i][j] = new Cell();
                if (i == 0 || j == 0 || j == tailleY + 1 || i == tailleX + 1) {
                    tabJeu[i][j].setEstUnBord(true);
                }
            }
        }
        nbaDecouvrir = nbBombe;
    }

    /**
     * génére le jeu
     * à faire un début de partie au 1er clique
     * @param x = position en x de la case cliquée
     * @param y = position en y de la case cliquée
     */
    public void generationJeu(int x, int y) {

        System.out.println("ModelGenerationX = " + (x+1) + " ModelGenerationY = " + (y+1));

        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {

                //if (!tabJeu[i][j].isEstUnBord())

                tabJeu[i][j].setAccepteMine(false);

            }
        }
        int somme = 0;
        int tempX = 0;
        int tempY = 0;
        while (somme < nbBombe) {
            tempX = random(tailleX);
            tempY = random(tailleY);
            if (tabJeu[tempX][tempY].isAccepteMine()) {
                tabJeu[tempX][tempY].setEstUneMine(true);
                somme++;
            }
        }
        for (int k = 1; k < tailleX + 1; k++) {
            for (int l = 1; l < tailleY + 1; l++) {

                for (int m = k - 1; m < k + 2; m++) {
                    for (int n = l - 1; n < l + 2; n++) {
                        if (!(tabJeu[m][n].isEstUnBord()) && tabJeu[m][n].isEstUneMine()) {
                            tabJeu[k][l].setNbMineAutour();
                        }
                    }
                }

            }
        }

        start = true;
        decouvreCell(x, y);

    }

    /**
     * utilise en fonction la méthode clique case découverte ou découvre cell
     * méthode a utiliser a chaque clique gauche (quand on veut découvrir des cases )
     * @param x = position en x de la case cliquée
     * @param y = position en y de la case cliquée
     */
    public boolean receptionClique(int x , int y){

        System.out.println("ModelReceptionX = " + x + " ModelRecptionY = " + y);

        boolean decouvre;

        if (tabJeu[x][y].isDrapeau()){
            return true ;
        }

        if (tabJeu[x][y].isDecouvert()){
            decouvre = cliqueCaseDecouverte(x,y);
        }else{
            decouvre = decouvreCell(x,y);
        }

        return decouvre;

    }

    /**
     * decouvre une cellule
     * à faire sur une cellule qui n'a pas encore été decouverte
     * @param x = position en x de la case cliquée
     * @param y = position en y de la case cliquée
     */
    public boolean decouvreCell(int x, int y) {
        if (!tabJeu[x][y].isDecouvert()) {
            tabJeu[x][y].setDecouvert(true);
            tabJeu[x][y].setDrapeau(false);
            if (tabJeu[x][y].isEstUneMine()){
                return false;
            }
            if (tabJeu[x][y].getNbMineAutour() == 0) {
                for (int i = x - 1; i < x + 2; i++) {
                    for (int j = y - 1; j < y + 2; j++) {
                        if (!tabJeu[i][j].isEstUnBord()) {
                            decouvreCell(i, j);
                        }
                    }
                }

            }
        }
        return true;
    }

    /**
     * clique sur une case qui est déja découverte
     *  par rapport aux nombres de drapeau autour de la case , les case sont découverte
     * @param x = position en x de la case cliquée
     * @param y = position en y de la case cliquée
     */
    public boolean cliqueCaseDecouverte(int x, int y) {

        int nbDrapeauAutour = 0;
        boolean pasPerdu = true;

        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (tabJeu[i][j].isDrapeau()) {
                    nbDrapeauAutour++;
                }
            }
        }

        if (nbDrapeauAutour == tabJeu[x][y].getNbMineAutour()) {
            for (int k = x - 1; k < x + 2; k++) {
                for (int l = y - 1; l < y + 2; l++) {
                    if (tabJeu[k][l].isEstUnBord()) {

                    }
                    else {
                        if (!tabJeu[k][l].isDrapeau()) {
                            pasPerdu = decouvreCell(k, l);
                        }
                        if (!pasPerdu) return false;
                    }
                }
            }
        }

        return true;

    }

    /**
     * ajoute un drapeau
     * mettre un drapeau sur une case qui n'est pas encore découverte
     * @param x = position en x de la case cliquée
     * @param y = position en y de la case cliquée
     */
    public void cliqueDrapeau(int x, int y) {

        System.out.println("ModelDrapeauX = " + x + " ModelDrapeauY = " + y);

        if (!tabJeu[x][y].isDecouvert()){

            tabJeu[x][y].setDrapeau(!tabJeu[x][y].isDrapeau());

            if (tabJeu[x][y].isDrapeau()) {
                nbaDecouvrir--;
            } else {
                nbaDecouvrir++;
            }

            System.out.println("Nombre à découvrir model : " + nbaDecouvrir);

        }

    }

    public String toString() {

        String temp = " voici l'état actuel \n";

        for (int i = 0; i < tailleX + 2; i++) {
            for (int j = 0; j < tailleY + 2; j++) {
                // temp = temp + tabJeu[i][j].toString();
                if (tabJeu[i][j].isDecouvert()) {
                    if (tabJeu[i][j].isEstUneMine()) {
                        temp = temp + "M";
                    }
                    else {
                        temp = temp + tabJeu[i][j].toString();
                    }
                }
                else{
                    if (tabJeu[i][j].isDrapeau()){
                        temp=temp + "D";
                    }
                    else{
                        temp=temp + "p";
                    }
                }
                temp = temp + "\t";

            }
            temp = temp + "\n";
        }

        return temp;

    }

    /**
     * Permet de savoir quna on gagne
     * @return
     */
    public boolean estGagner(){

        int countEstGagner = 0 ;

        for (int i = 1; i < tailleX + 1; i++) {
            for (int j = 1; j < tailleY + 1; j++) {
                if (!tabJeu[i][j].isDecouvert()){
                    countEstGagner++ ;
                }
            }
        }

        return countEstGagner == nbBombe ;

    }


    private int random(int max) {
        return (int) (Math.random() * (max)) + 1;
    }

    public boolean isStart(){
        return start;
    }

}

/**
 * Class d'exception qui s'active lorsque l'utilisateur rentre autre chose qu'un nombre pour choisir
 * la hauteur, la largeur ou le nombre de mines lorsqu'il parametre le jeu lui-même.
 */
class IsNotNumeric extends Exception{

    IsNotNumeric(String valeur){

        super(
                valeur + " n'est pas une valeur conforme changer et mettre un nombre"
        );

    }

}

/**
 * Class d'exception qui s'active lorsque l'utilisateur rentre un nombre top grand pour la hauteur, la largeur, le nombre de mine
 * lorqu'il parametre le jeu lui-même.
 */
class IsOutLimit extends Exception{

    IsOutLimit(int valeur){

        super(
                valeur + " est soit trop grand ou trop petit pour que le jeu puisse être autorisé."
        );

    }

}

/**
 * Class d'exception qui s'active lorsque l'utilisareur note pas  son pseudo
 * Sert lors de la victoire
 */
class IsNotName extends Exception{

    IsNotName(){

        super("Oubli du pseudo");

    }

}

/**
 * Class d'exception qui s'active lorsque l'utilisareur note son pseudo et que ce dernier n'est pas conforme
 * Sert lors de la victoire
 */
class IsNotGoodName extends Exception{

    IsNotGoodName(String valeur){

        super(
                valeur + " ne respecte pas le format de pseudo, il faut qu'il soit composé que de 2 à 10 lettres" +
                        " de a à z en majuscule ou minuscule"
        );

    }

}
