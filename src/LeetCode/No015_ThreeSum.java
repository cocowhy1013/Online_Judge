package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Coco on 2016/3/24.
 */
public class No015_ThreeSum {
/*
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]+nums[i+1]+nums[i+2]>0)
                break;
            for(int j=i+1;j< nums.length-1;j++){
                if(nums[i]+nums[j]+nums[j+1]>0)
                    break;
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List temp = new ArrayList<Integer>();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);
                        if(result.contains(temp));
                        else result.add(temp);
                    }
                    else if(nums[i]+nums[j]+nums[k]>0)
                        break;
                }
            }
        }
        return result;
    }*/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])
                continue;
            List<int[]> list = twoSum(nums,-nums[i],i+1, nums.length-1);
            if(list!=null) {
                for(int j=0;j<list.size();j++) {
                    List temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(list.get(j)[0]);
                    temp.add(list.get(j)[1]);
                    //if (result.contains(temp))
                    //    ;
                    //else
                    result.add(temp);
                }
            }
        }
        return result;
    }
    public List<int[]> twoSum(int[] nums, int value, int start, int end){
        List<int[]> list = new ArrayList<int[]>();

        while(start<end){
            if(nums[start]+nums[end]<value)
                start++;
            else if(nums[start]+nums[end]>value)
                end--;
            else if(nums[start]+nums[end]==value){
                int[] result = new int[2];
                result[0] = nums[start];
                result[1] = nums[end];
                list.add(result);
                start++;
                end--;
                while (start<end&&nums[start]==nums[start-1])
                    start++;
                while (end>start&&nums[end]==nums[end+1])
                    end--;
            }
        }
        return list;
    }
    public static void main(String [] args){
        int[] array = {-10,5,-11,-15,7,-7,-10,-8,-3,13,9,-14,4,3,5,-7,13,1,-4,
                -11,5,9,-11,-4,14,0,3,-10,-3,-7,10,-5,13,14,-5,6,14,0,5,-12,-10,
                -1,-11,9,9,1,-13,0,-13,-1,4,0,-7,8,3,14,-15,-9,-10,-3,0,-15,-1,
                -2,6,9,11,6,-14,1,1,-9,-14,6,7,10,14,2,-13,-13,8,6,-6,8,-9,12,7,-9,
                -11,4,-4,-4,4,10,1,-12,-3,-2,1,-10,6,-13,-3,-1,0,11,-5,0,-2,-11,-6,
                -9,11,3,14,-13,0,7,-14,-4,-4,-11,-1,8,6,8,3};
        System.out.println((new No015_ThreeSum()).threeSum(array).toString());
    }

}
