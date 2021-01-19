public class palinBitVector {
    
    public static void main(String args[]) {
        System.out.println(palindrome("taco"));
    }



      public static boolean palindrome(String str) {

        str = str.toLowerCase();

        int tracker = 0;

        for (int i = 0; i < str.length(); i++){

            if (str.charAt(i) == ' ') {
                continue;
            }

            int val  = charVal(str.charAt(i));
            int charPos = (1 << val);

            if ( (charPos & tracker) == 0 ) {
                tracker |= charPos;
            }
            else {
                tracker ^= charPos;
            }



        }

        if (((tracker-1)&tracker) == 0 || tracker == 0) {
            return true;
        }
        else {
            return false;
        }

      }


    

    private static int charVal(char c) {
        int val = c - 'a';
        return val;
    }

}
