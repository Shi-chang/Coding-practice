import java.util.Map;
import java.util.HashMap;

public class LC240LongestSSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        if (s.length() <= k) {
            return s.length();
        }

        int slow = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character fastChar = s.charAt(i);

            map.put(fastChar, map.getOrDefault(fastChar, 0) + 1);

            while (map.size() > k) {
                Character slowChar = s.charAt(slow);
                map.put(slowChar, map.get(slowChar) - 1);

                if (map.get(slowChar) == 0) {
                    map.remove(slowChar);
                }

                slow++;
            }

            maxLen = Math.max(maxLen, i - slow + 1);
        }

        return maxLen;
    }
}
