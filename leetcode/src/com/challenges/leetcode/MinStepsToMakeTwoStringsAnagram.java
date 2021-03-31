/**
 * <a href="https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/"> question </a>
 */

public class MinStepsToMakeTwoStringsAnagram {

    public int minSteps(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int[] sMap = new int[26];
        for (char ss : tArray) {
            sMap[ss - 97]++;
        }
        for (char tt : sArray) {
            sMap[tt - 97]--;
        }
        int count = 0;
        for (int i : sMap) {
            if (i > 0) {
                count += i;
            }
        }
        return count;
    }
}
