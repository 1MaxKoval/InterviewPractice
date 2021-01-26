package trees_and_graphs;

import java.util.*;

public class BuildOrder {

    public void main(String[] args) {
        //Create graph

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
    }


}

class Graph {
    HashMap<Character,Project> nodes = new HashMap<>();


    public Graph generateGraph(String input) {
        char[] inputArr = input.toCharArray();

        //(a,d) (a,c) ...
        for (int i = 1; i!=inputArr.length; i+=5) {
            Character parent = inputArr[i];
            Character child = inputArr[i+2];

            Project parentNode;
            Project childNode;

            if (nodes.containsKey(parent)) {
                parentNode = nodes.get(parent);
            }
            else {
                parentNode = new Project(parent);
                nodes.put(parent, parentNode);
            }

            if (nodes.containsKey(child)) {
                childNode = nodes.get(child);
            }
            else {
                childNode = new Project(child);
                nodes.put(child, childNode);
            }
            childNode.incrementDependencies();
            parentNode.addChild(childNode);
        }
        return  this;
    }



}


class Project {

    ArrayList<Project> children = new ArrayList<>();
    private int dependencies = 0; 
    Character name;

    public Project(Character name) {
        this.name = name;
    }

    public void addChild(Project child) {
        children.add(child);
    }

    public void incrementDependencies() {dependencies++;}

    public void decerementDependencies() {dependencies--;}

    public int getDependencies() {return dependencies;}
   

}


