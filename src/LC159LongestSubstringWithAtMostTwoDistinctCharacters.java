import java.util.HashMap;
import java.util.Map;

public class LC159LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() <= 2) {
            return s.length();
        }

        int slow = 0;
        int res = 2;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character fastChar = s.charAt(i);
            map.put(fastChar, map.getOrDefault(fastChar, 0) + 1);

            while (map.size() > 2) {
                Character slowChar = s.charAt(slow);
                map.put(slowChar, map.get(slowChar) - 1);

                if (map.get(slowChar) == 0) {
                    map.remove(slowChar);
                }

                slow++;
            }

            res = Math.max(res, i - slow + 1);
        }

        return res;
    }
}
