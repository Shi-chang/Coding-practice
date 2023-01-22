/**
 * LC278. First Bad Version
 * The isBadVersion API is defined in the parent class VersionControl.
 */
public class LC278FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        int result = n;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (isBadVersion(middle)) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return result;
    }
}
