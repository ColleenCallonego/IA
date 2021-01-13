import java.util.ArrayList;

public class Node {
    static ArrayList<String> allConfigs = new ArrayList<>();
    static ArrayList<Node> allNodes = new ArrayList<>();
    String config;
    ArrayList<Node> parents = new ArrayList<Node>();
    ArrayList<Node> children = new ArrayList<Node>();
    static ArrayList<Node> winningNodes = new ArrayList<Node>();
    public String evenW;
    public String oddW;

    public static void calculateWinningNodes(){
        for (Node n:allNodes) {
            if(n.isWinningNode()){
                winningNodes.add(n);
            }
        }
    }
    public boolean isWinningNode(){
        if (children.contains(allNodes.get(allConfigs.indexOf("111"))) ){
            return true;
        }
        return false;
    }
    public static Node deepCopy(Node originalNode) {
        Node n = new Node(originalNode.config);
        for (Node child : originalNode.children) {
            n.children.add(deepCopy(child));
        }
        return n;
    }

    public int sticksLeft(){
        int result=0;
        for (int i = 0; i < config.length(); i++) {
            result+=Integer.parseInt(config.substring(i,i+1));
        }
        return result;
    }

    public String calculateNextMove() {
        String nextMove = "";

        return nextMove;
    }

    public void calculateNodeVictoryPotential(int n) {
        boolean even = n % 2 == 0;
        if (config.equals("1")) {
            if (even) {
                evenW = "player";
                oddW = "AI";
            } else {
                evenW = "AI";
                oddW = "player";
            }
        } else {
            int nbWinningPaths = 0;
            for (Node child : children) {
                child.calculateNodeVictoryPotential(n + 1);
                if (even) {
                    if (child.evenW.equals("AI")) {
                        nbWinningPaths++;
                    }
                } else {
                    if (child.oddW.equals("AI")) {
                        nbWinningPaths++;
                    }
                }
            }
            if (even) {
                if (nbWinningPaths == children.size()) {
                    evenW = "AI";
                    oddW = "player";
                } else {
                    evenW = "player";
                    oddW = "AI";
                }
            } else {
                if (nbWinningPaths > 0) {
                    oddW = "AI";
                    evenW = "player";
                } else {
                    oddW = "player";
                    evenW = "AI";
                }

            }
        }

    }

    public Node(String configuration) {
        config = configuration;
    }

    public void addChild(Node n) {
        children.add(n);
        n.addParent(this);
    }

    public void addParent(Node n) {
        parents.add(n);
    }

    @Override
    public String toString() {
        String str = children.isEmpty() ? config : config + "(";
        for (Node n : children) {
            str += " " + n.config;
        }
        return children.isEmpty() ? str : str + " )";
    }

    public void calculateChildren() {

        int b;
        int n;
        String str;
        if (!config.equals("1")) {
            for (int i = 0; i < config.length(); i++) {
                n = Integer.parseInt(config.substring(i, i + 1));
                for (int x = 1; x < n + 1; x++) {
                    for (int a = 0; a < (n - x) / 2 + 1; a++) {
                        b = n - x - a;
                        str = String.valueOf(a) + String.valueOf(b);
                        str = str.replace("0", "");
                        str = (i > 0 ? config.substring(0, i) : "") + str + (i < config.length() - 1 ? config.substring(i + 1) : "");
                        if (!str.equals("")) {


                            if (!allConfigs.contains(str)) {

                                Node child = new Node(str);
                                addChild(child);
                                allConfigs.add(str);
                                allNodes.add(child);
                                child.calculateChildren();


                            } else {
                                int j = allConfigs.indexOf(str);
                                addChild(allNodes.get(j));


                            }
                        }
                    }
                }
            }
        }
    }
}
