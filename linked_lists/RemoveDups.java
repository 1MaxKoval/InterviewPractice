package linked_lists;
import java.util.*;

public class RemoveDups {

    public static void main(String args[]) {
        MyLinkedList newList = new MyLinkedList();
        newList.add(2);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        newList.add(9);
        newList.add(30);
        newList.add(30);
        System.out.println(removeDups2(newList).printList());
    }

    public static MyLinkedList removeDups(MyLinkedList list) {
        
        Hashtable<Integer, Integer> table = new Hashtable<>();

        MyLinkedList.Node headNode = list.headNode;
        MyLinkedList.Node prevNode = null;

        while (headNode!=null) {

            if (table.containsKey(headNode.val)) {
                if (headNode.next == null) {
                    prevNode.next = null;
                }
                else {
                    prevNode.next = headNode.next;
                }
            }
            else {
                table.put(headNode.val,1);
                prevNode = headNode;
            }


            headNode = headNode.next;

        }
        return list;
    }

    public static MyLinkedList removeDups2(MyLinkedList list) {
        MyLinkedList.Node currentNode = list.headNode;
        while (currentNode != null) {
            MyLinkedList.Node secondNode = currentNode.next;
            MyLinkedList.Node prevNode = currentNode;

            while (secondNode != null) {
                if (secondNode.val == currentNode.val) {
                    
                    if (secondNode.next == null) {
                        prevNode.next = null;
                    }
                    else {
                        prevNode.next = secondNode.next;
                    }

                } else {
                    prevNode = secondNode;
                }
                secondNode = secondNode.next;
            }
        currentNode = currentNode.next;
        }
        return list;
    }

}





