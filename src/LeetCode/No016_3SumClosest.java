package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Coco on 2016/3/28.
 */
public class No016_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        //List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int sum = -9999;
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int array = twoSum(nums,target-nums[i],i+1, nums.length-1);
            //System.out.println("i: "+i+" array: "+array);
            //System.out.println("sum: "+(nums[i]+array));
            if(Math.abs(array + nums[i]-target)<Math.abs(sum-target))
                sum = array+nums[i];

        }
        return sum;
    }
    public int twoSum(int[] nums, int value, int start, int end){
        List<int[]> list = new ArrayList<int[]>();

        //System.out.println(Arrays.toString(nums));
        int old_gap = 9999;
        int new_gap = 9999;
        int final_gap = 9999;
        while(start<end){
            if(nums[start]+nums[end]<value) {
                //old_gap = new_gap;
                new_gap = nums[start]+nums[end]-value;
                start++;
            }
            else if(nums[start]+nums[end]>value) {
                //old_gap = new_gap;
                new_gap = nums[start]+nums[end]-value;
                end--;
            }
            else if(nums[start]+nums[end]==value)
            {
                //old_gap = new_gap;
                new_gap = 0;
                return value;
            }

            //System.out.println("oldGap: "+old_gap+" newGap: "+new_gap);
            old_gap = new_gap;
            if(Math.abs(final_gap)>Math.abs(new_gap))
                final_gap = new_gap;
        }
        return value+final_gap;
    }
    public static void main(String [] args){
        int[] array ={87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4};

        System.out.println((new No016_3SumClosest()).threeSumClosest(array,-275));
    }
}
