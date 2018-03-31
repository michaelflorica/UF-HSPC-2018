import java.util.*;

public class Link {

    public static void printArray(String[] command){
        for(int i = 0; i < command.length; i++){
            System.out.print(command[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T --> 0){
            HashSet<String> files = new HashSet<String>();
            ArrayList<TreeSet<String>> fileSets = new ArrayList<TreeSet<String>>();
            Map<String, Integer> fileToNode = new HashMap<String,Integer>();
            PriorityQueue<Integer> emptyI = new PriorityQueue<Integer>();

            int C = sc.nextInt();
            //consume newline character
            sc.nextLine();

            for(int c = 0; c < C; c++){

                //read command and tokenize it
                String[] tokens = sc.nextLine().split(" ");

                //if command is touch
                if(tokens[0].equals("touch") && !files.contains(tokens[1])){
                    //printArray(tokens);
                    //if there exists a node that has been previously created to point to files
                    //get the smallest one in existence (priority queue handles this)
                    //otherwise we will be adding a new I node to the fileSets at fileSets.size()
                    int iNODE = !emptyI.isEmpty() ? emptyI.poll() : fileSets.size();

                    //if the I node we will be "attaching" files to is at fileSets.size(), we have to create it
                    if(iNODE == fileSets.size()){
                        fileSets.add(iNODE, new TreeSet<String>());
                    }

                    //add the file name to the I node
                    fileSets.get(iNODE).add(tokens[1]);

                    //add the file name to the unique files set
                    files.add(tokens[1]);

                    //and map the file name to I in case we have to link this file
                    fileToNode.put(tokens[1], iNODE);

                }
                else if(tokens[0].equals("link") && files.contains(tokens[1]) && !files.contains(tokens[2])){
                    //printArray(tokens);
                    //get the I node of the file that we are linking and add another file at same node
                    fileSets.get(fileToNode.get(tokens[1])).add(tokens[2]);

                    //map the new file name to I in case we have to link this new file
                    fileToNode.put(tokens[2], fileToNode.get(tokens[1]));

                    //add the file name to the unique files set
                    files.add(tokens[2]);
                }
                else if(tokens[0].equals("rm") && files.contains(tokens[1])){
                    //printArray(tokens);
                    //if we are removing the last file for an I node then store that I node in the priority queue
                    //so that whenever touch is called again, we will be storing that file at the I node and not just create another one
                    //since there is already an empty I node
                    if(fileSets.get(fileToNode.get(tokens[1])).size() == 1){
                        emptyI.add(fileToNode.get(tokens[1]));
                    }

                    //finally remove the file from the I node
                    fileSets.get(fileToNode.get(tokens[1])).remove(tokens[1]);

                    //and remove the file from the mapping of files to I nodes
                    fileToNode.remove(tokens[1]);

                    //and remove the file from the files set
                    files.remove(tokens[1]);

                }
            }


            //print output
            for(int i = 0; i < fileSets.size(); i++){
                //for all I nodes
                TreeSet<String> fileSet = fileSets.get(i);

                //print Node i:
                System.out.print("Node " + i + ":");
                for(String file : fileSet){
                    //and finally all files of that i node
                    System.out.print(" " + file);
                }
                System.out.println("");
            }
            if(T != 0){
                System.out.println();
            }
        }
    }
}
