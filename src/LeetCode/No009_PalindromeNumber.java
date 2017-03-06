package LeetCode;

/**
 * Created by coco on 17/3/4.
 */
public class No009_PalindromeNumber {
    public boolean isPalindrome(int b) {

        if(b<0||(b%10==0&&b!=0))
            return false;
        int comp = 0;
        while(comp<=b) {
            comp = comp * 10 + b % 10;
            if (b == comp)
                return true;
            b = b / 10;
            if (b == comp)
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        No009_PalindromeNumber palindromeNumber = new No009_PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(0));
    }
}
