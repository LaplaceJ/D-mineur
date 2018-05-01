package Demineur;

import java.util.Scanner;

public class main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IsNotNumeric, IsOutLimit {

        int cptClick = 0;

        Model toto = new Model();
        toto.setTailleX("8");
        toto.setTailleY("8");
        toto.setNbBombe("4");
        toto.setTabJeu();

        System.out.println(toto);

        int x, y, choix;
        boolean allow = true;

        while (!toto.estGagner() && allow) {

            System.out.println("taper 1 pour cliquer // taper 2 pour ajouter drapeau ");
            choix = input.nextInt();
            cptClick++;
            System.out.println(cptClick);
            System.out.println("entrer X");
            x = input.nextInt();
            System.out.println("entrer Y");
            y = input.nextInt();
            if (cptClick == 1){
                toto.generationJeu(x, y);
            }
            System.out.println(toto);
            switch (choix) {
                case 1:
                    if (toto.decouvreCell(x, y)) {
                        System.out.println("tour suivant");
                    } else {
                        allow = false;
                    }
                    break ;
                case 2 :
                    toto.cliqueDrapeau(x,y);
                    break;
                case 3 :
                    if (toto.cliqueCaseDecouverte(x,y)) {
                        System.out.println("tour suivant");
                    }
                    else {
                        allow = false;
                    }
            }
            System.out.println(toto);

        }
        if (allow) {
            System.out.println("GAGNER");
        } else {
            System.out.println("PERDU");
        }

    }
}
