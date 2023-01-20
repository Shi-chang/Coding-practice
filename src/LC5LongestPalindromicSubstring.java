/**
 * LC5 Longest Palindromic Substring.
 * Given a string s, return the longest palindromic Substring in s.
 */
public class LC5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String result = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            int[] oddPalindrome = palindromeIndices(s, i, i);
            int[] evenPalindrome = palindromeIndices(s, i, i + 1);
            if (oddPalindrome[1] - oddPalindrome[0] + 1 > result.length()) {
                result = s.substring(oddPalindrome[0], oddPalindrome[1] + 1);
            }
            if (evenPalindrome[1] - evenPalindrome[0] + 1 > result.length()) {
                result = s.substring(evenPalindrome[0], evenPalindrome[1] + 1);
            }
        }

        return result;
    }

    private int[] palindromeIndices(String s, int left, int right) {
        // a b c
        // l r   -> {l, l}
        if (s.charAt(left) != s.charAt(right)) {
            return new int[]{left, left};
        }

        // a b b c
        //   l r   -> {l, r}
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return new int[]{left + 1, right - 1};
    }
}
