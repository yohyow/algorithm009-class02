import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
public class LeetCode242 {

    public static void main(String[] args) {
        System.out.println(isAnagram2("cat","act"));
    }

    /**
     * 暴力
     * 排序, 然后判断相等
     * 时间复杂度：O(nlogn)
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 官方 哈希表
     * 利用字符计算, 查找是否有不同的字母
     * 时间复杂度：O(n)
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    
}
// @lc code=end

