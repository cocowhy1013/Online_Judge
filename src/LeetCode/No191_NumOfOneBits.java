package LeetCode;

/**
 * Created by Coco on 2016/3/22.
 */
public class No191_NumOfOneBits {
    public int Solution(int n){
        int number = 0;
        while(n!=0) {
            n = n & (n - 1);
            number ++;
        }
        return number;

    }
    public static void main(String[] args){

        //System.out.println(new No191_NumOfOneBits().Solution(2147483648));
        //System.out.println(33&1);
    }
}
