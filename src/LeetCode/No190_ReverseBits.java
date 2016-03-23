package LeetCode;

/**
 * Created by Coco on 2016/3/23.
 */
public class No190_ReverseBits {
    public static int reverseBits(int n) {
        int m=0;
        for(int i=0;i<32;i++) {
            if ((int) (n & 1) == 1) {
                m = m + 1;
            }
            if(i!=31)
                m = m << 1;
            n = n >> 1;
        }
        return m;
    }
    public static void main(String[] args){
        System.out.println(reverseBits(1));
    }
}
