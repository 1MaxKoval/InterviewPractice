package linked_lists;

public class SumLists {
    
    public static void main(String args[]) {
            MyLinkedList num1 = new MyLinkedList();
            MyLinkedList num2 = new MyLinkedList();


            num1.add(7);
            num1.add(1);
            num1.add(6);
            num2.add(5);
            num2.add(9);
            num2.add(2);
            System.out.println(num1.headNode.val);
            System.out.println(num2.headNode.val);
            MyLinkedList.Node newList = determineInt(num1.headNode, num2.headNode, 0);
            System.out.println(printNodes(newList));
        } 


        public static String printNodes(MyLinkedList.Node node) {
            
            StringBuilder str = new StringBuilder();

            while(node!=null) {
                str.append("," + node.val);
                node = node.next;
            }

            return str.toString();
        }

    // public static int getSum(MyLinkedList.Node num1, MyLinkedList.Node num2) {

    //     int correct1 = Integer.parseInt(determineInt(num1).toString());
    //     int correct2 = Integer.parseInt(determineInt(num2).toString());

    //     return correct1+correct2;
    // }


    public static MyLinkedList.Node determineInt(MyLinkedList.Node num1, MyLinkedList.Node num2, int carry) {

        if (num1 == null && num2==null && carry==0) {
            return null;
        }

        int value = carry;
        if (num1 != null) {
            value += num1.val;
        } 
        if (num2 != null) {
            value += num2.val;
        }
        int firstDigit = value % 10;
        MyLinkedList newlist = new MyLinkedList();
        newlist.add(firstDigit);
        MyLinkedList.Node newNode = newlist.headNode;

        if (num1 != null || num2 != null) {
            newNode.next = determineInt(num1 == null ? null : num1.next,
                                        num2 == null ? null : num2.next,
                                        value>=10 ? 1 : 0);
        }

        return newNode;
    }


}
