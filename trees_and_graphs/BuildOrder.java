package trees_and_graphs;

import java.util.*;


class StringManager {
    StringBuilder order = new StringBuilder();
    
    public void addProject(Character project) {
        order.append(project);
        order.append(',');
        order.append(' ');
    }

    public String toString() {
        return new String(this.order);
    }

}

public class BuildOrder {
    int workingNode;

    public static void main(String[] args) {
        //Create graph

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Graph graph = new Graph();
        graph.generateGraph(line);
        ArrayList<Project> noDependencyProjects = nodesWithNoDependencies(graph);
        StringManager result = new StringManager();

        for (Project node : noDependencyProjects) {
            result.addProject(node.name);
        }

        int workingNodes = updateDependencyList(noDependencyProjects, 0, result);
        System.out.println(result.toString());
    }

    public static int updateDependencyList(ArrayList<Project> nodesWithNoDependency, int workingPointer, StringManager result) {
        int arraySize = nodesWithNoDependency.size();
        for (int i = workingPointer; i!=arraySize; i++) {
            //Integrate string manager.
            Project workingNode = nodesWithNoDependency.get(i);
            for (Project childNode : workingNode.children) {
                childNode.decerementDependencies();

                if (childNode.getDependencies() == 0) {
                    result.addProject(childNode.name);
                    nodesWithNoDependency.add(childNode);
                    arraySize++;
                }
            }
            workingPointer++;
        }
        return workingPointer;
    }


    public static ArrayList<Project> nodesWithNoDependencies(Graph graph) {
        HashMap<Character, Project> nodes = graph.getNodes();
        ArrayList<Project> results = new ArrayList<>();

        for (Project project : nodes.values()) {
            if (project.getDependencies() == 0) {
                results.add(project);
            }
        }

        return results;
    }


}

class Graph {
    HashMap<Character,Project> nodes = new HashMap<>();

    //Ensures unique keys
    public Project addNode(Character newNode) {
        Project result = null;
        if (nodes.containsKey(newNode)) {
            result = nodes.get(newNode);
        }
        else {
            result = new Project(newNode);
            nodes.put(newNode,result);
        }
        return result;
    }

    public Graph generateGraph(String input) {
        char[] inputArr = input.toCharArray();

        //(a,d) (a,c) ...
        for (int i = 1; i<inputArr.length; i+=6) {
            Character parent = inputArr[i];
            Character child = inputArr[i+2];

            Project parentNode = addNode(parent);
            Project childNode = addNode(child);
            
            childNode.incrementDependencies();
            parentNode.addChild(childNode);
        }
        return  this;
    }

    public HashMap<Character, Project> getNodes() {return this.nodes;}

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


