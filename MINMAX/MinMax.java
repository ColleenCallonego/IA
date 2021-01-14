package MINMAX;

import GenerationArbre.Tree;

public class MinMax {
    public static String IAPlay(String init){
        Tree arbre = new Tree(init, 0);
        arbre = Tree.CreateTree(arbre, 0);
        MinMax.Valuation(arbre);
        MinMax.UpValue(arbre);
        String fin;
        //si le premier fils est pas bon
        if (arbre.sons.get(0).score != -1){
            fin = arbre.sons.get(0).sticks; //on le prend par mesure de precaution
            int i = 1;
            while (i < arbre.sons.size() && fin == arbre.sons.get(0).sticks){ //on cherche dans le reste de la liste de fils
                if (arbre.sons.get(i).score == -1){ //on le prend si on le trouve
                    fin = arbre.sons.get(i).sticks;
                }
            }
        }
        else{
            fin = arbre.sons.get(0).sticks;
        }
        return fin;
    }



    public static void UpValue(Tree a) {
        //Vérification d'être dans un noeud dont tous les fils ont un score
        if (a.score == null) {
            for (Tree sons : a.sons) {
                MinMax.UpValue(sons);
            }
            //On monte la valeur du score au niveau du noeud en fonction de Min (niveaux paires) et Max (niveaux impaires)
            //Cas Impaire pour le MAX
            if (a.level % 2 != 0) {
                int up = -1;
                int i = 0;
                //si on trouve un fils dont le score est 1 on arrete et on remonte la valeur 1 sinon c'est -1
                while (up != 1 && i < a.sons.size()) {
                    if (a.sons.get(i).score == 1) {
                        up = 1;
                    }
                    i++;
                }
                a.score = up;
            }
            //Cas Paire pour le MIN
            if (a.level % 2 == 0) {
                int up = 1;
                int i = 0;
                //si on trouve un fils dont le score est -1 on arrete et on remonte la valeur -1 sinon c'est 1
                while (up != -1 && i < a.sons.size()) {
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
        System.out.println(a.sticks);
        if ( !a.sons.isEmpty() && a.sons.get(0) != null) {
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
                if (!c.equals('|')) {
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
            //ajustement du string BiSom1
            if(BiSom1.length()==1){
                BiSom1 = "00" + BiSom1;
            }
            if(BiSom1.length()==2){
                BiSom1 = "0" + BiSom1;
            }
            //ajustement du string BiSom2
            if(BiSom2.length()==1){
                BiSom2 = "00" + BiSom2;
            }
            if(BiSom2.length()==2){
                BiSom2 = "0" + BiSom2;
            }
            //ajustement du string BiSom3
            if(BiSom3.length()==1){
                BiSom3 = "00" + BiSom3;
            }
            if(BiSom3.length()==2){
                BiSom3 = "0" + BiSom3;
            }
            //ajustement du string BiSom4
            if(BiSom4.length()==1){
                BiSom4 = "00" + BiSom4;
            }
            if(BiSom4.length()==2){
                BiSom4 = "0" + BiSom4;
            }
            //faire la somme de chaque colonne des binaire
            int num1 = Integer.parseInt(String.valueOf(BiSom1.charAt(0))) + Integer.parseInt(String.valueOf(BiSom2.charAt(0))) + Integer.parseInt(String.valueOf(BiSom3.charAt(0))) + Integer.parseInt(String.valueOf(BiSom4.charAt(0)));
            int num2 = Integer.parseInt(String.valueOf(BiSom1.charAt(1))) + Integer.parseInt(String.valueOf(BiSom2.charAt(1))) + Integer.parseInt(String.valueOf(BiSom3.charAt(1))) + Integer.parseInt(String.valueOf(BiSom4.charAt(1)));
            int num3 = Integer.parseInt(String.valueOf(BiSom1.charAt(2))) + Integer.parseInt(String.valueOf(BiSom2.charAt(2))) + Integer.parseInt(String.valueOf(BiSom3.charAt(2))) + Integer.parseInt(String.valueOf(BiSom4.charAt(2)));
            //possible ajustement a faire sur la valuation des feuilles
            if(num1 != 0 || num2 != 0){
                if (num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 == 0) { //si les chiffres sont paires, alors score = -1
                    a.score = -1;
                }
                else {//si les chiffres sont impaires alors score = 1 (ou bien on met score = 1 dans tous les cas où on a pas pu mettre score = -1)
                    a.score = 1;
                }
            }
            if (num1 == 0 && num2 == 0){
                if (num3 == 3 || num3 == 1){ //si la somme donne 1 ou 3, alors score = -1
                    a.score = -1;
                }
                else if (num3 == 4 || num3 == 2){
                    a.score = 1;
                }
            }
            if (num1 + num2 + num3 == 0){
                if (a.level == 2){
                    a.score = -1;
                }
                else{
                    a.score = 1;
                }
            }
        }
    }
}