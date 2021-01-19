package trees_and_graphs;

public class MinimalTree {
    Node rootNode;
  
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

    }

    public MinimalTree(int[] arr) {
        rootNode = construct(arr, 0, arr.length-1);
    }

    private Node construct(int[] arr, int lower, int upper) {
        if (upper==lower) return null;
        int middle = (upper+lower)/2;
        Node newNode = new Node(arr[middle]);
        newNode.left = construct(arr, lower, middle-1);
        newNode.right = construct(arr, middle+1, upper);
        return newNode;
    }

    public static void main(String args[]) {
        MinimalTree tree = new MinimalTree(new int[] {0,1,2,3,4,5,6});
        System.out.println(tree.rootNode.val);
    }

}
