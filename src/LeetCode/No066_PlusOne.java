package LeetCode;

import java.util.Arrays;

/**
 * Created by Coco on 2016/3/29.
 */
public class No066_PlusOne {
    public int[] plusOne(int[] digits){
        int [] result = new int [digits.length+1];
        int remain = 1;
        for(int i=digits.length-1;i>=0;i--){
            result[i+1]=(digits[i]+remain)%10;
            remain = (digits[i]+remain)/10;
        }
        if(remain==0){
            return Arrays.copyOfRange(result,1,result.length);
        }
        else {
            result[0] = remain;
            return result;
        }
    }
    public static void main(String[] args){
        int[] array = {9,9,0};
        System.out.println(Arrays.toString((new No066_PlusOne().plusOne(array))));
    }
}
