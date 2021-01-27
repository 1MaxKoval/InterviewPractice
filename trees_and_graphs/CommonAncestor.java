package trees_and_graphs;

public class CommonAncestor {

    //Time 
    // O(log(N)) //If no parent node is given then O(N)

    // Space
    // O(1) // If no parent node is given then O(log N)
    
    //10, 16, 28, 36, 46, 70, 80, 96
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

    //In the case the parent node cannot be accessed 
    //O(N) - time
    //O(log N) - space
    public int determineDepth(Node rootNode, Node searchNode) {
        if (rootNode == null) {
            return Integer.MIN_VALUE;
        }

        if (searchNode.val == rootNode.val) {
            return 0;
        }

        int left = determineDepth(rootNode.left, searchNode);
        int right = determineDepth(rootNode.right, searchNode);

        if (left != Integer.MIN_VALUE) {
            return left++;
        }
        else if (right != Integer.MIN_VALUE) {
            return right++;
        }
        else {
            return Integer.MIN_VALUE;
        }

    }


}


class Node {
    Node left = null;
    Node right = null;
    Node parent = null;
    int val;
}
