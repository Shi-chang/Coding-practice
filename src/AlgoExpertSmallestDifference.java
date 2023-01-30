import java.util.Arrays;

public class AlgoExpertSmallestDifference {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int[] result = new int[]{arrayOne[0], arrayTwo[0]};

        int p1 = 0;
        int p2 = 0;

        while (p1 < arrayOne.length && p2 < arrayTwo.length) {
            if (arrayOne[p1] == arrayTwo[p2]) {
                return new int[]{arrayOne[p1], arrayTwo[p2]};
            }

            if (Math.abs(arrayTwo[p2] - arrayOne[p1]) < Math.abs(result[1] - result[0])) {
                result[0] = arrayOne[p1];
                result[1] = arrayTwo[p2];
            }

            if (arrayOne[p1] < arrayTwo[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return result;
    }
}
