import java.util.ArrayList;

public class Tree {

    public String sticks;
    public Integer score;
    public Integer level;
    public ArrayList<Tree> sons;

   public Tree (String sticks, Integer level){
       this.sticks = sticks;
       this.level = level;
       sons = new ArrayList<Tree>();
   }

   public Tree (String sticks, Integer score, Integer level){
       this.sticks = sticks;
       this.score = score;
       this.level = level;
       sons = new ArrayList<Tree>();
   }

   static Arbre CreateTree(){

   }
}