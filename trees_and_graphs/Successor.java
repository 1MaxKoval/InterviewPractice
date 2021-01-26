package trees_and_graphs;

//79, 91
public class Successor {

    public NewNode findSucc(NewNode node) {

        if (node.right != null) {
            return findNextInOrder(node.right);
        }        

        else {
            if (node.parent.val < node.val) {
                return node.parent;
            }
            else {
                NewNode parent = node.parent;
                while (parent.val < node.val && parent!=null) {
                    parent = parent.parent;
                }
                if (parent==null)
                    return null;
                else 
                    return parent;
            }
        }


    }

    public NewNode findNextInOrder(NewNode rootNode) {
        if (rootNode.left == null){
            return rootNode;
        }

        NewNode left = findNextInOrder(rootNode.left);
        if (left!=null) 
            return left;
        else 
            return rootNode;
    }



}


class NewNode extends MyBinaryNode {
    NewNode parent;
    NewNode right;
    NewNode left;
}
