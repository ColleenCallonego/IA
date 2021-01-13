public class MinMax {
    public static void UpValue(Tree a) {
        //Vérification d'être dans un noeud dont tous les fils ont un score
        if (a.score == null){
            for (Tree sons: a.sons) {
                MinMax.UpValue(sons);
            }
            //On monte la valeur du score au niveau du noeud en fonction de Min (niveaux impaires) et Max (niveaux paires)
            //Cas Paire pour le MAX
            if (a.level % 2 == 0){
                int up = -1;
                int i = 0;
                //si on trouve un fils dont le score est 1 on arrete et on remonte la valeur 1 sinon c'est -1
                while (up != 1 || i < a.sons.size()){
                    if (a.sons.get(i).score == 1){
                        up = 0;
                    }
                }
            }



        }

    }
}
