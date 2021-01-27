package trees_and_graphs;

public class CommonAncestor {

    //Time 
    // O(log(N))

    // Space
    // O(1)
    public Node findCommonAncestor(Node node1, Node node2) {

        int depthNode1 = determineDepth(node1);
        int depthNode2 = determineDepth(node2);

        Node deeperNode = null;
        Node shallowNode = null;
        if (depthNode1 > depthNode2) {
            deeperNode = node1;
            shallowNode = node2;
        }
        else if (depthNode2 > depthNode2) {
            deeperNode = node2;
            shallowNode = node1;
        }

        if (deeperNode!= null && shallowNode != null) {
            int difference = Math.abs(depthNode1 - depthNode2);
            while(difference!=0) {
                shallowNode = shallowNode.parent;
                difference--;
            }
        }

        Node shallowsAncestor = shallowNode.parent;
        Node deepersAncestor = deeperNode.parent;

        while (shallowsAncestor!=deepersAncestor) {
            shallowsAncestor = shallowsAncestor.parent;
            deepersAncestor = deepersAncestor.parent;
        }

        return shallowsAncestor;

    }
    
    public int determineDepth(Node node) {
        Node parent = node.parent;
        int depth = 1;
        while (parent!=null) {
            parent = parent.parent;
            depth++;
        }
        return depth;
    }


}


class Node {
    Node left = null;
    Node right = null;
    Node parent = null;
}
