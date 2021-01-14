package GenerationArbre;

import java.util.ArrayList;
import java.lang.StringBuilder;

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

   public static Tree CreateTree(Tree tree, Integer level){
       if (level == 4){
           return null;
       }
       else{
            System.out.println(tree.sticks);
            String st = tree.sticks;
            String s = "";
            Character c; 
            for (Integer i = 0; i < st.length(); i++){
                c = tree.sticks.charAt(i);
                if (c.equals('1')){
                     StringBuilder sb = new StringBuilder(st);
                     sb.deleteCharAt(i);
                     s = sb.toString();
                     if (s.equals("") && level%2 == 0){
                         tree.sons.add(new Tree(st, 1, level));
                     }
                     else if (s.equals("") && level%2 != 0){
                         tree.sons.add(new Tree(st, -1, level));
                     }
                     else{
                         tree.sons.add(CreateTree(new Tree(s, level), level + 1 ));
                     }
                }
                if (c.equals('2')){
                     StringBuilder sb = new StringBuilder(st);
                     sb.deleteCharAt(i);

                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "1").toString(), level), level + 1));
                     sb.deleteCharAt(i);

                     s = sb.toString();
                     if (s.equals("") && level%2 == 0){
                         tree.sons.add(new Tree(st, 1, level));
                     }
                     else if (s.equals("") && level%2 != 0){
                         tree.sons.add(new Tree(st, -1, level));
                     }
                     else{
                         tree.sons.add(CreateTree(new Tree(s, level), level + 1 ));
                     }
                }
                if (c.equals('3')){
                     StringBuilder sb = new StringBuilder(st);
                     sb.deleteCharAt(i);

                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "2").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "11").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "1").toString(), level), level + 1));
                     sb.deleteCharAt(i);

                     s = sb.toString();
                     if (s.equals("") && level%2 == 0){
                         tree.sons.add(new Tree(st, 1, level));
                     }
                     else if (s.equals("") && level%2 != 0){
                         tree.sons.add(new Tree(st, -1, level));
                     }
                     else{
                         tree.sons.add(CreateTree(new Tree(s, level), level + 1 ));
                     }
                }
                if (c.equals('4')){
                     StringBuilder sb = new StringBuilder(st);
                     sb.deleteCharAt(i);

                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "3").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "12").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "21").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "2").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "11").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "1").toString(), level), level + 1));
                     sb.deleteCharAt(i);

                     s = sb.toString();
                     if (s.equals("") && level%2 == 0){
                         tree.sons.add(new Tree(st, 1, level));
                     }
                     else if (s.equals("") && level%2 != 0){
                         tree.sons.add(new Tree(st, -1, level));
                     }
                     else{
                         tree.sons.add(CreateTree(new Tree(s, level), level + 1 ));
                     }
                }
                if (c.equals('5')){
                     StringBuilder sb = new StringBuilder(st);
                     sb.deleteCharAt(i);

                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "4").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "13").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "22").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "31").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "3").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "12").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "21").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "2").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "11").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "1").toString(), level), level + 1));
                     sb.deleteCharAt(i);

                     s = sb.toString();
                     if (s.equals("") && level%2 == 0){
                         tree.sons.add(new Tree(st, 1, level));
                     }
                     else if (s.equals("") && level%2 != 0){
                         tree.sons.add(new Tree(st, -1, level));
                     }
                     else{
                         tree.sons.add(CreateTree(new Tree(s, level), level + 1 ));
                     }
                }
                if (c.equals('6')){
                     StringBuilder sb = new StringBuilder(st);
                     sb.deleteCharAt(i);

                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "5").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "15").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "23").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "32").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "41").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "1").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "13").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "22").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "31").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "3").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "12").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "21").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "2").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "11").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "1").toString(), level), level + 1));
                     sb.deleteCharAt(i);

                     s = sb.toString();
                     if (s.equals("") && level%2 == 0){
                         tree.sons.add(new Tree(st, 1, level));
                     }
                     else if (s.equals("") && level%2 != 0){
                         tree.sons.add(new Tree(st, -1, level));
                     }
                     else{
                         tree.sons.add(CreateTree(new Tree(s, level), level + 1 ));
                     }
                }
                if (c.equals('7')){
                     StringBuilder sb = new StringBuilder(st);
                     sb.deleteCharAt(i);

                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "6").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "15").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "24").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "33").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "42").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "51").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "5").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "14").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "23").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "32").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "41").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "4").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "13").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "22").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "31").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "3").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "12").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "21").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "2").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "11").toString(), level), level + 1));
                     sb.deleteCharAt(i);
                     sb.deleteCharAt(i);
                     tree.sons.add(CreateTree(new Tree(sb.insert(i, "1").toString(), level), level + 1));
                     sb.deleteCharAt(i);

                     s = sb.toString();
                     if (s.equals("") && level%2 == 0){
                         tree.sons.add(new Tree(st, 1, level));
                     }
                     else if (s.equals("") && level%2 != 0){
                         tree.sons.add(new Tree(st, -1, level));
                     }
                     else{
                         tree.sons.add(CreateTree(new Tree(s, level), level + 1 ));
                     }
                }
            }
            return tree;
        }
   }
}
