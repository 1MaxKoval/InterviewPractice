package stacksAndQueues;
import java.util.*;

public class MyQueue <V>{
    
    Stack<V> stack1 = new Stack<>();
    Stack<V> stack2 = new Stack<>();
    V first;
    int size = 0;


    public void add(V value) {

        if (stack2.isEmpty()) {
            stack1.push(value);
        }
        else {
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(value);
        }
        size++;

    }
    //98 and 114

    public V pop() {

        if (stack1.isEmpty()) {
            return stack2.pop();
        }
        else {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            size--;
            return stack2.pop();
        }

    }

    public int size() {
        return this.size;
    }

    public static void main(String args[]) {
        MyQueue<Integer> q = new MyQueue<>();
        q.add(2);
        q.add(3);
        q.add(4);
    }


}
