import java.util.*;

public class LinkGary {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        test(s);
    }
    public static void test(Scanner s) {
        int cases = s.nextInt();
        for (int caseId = 0; caseId < cases; caseId++) {
            Map<String, Integer> nameToNode = new HashMap<String, Integer>();
            List<Set<String>> nodeList = new ArrayList<>();
            PriorityQueue<Integer> emptyNodes = new PriorityQueue<>();

            int n = s.nextInt(); // number of commands
            s.nextLine();
            for (int cmd = 0; cmd < n; cmd++) {
                String line = s.nextLine();
                // System.out.println(line);
                String[] tokens = line.split(" ");

                if (tokens[0].equals("touch")) {
                    String name = tokens[1];
                    Integer nodeID = nodeList.size();

                    Set<String> set = new HashSet<String>();

                    set.add(name);
                    if (emptyNodes.size() > 0) {
                        nodeID = emptyNodes.poll();
                        nodeList.set(nodeID, set);
                    } else {
                        nodeList.add(nodeID, set);
                    }

                    nameToNode.put(name, nodeID);
                }

                else if (tokens[0].equals("link")) {
                    Integer nodeID = nameToNode.get(tokens[1]);
                    nodeList.get(nodeID).add(tokens[2]);
                    nameToNode.put(tokens[2], nodeID);
                }

                else { // tokens[0] == rm
                    Integer nodeID = nameToNode.get(tokens[1]);
                    Set<String> set = nodeList.get(nodeID);
                    set.remove(tokens[1]);
                    if (set.size() == 0) {
                        emptyNodes.add(nodeID);
                    }
                }
            }
            print(nodeList);
            if(caseId != cases-1){
                System.out.println();
            }
        }
        s.close();
    }

    public static void print(List<Set<String>> nodeList) {
        int i = 0;
        for (Set<String> node : nodeList) {
            System.out.print("Node " + (i++) + ":");
            List<String> list = new ArrayList<>(node);
            Collections.sort(list);
            for (String name : list) {
                System.out.print(" " + name);
            }
            System.out.println("");
        }
    }
}
