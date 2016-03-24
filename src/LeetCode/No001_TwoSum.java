package LeetCode;

import java.util.Arrays;

/**
 * Created by Coco on 2016/3/24.
 */
public class No001_TwoSum {

    public int[] returnPlusElements(int[] nums, int target){
        int[] array = Arrays.copyOf(nums,nums.length);
        Arrays.sort(array);
        int[] result = new int[2];
        int end;
        end = array.length;
        for(int i=0;i<array.length;i++){
            for(int j=i;j<end;j++){
                if(array[i]+array[j]==target){
                    result[0] = returnLocation(nums,array[i]);
                    result[1] = returnLocation(nums,array[j]);
                    return result;
                }
                else if(array[i]+array[j]>target){
                    end = j;
                    break;
                }

            }
        }
        return result;
    }
    public static int returnLocation(int[] array,int value){
        for(int i=0;i<array.length;i++){
            if(array[i] == value) {
                array[i] = -1;
                return i;
            }
        }
        return -1;
    }
    public static void main(String [] args){
        int [] array = {0,4,3,0};
        int [] result = (new No001_TwoSum()).returnPlusElements(array,0);
        System.out.println(Arrays.toString(result));
    }
}
