import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
public class LeetCode1 {

    public static void main(String[] args) {
        System.out.println(twoSum2(new int[]{1,2,3,4,5,6,7}, 6));
    }

    /**
     * 暴力方法
     * 两层循环遍历计算
     * 时间复杂的O(n^2)
     * @param nums
     * @param target
     * @return 
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    /**
     * 官方一遍哈希表题解 利用哈希表存储整数key, 存在即get, 不存在put
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end

