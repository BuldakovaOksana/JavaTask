/**
 * taskAdd02
 */
public class taskAdd02 {

    public static void main(String[] args) {
      String s="abag";
      System.out.println(isPalindrome(s));  
    }
    public static boolean isPalindrome(String str) {
        int last = str.length();
        int mid = last/2;
        for (int i = 0; i < mid; i++) {
            if(str.charAt(i) != str.charAt(last - 1 - i)){
                return false;
            }
        }
        return true;
    }


}