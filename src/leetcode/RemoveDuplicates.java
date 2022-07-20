package leetcode;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) throws Exception {
      int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
      System.out.println(removeDuplicates(nums));

    }

    public static int removeDuplicates(int[] nums) {
        int j=0;


        for(int i=0;i<nums.length;i++)
        {
            if(i+1<nums.length && nums[i]!=nums[i+1])
            {
                nums[j]=nums[i];
                j++;
            }

            if(i==nums.length-1)
            {
                nums[j]=nums[i];
                j++;
            }

        }

        return j;
    }
//        if(nums.length==0){
//            return 0;
//        }
//        int temp = nums[0];
//        int count = 1;
//       for(int i=1;i<nums.length;i++){
//           if(nums[i]==temp){
//               nums[i] = Integer.MAX_VALUE;
//           }else{
//               temp = nums[i];
//               count++;
//           }
//       }
//        Arrays.sort(nums);
//       return count;
//    }
}
