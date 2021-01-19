import java.util.*;

class  Palindrome {

    public static void main(String args[]) {
        System.out.println(palindrome("Tact doa"));
        System.out.println(palindrome("aaaaaaaa"));
    }


   
    public static boolean palindrome(String str) {
        
        str = str.toLowerCase();
        Hashtable<Character, Integer> hashtable = countCharacters(str);
        
        int[] oddAndEven = countOddAndEven(hashtable);
        int characterCount = oddAndEven[1];
        int oddCharCount = oddAndEven[0];


        if ((characterCount%2!=0 && oddCharCount==1) || (characterCount%2==0 && oddCharCount==0)){
            return true;
        }
        else {
            return false;
        }
    }

    private static Hashtable<Character,Integer> countCharacters(String str) {
        Hashtable<Character, Integer> hashtable = new Hashtable<>();

        for(int i = 0; i<str.length(); i++) {
            char c = str.charAt(i);

            if (hashtable.containsKey(c)){
                Integer count = hashtable.get(c);
                count++;
                hashtable.put(c, count);
            }
            else {
                hashtable.put(c, 1);
            }
        }
        return hashtable;
    }

    private static int[] countOddAndEven(Hashtable<Character, Integer> hashtable){
            Integer oddCharCount = 0;
            Integer characterCount = 0;

            for (Map.Entry<Character, Integer> e : hashtable.entrySet()) {
                if (e.getValue()%2!=0 && e.getKey()!=' '){
                oddCharCount++; 
                characterCount+=e.getValue();
                }

            }
            return new int[] {oddCharCount, characterCount};
        }



}