package leet.code;

/**
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class Solution1 {

    /**
     * Runtime: 48 ms, faster than 34.04% of Java online submissions for Two Sum.
     * Memory Usage: 38.9 MB, less than 97.41% of Java online submissions for Two Sum.
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i <nums.length ; i++){
            for(int j = i+1 ; j < nums.length ; j ++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}

/*
適當的使用記憶體可以加速程式運行的速度
Runtime: 1 ms, faster than 99.67% of Java online submissions for Two Sum.
Memory Usage: 38.8 MB, less than 97.41% of Java online submissions for Two Sum.
public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0;i<n;i++ ){

            if(map.containsKey(target - nums[i])){
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
                return ans;
            }else{
                map.put(nums[i],i);
            }
        }

        return ans;
    }
 */