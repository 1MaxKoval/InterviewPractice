package linked_lists;
import java.util.*;

public class Partition {
   public static void main(String args[]) {
        MyLinkedList newList = new MyLinkedList();
        newList.add(4);
        newList.add(7);
        newList.add(2);
        newList.add(4);
        newList.add(10);
        newList.add(20);
        newList.add(30);
        partition(newList, 4);
        System.out.println(newList.printList());
    } 

    public static void partition(MyLinkedList list, int x) {
        ArrayList<Integer> leftPart = new ArrayList<>();
        ArrayList<Integer> rightPart = new ArrayList<>();
        int xCounter = 0; 
        MyLinkedList.Node headNode = list.headNode;

        while (headNode!=null) {
            if (headNode.val < x) {
                leftPart.add(headNode.val);
            }
            else if (headNode.val > x) {
                rightPart.add(headNode.val);
            }
            else {
                xCounter++;
            }
            headNode = headNode.next;
        }

        headNode = list.headNode;
        int leftPartPointer = 0;
        int rightPartPointer = 0;
        int xPointer = 1;

        while (headNode!=null) {
            if (leftPartPointer != leftPart.size()-1) {
                headNode.val = leftPart.get(leftPartPointer);
                leftPartPointer++;
            }
            else if (xPointer != xCounter){
                headNode.val = x;
                xPointer++;
            }
            else if (rightPartPointer != rightPart.size()-1) {
                headNode.val = rightPart.get(rightPartPointer);
                rightPartPointer++;
            }
            headNode = headNode.next;
        }
    }




}
