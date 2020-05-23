public class LeetCode189 {
    public static void main(String[] args) {
        //空间复杂度O(1)
        int[] sourceData = new int[]{1,2,3,4,5,6};
        int k = 2;
        rotateTwo(sourceData, k);
        for (int i = 0; i < sourceData.length; i++) {
            System.out.println(sourceData[i]);
        }
    }

    /**
     * 旋转数据
     * 暴力方法
     * 移动一次算法 然后循环k次
     * result: 通过	 264 ms	 40.2 MB
     * 时间复杂度: O(n*k)
     * 空间复杂度: O(1)
     */
    private static void rotateMy(int[] sourceData, int k) {
        int length = 0;
        //1. 判空
        if (null == sourceData || (length = sourceData.length) == 0 || k == 0) {
            return;
        }
        //2. 移动k次
        for (int i = 0; i < k; i++) {
            //数组倒叙 每次移动一位
            int temp = sourceData[length - 1];
            for (int j = length - 1; j > 0; j --) {
                sourceData[j] = sourceData[j - 1];
            }
            sourceData[0] = temp;
        }
    }

    /**
     * 官方题解
     * 旋转数据
     * 环装替换
     * result: 
     */
    private static void rotateTwo(int[] sourceData, int k) {
        int length = 0;
        //1. 判空
        if (null == sourceData || (length = sourceData.length) == 0 || k == 0) {
            return;
        }
        //2. 环状替换
        k = k % length;
        int count = 0;
        for (int i = 0; count < sourceData.length; i++) {
            int current = i;
            int prenum = sourceData[i];
            do {
                int next = (current + k) % length;
                int temp = sourceData[next];
                sourceData[next] = prenum;
                prenum = temp;
                current = next;
                count ++;
            } while (i != current);
        }
    }
}