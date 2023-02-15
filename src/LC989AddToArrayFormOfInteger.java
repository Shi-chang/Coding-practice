import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC989AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> kList = new ArrayList<>();

        // 1 3 6
        while (k != 0) {
            kList.add(k % 10);
            k = k / 10;
        }

        Collections.reverse(kList);

        int idxOfNum = num.length - 1;
        int idxOfKList = kList.size() - 1;
        int carry = 0;
        while (idxOfNum >= 0 || idxOfKList >= 0) {
            int curOfNum = idxOfNum >= 0 ? num[idxOfNum--] : 0;
            int curOfKList = idxOfKList >= 0 ? kList.get(idxOfKList--) : 0;

            int curSum = curOfNum + curOfKList + carry;
            carry = curSum / 10;
            res.add(curSum % 10);
        }

        if (carry != 0) {
            res.add(carry);
        }

        Collections.reverse(res);

        return res;
    }
}
