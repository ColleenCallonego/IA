package MINMAX;

import GenerationArbre.Tree;

public class MinMax {
    public static void UpValue(Tree a) {
        //Vérification d'être dans un noeud dont tous les fils ont un score
        if (a.score == null) {
            for (Tree sons : a.sons) {
                MinMax.UpValue(sons);
            }
            //On monte la valeur du score au niveau du noeud en fonction de Min (niveaux impaires) et Max (niveaux paires)
            //Cas Paire pour le MAX
            if (a.level % 2 == 0) {
                int up = -1;
                int i = 0;
                //si on trouve un fils dont le score est 1 on arrete et on remonte la valeur 1 sinon c'est -1
                while (up != 1 || i < a.sons.size()) {
                    if (a.sons.get(i).score == 1) {
                        up = 1;
                    }
                    i++;
                }
                a.score = up;
            }
            if (a.level % 2 != 0) {
                int up = 1;
                int i = 0;
                //si on trouve un fils dont le score est -1 on arrete et on remonte la valeur -1 sinon c'est 1
                while (up != -1 || i < a.sons.size()) {
                    if (a.sons.get(i).score == -1) {
                        up = -1;
                    }
                    i++;
                }
                a.score = up;
            }
        }
    }


    public static void Valuation(Tree a) {
        if (a.sons.get(0) != null || !a.sons.isEmpty()) {
            for (Tree sons : a.sons) {
                Valuation(sons);
            }
        }
        else {
            //Somme des allumettes dans chaque ligne
            int som1 = 0;
            int som2 = 0;
            int som3 = 0;
            int som4 = 0;
            int barre = 0;
            for (int i = 0; i < a.sticks.length(); i++) {
                Character c = a.sticks.charAt(i);
                if (!c.equals("|")) {
                    if (barre == 0) {
                        som1 += Integer.parseInt(String.valueOf(c));
                    }
                    else if (barre == 1) {
                        som2 += Integer.parseInt(String.valueOf(c));
                    }
                    else if (barre == 2) {
                        som3 += Integer.parseInt(String.valueOf(c));
                    }
                    else if (barre == 3) {
                        som4 += Integer.parseInt(String.valueOf(c));
                    }
                }
                else {
                    barre++;
                }
            }
            //convertir en binaire chaque somme de ligne
            String BiSom1 = Integer.toBinaryString(som1);
            String BiSom2 = Integer.toBinaryString(som2);
            String BiSom3 = Integer.toBinaryString(som3);
            String BiSom4 = Integer.toBinaryString(som4);
            //faire la somme de chaque colonne des binaire
            int num1 = Integer.parseInt(String.valueOf(BiSom1.charAt(0))) + Integer.parseInt(String.valueOf(BiSom2.charAt(0))) + Integer.parseInt(String.valueOf(BiSom3.charAt(0))) + Integer.parseInt(String.valueOf(BiSom4.charAt(0)));
            int num2 = Integer.parseInt(String.valueOf(BiSom1.charAt(1))) + Integer.parseInt(String.valueOf(BiSom2.charAt(1))) + Integer.parseInt(String.valueOf(BiSom3.charAt(1))) + Integer.parseInt(String.valueOf(BiSom4.charAt(1)));
            int num3 = Integer.parseInt(String.valueOf(BiSom1.charAt(2))) + Integer.parseInt(String.valueOf(BiSom2.charAt(2))) + Integer.parseInt(String.valueOf(BiSom3.charAt(2))) + Integer.parseInt(String.valueOf(BiSom4.charAt(2)));
            if ((num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 == 0) || num3 == 3 || num3 == 1) { //si les chiffres sont paires ou si la somme donne 1 ou 3, alors score = -1
                a.score = -1;
            }
            else {//si les chiffres sont impaires alors score = 1 (ou bien on met score = 1 dans tous les cas où on a pas pu mettre score = -1)
                a.score = 1;
            }
        }
    }
}