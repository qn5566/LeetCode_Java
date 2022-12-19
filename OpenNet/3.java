package OpenNet;

/**
 * https://anishdgr8111.medium.com/implementing-the-cost-effective-array-reducer-in-javascript-47e71bb7a25e
 */
class Solution {
    class Result {

        /*
         * Complete the 'reductionCost' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY num as parameter.
         */

        public static int reductionCost(List<Integer> num) {
            int finalSum = 0;
            int a, b, sum = 0;

            if (num.size() == 1) {
                finalSum = num.get(0);
                return finalSum;
            }

            if (num.size() == 2) {
                finalSum = num.get(0) + num.get(1);
                return finalSum;
            }

            if (num.size() > 2) {
                Collections.sort(num, Collections.reverseOrder());
                return num.get(0) - num.get(1);
            }

            while (num.size() > 1) {
                a = num.get(0);
                if (num.get(1) > -1) {
                    b = num.get(1);
                } else {
                    b = 0;
                }

                sum = a + b;
                finalSum += sum;
                int[] res = new int[2];

                int length = res.length;
                int k = 0;
                for (k = length - 1; k >= 0 && res[k] > sum; k--) {
                    res[k + 1] = res[k];
                }
                if (k == -1) {
                    res[k + 1] = sum;

                } else {
                    res[k + 1] = sum;
                }
            }
            return finalSum;
        }

    }
}
