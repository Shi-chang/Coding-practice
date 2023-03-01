import java.util.Map;
import java.util.HashMap;

public class LC242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            Character curChar = t.charAt(i);
            Integer curVal = sMap.get(curChar);

            if (curVal == null) {
                return false;
            }

            if (curVal == 1) {
                sMap.remove(curChar);
            } else {
                sMap.put(curChar, curVal - 1);
            }
        }

        return sMap.size() == 0;
    }

    // public boolean isAnagram(String s, String t) {
    //     if (s.length() == 1 && t.length() == 1) {
    //         return s.equals(t);
    //     }

    //     if (s.length() != t.length()) {
    //         return false;
    //     }

    //     char[] sArr = new char[s.length()];
    //     char[] tArr = new char[t.length()];

    //     for (int i = 0; i < s.length(); i++) {
    //         sArr[i] = s.charAt(i);
    //     }

    //     for (int i = 0; i < t.length(); i++) {
    //         tArr[i] = t.charAt(i);
    //     }

    //     Arrays.sort(sArr);
    //     Arrays.sort(tArr);

    //     for (int i = 0; i < sArr.length; i++) {
    //         if (sArr[i] != tArr[i]) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }
}
