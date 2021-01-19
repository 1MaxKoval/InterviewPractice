import java.util.*;
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress("aaaaabb"));

    }

    public static String compress(String str) {
        char[] strArr = str.toCharArray();
        char[] newArr = str.toCharArray();

        int writePointer = 0;
        Character prevChar = null; 

        for (int i = 0; i<strArr.length; i++) {

            if (i == 0){
                prevChar = strArr[0];
                writePointer++;
                continue;
            }

            if (strArr[i] == prevChar) {
                int sameCharCount = 1;
                for(i = i+1; i<strArr.length; i++){
                   if (strArr[i] == prevChar) {
                       sameCharCount++;
                   } 
                   else {
                       break;
                   }
                }
                newArr[writePointer] = prevChar;
                newArr[writePointer+1] = (char) sameCharCount;
                writePointer+=2;
            }
            
            else {
                newArr[writePointer] = strArr[i];
                writePointer++;
            }
        }

        return new String(newArr);




    }

}   
