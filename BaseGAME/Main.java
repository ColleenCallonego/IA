package BaseGAME;

import GenerationArbre.Tree;
import MINMAX.MinMax;

public class Main {
    public static void main(String[] args) {

        //Game.menu();



        Tree arbre = new Tree("1|3|5|7", 0);
        arbre = Tree.CreateTree(arbre, 0);
        //MinMax.Valuation(arbre);
        //MinMax.UpValue(arbre);
        //Game.play2P();
    }
}
