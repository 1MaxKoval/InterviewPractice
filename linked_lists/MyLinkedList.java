package linked_lists;

public class MyLinkedList {
    Node headNode;
    
    public class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (headNode == null) {
            headNode = newNode;
        }
        else {
            Node prevNode = headNode;
            Node nextNode = headNode.next;

            while (nextNode!=null) {
                prevNode = nextNode;
                nextNode = nextNode.next;
            }
            prevNode.next = newNode;
        }

    }

    public String printList() {
        StringBuilder str = new StringBuilder("");
        Node currentNode = headNode;

        while(currentNode!=null) {
            str.append(currentNode.val + ",");
            currentNode = currentNode.next;
        }

        return str.toString();
    }


}
