public class LC14LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int curLargestIndex = strs[0].length() - 1;

        for (int i = 1; i < strs.length; i++) {
            curLargestIndex = Math.min(curLargestIndex, largestCommonIndex(strs[0], strs[i]));
        }

        return strs[0].substring(0, curLargestIndex);
    }

    // exclusive
    private int largestCommonIndex(String str1, String str2) {
        int i = 0;
        while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }

        return i;
    }
}
