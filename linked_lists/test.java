package linked_lists;

import java.util.*;
public class test {
    

    public static void main(String args[]) {
        

        HashMap<Character, char[]> table = new HashMap<>();
        table.put('a', new char[] {'a', 'b'});
        char[] arr = table.get('a');
        arr[0] = 'z';
        char[] arr2 = table.get('a');
        System.out.println(arr2[0]);


        String newVal = "E3";
        int val = Character.getNumericValue(newVal.charAt(1));
        System.out.println(val);

        System.out.println('a' < 'b');

    }



}
