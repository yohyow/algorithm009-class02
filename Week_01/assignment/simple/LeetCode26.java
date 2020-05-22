import java.util.Arrays;

/**
 * LeetCode26
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode26 {
    public static void main(String[] args) {
        //快慢指针 两次遍历
        int[] nums = new int[]{1,1,2};
        Arrays.sort(nums);
        System.out.println(removeDuplicatesMy(nums));
    }

    /**
     * 暴力
     * 移除数组中重复项
     * 
     * 注意: 返回的结果是[1, -1, 2]
     * @param nums
     * @return
     */
    public static int removeDuplicatesMy(int[] nums){
        //1. 判空
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int length = 0;
        //2. O(n^2)双循环剔除
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    nums[j] = -1;
                }
            }
            length = length + (nums[i] == -1 ? 0 : 1);
        }
        return length;
    }

    /**
     * 官方答案
     * 移除数组中重复项
     * 思路真好, 真是没想到
     * 但是,这个算法有前提
     * 1. 数组已经排序
     * 2. 题目只要无重复数组的长度, 非新数组
     * 注意: 返回的结果是[1,2,1] 提交leetcode时, 不知道为什么执行结果是[1,2]
     */
    public static int removeDuplicates(int[] nums) {
        //1. 严谨一点, 先判断空
        if (null == nums || nums.length == 0) {
            return 0;
        }
        //2. 遍历数组
        //3. 算法核心: 利用快慢指针索引进行对比, 
        //   如果两个相邻数组元素相等, 快指针继续+1,
        //   直到找到不相等的元素, 然后慢指针+1成为
        //   自己相邻元素的索引, 接着赋值, 这样就达到了
        //   排重的目的. 
        int slowi = 0;//慢指针索引
        for (int i = 1; i < nums.length; i++) {
            if (nums[slowi] != nums[i]) {
                slowi ++;
                nums[slowi] = nums[i];
            }
        }
        return slowi + 1;//返回length需要 + 1
    }
}