package linked_lists;

public class KthToLast {

    public static void main(String args[]) {
            MyLinkedList newList = new MyLinkedList();
            newList.add(2);
            newList.add(2);
            newList.add(3);
            newList.add(4);
            newList.add(9);
            newList.add(30);
            newList.add(30);
            System.out.println(kthToLast(newList.headNode, 3).val);
        }
    

    public static MyLinkedList.Node kthToLast(MyLinkedList.Node headNode, int k) {

        int count = 1;
        MyLinkedList.Node currentNode = headNode;
        while (currentNode!=null) {
            count++;
            currentNode = currentNode.next;
        }

        if (k>count) return null;

        int position = (count-k);
        count = 1;
        currentNode = headNode;
        
        while (currentNode!=null) {
            if (count == position) {
                return currentNode;
            }
            count++;
            currentNode = currentNode.next;
        }
        return null;
    }


    
}
