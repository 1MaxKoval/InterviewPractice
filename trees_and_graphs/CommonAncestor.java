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

    public Node findAncestor(Node root, Node node1, Node node2) {
        SubTreeInfo information = checkDescendants(root, node1, node2);
        return information.ancestor;
    }

    //In the case the parents of given nodes are uknown.
    //Time complexity - O(N)
    //Space complexigy - O(log N)
    public SubTreeInfo checkDescendants(Node current, Node node1, Node node2) {
        if (current == null) {
            SubTreeInfo information = new SubTreeInfo();
            information.node1 = false;
            information.node2 = false;
            return information;
        }

        SubTreeInfo left = checkDescendants(current.left, node1, node2);
        SubTreeInfo right = checkDescendants(current.right, node1, node2);

        SubTreeInfo mergedInfo = combinedInfo(left,right);
        
        if (current.val == node1.val) 
            mergedInfo.node1 = true;
        
        else if (current.val == node2.val)
            mergedInfo.node2 = true; 

        //Found ancestor
        if (mergedInfo.node1 && mergedInfo.node2 && mergedInfo.ancestor == null) {
            mergedInfo.ancestor = current;
            return mergedInfo;
        }

        return mergedInfo;
    }

    public SubTreeInfo combinedInfo(SubTreeInfo left, SubTreeInfo right) {
        SubTreeInfo mergedInfo = new SubTreeInfo();        

        if (left.ancestor != null) 
            return left;
        
        else if (right.ancestor != null) 
            return right;
        

        mergedInfo.node1 = (left.node1 || right.node1);
        mergedInfo.node2 = (left.node2 || right.node2);

        return mergedInfo;
    }

    class SubTreeInfo {
        boolean node1 = false;
        boolean node2 = false;
        Node ancestor;
    }


}


class Node {
    Node left = null;
    Node right = null;
    Node parent = null;
    int val;
}
