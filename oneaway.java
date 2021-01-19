import java.util.*;
public class oneaway {
    
    public static void main(String[] args) {
        System.out.println(oneAway("pale", "ple"));
        System.out.println(oneAway("pales", "pale"));
        System.out.println(oneAway("pale", "bale"));
        System.out.println(oneAway("pale", "palee"));
        System.out.println(oneAway("pale", "bake"));
    }

    public static boolean oneAway(String str1, String str2) {

        if (str1.equals(str2)) {
            return true;
        }

        if (str1.length() == str2.length()) {
            return isOneCharacterChange(str1, str2);
        }
        else {
            int diff = str2.length() - str1.length();
            if (diff==-1 || diff==1) {
                return true;
            }
            else {
                return false;
            }
        }


    }

    // Assuming that the strings are equal length
    private static boolean isOneCharacterChange(String str1, String str2) {
        int changedCharacters = 0;

        for (int i = 0; i<str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)){
                changedCharacters++;
            }
        }

        if (changedCharacters>1){
            return false;
        }
        else {return true;}

    }

}
