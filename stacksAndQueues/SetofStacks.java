package stacksAndQueues;

import java.util.*;

public class SetofStacks<T> {
    ArrayList<Stack<T>> stacks;
    int stackCapacity;
    Stack<T> topStack;
    
    public SetofStacks(int capacity) {
        stackCapacity = capacity;
        stacks = new ArrayList<>();
        topStack = new Stack<T>();
        stacks.add(topStack);
    }

    public void push(T value){

        if (topStack.size()==stackCapacity) {
            topStack = new Stack<T>();
            stacks.add(topStack);
        }

        topStack.push(value);

    }

    public T pop(){

        if (topStack.isEmpty() && stacks.size()!=1) {
            for (int i = stacks.size()-2; i>=0; i--){
                if (stacks.size() == 1) {
                    return null;
                }
                else if (topStack.isEmpty()){
                    stacks.remove(i+1);
                    topStack = stacks.get(i);
                } 
                else {
                    break;
                }
            }
        }

        else if (topStack.isEmpty() && stacks.size()==1){
            return null;
        }
        
        return topStack.pop();
    }


    public T popAt(int index) {
        Stack<T> stack = stacks.get(index);
        if (stack.isEmpty()) {
            return null;
        }
        else {
            return stack.pop();
        }
    }





}
