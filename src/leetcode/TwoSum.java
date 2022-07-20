package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{2,3,4,7,11,15};
        int target = 9;
        int[] result = twoSum_2(nums,9);
        Arrays.stream(result).forEach( System.out::println);
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
                if((nums[i]+nums[i])==target){
                    return new int[]{map.get(nums[i]).get(0),map.get(nums[i]).get(1)};
                }
            }else{
                map.put(nums[i],new ArrayList<>(Collections.singletonList(i)));
            }
        }

        for(int i =0;i< nums.length;i++){
            if(map.containsKey(target-nums[i]) ){
                if(target-nums[i] == nums[i]){
                    if(map.get(nums[i]).size()==2){
                        return new int[]{map.get(nums[i]).get(0),map.get(nums[i]).get(1)};
                    }
                }else {
                    return new int[]{map.get(nums[i]).get(0), map.get(target - nums[i]).get(0)};
                }
            }
        }
        return null;
    }

    public static int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }else{
                map.put(target - nums[i],i);
            }
        }
        return new int[]{};
    }

}
