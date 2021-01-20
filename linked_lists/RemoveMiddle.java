package linked_lists;

public class RemoveMiddle {

    public static void main(String args[]) {
        MyLinkedList newList = new MyLinkedList();
        newList.add(2);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        newList.add(9);
        newList.add(30);
        newList.add(30);
        MyLinkedList.Node node = newList.headNode.next;
        removeMiddle(node);
        System.out.println(newList.printList());
    }

    public static void removeMiddle(MyLinkedList.Node node) {
        node.val = node.next.val;

        if (node.next.next == null) {
            node.next = null;
        }
        else {
            node.next = node.next.next;
        }
    }

    
}
