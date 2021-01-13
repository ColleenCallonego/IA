public class Main {
    public static void main(String[] args) {
        Node node =new Node("1357");
        node.calculateChildren();
        Node.calculateWinningNodes();
        System.out.println("winning"+Node.winningNodes);



        //node.calculateNodeVictoryPotential(0);
        System.out.println(node);
        System.out.println(node.sticksLeft());
        //System.out.println(Node.allConfigs);
        //System.out.println(node.evenW+"|"+node.oddW);

        //System.out.println(Node.allNodes.get(7).parents.get(1).config);






    }
}
