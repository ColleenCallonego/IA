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

   static Arbre CreateTree(Tree tree, Integer level){
       String st = tree.sticks;
       String s;
       String c; 
       for (Integer i = 0; i < st.lenght()){
           c = tree.sticks.charAt(i);
           if (c.equals("1")){
                StringBuilder sb = StringBuilder(st);
                sb.deleteCharAt(i);
                st = sb.toString();
                if (s.equals("") && n%2 == 0){
                    tree.sons.add(new Tree(st, 1, level));
                }
                else if (s.equals("") && n%2 != 0){
                    tree.sons.add(new Tree(st, -1, level));
                }
                else{
                    tree.sons.add(CreateTree(new Tree(s, level)), level + 1 );
                }
           }
       }
   }
}