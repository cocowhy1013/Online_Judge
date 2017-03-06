package LeetCode;

/**
 * Created by coco on 17/3/2.
 */
public class No007_ReverseInteger {
    public int reverse(int x) {
        int flag = 0;
        if(x < 0) {
            x = -x;
            flag = -1;
        }
        else flag = 1;
        long result = 0;
        int i = x%10;
        while(i>=0){
            result = result * 10 + i;
            x = x / 10;
            if(x == 0)
                break;
            i = x % 10;
        }
        result = result * flag;
        if(result<-2147483648||result>2147483647)
            return 0;
        return (int)result;
    }
    public static void main(String[] args){
        No007_ReverseInteger reverseInteger = new No007_ReverseInteger();
        System.out.println(reverseInteger.reverse(10));
    }
}
