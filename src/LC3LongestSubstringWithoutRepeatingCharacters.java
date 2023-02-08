import java.util.HashMap;
import java.util.Map;

public class LC3LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);

            while (map.get(cur) > 1) {
                Character startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
