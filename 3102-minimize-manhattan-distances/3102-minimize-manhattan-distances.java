class Solution {
    public int minimumDistance(int[][] points) {

        int n = points.length;

        int maxSum = Integer.MIN_VALUE;
        int secondMaxSum = Integer.MIN_VALUE;

        int minSum = Integer.MAX_VALUE;
        int secondMinSum = Integer.MAX_VALUE;

        int maxDiff = Integer.MIN_VALUE;
        int secondMaxDiff = Integer.MIN_VALUE;

        int minDiff = Integer.MAX_VALUE;
        int secondMinDiff = Integer.MAX_VALUE;

        // Find extreme values
        for (int i = 0; i < n; i++) {

            int sum = points[i][0] + points[i][1];
            int diff = points[i][0] - points[i][1];

            // Maximum sum
            if (sum > maxSum) {
                secondMaxSum = maxSum;
                maxSum = sum;
            }
            else if (sum > secondMaxSum) {
                secondMaxSum = sum;
            }

            // Minimum sum
            if (sum < minSum) {
                secondMinSum = minSum;
                minSum = sum;
            }
            else if (sum < secondMinSum) {
                secondMinSum = sum;
            }

            // Maximum difference
            if (diff > maxDiff) {
                secondMaxDiff = maxDiff;
                maxDiff = diff;
            }
            else if (diff > secondMaxDiff) {
                secondMaxDiff = diff;
            }

            // Minimum difference
            if (diff < minDiff) {
                secondMinDiff = minDiff;
                minDiff = diff;
            }
            else if (diff < secondMinDiff) {
                secondMinDiff = diff;
            }
        }

        int answer = Integer.MAX_VALUE;

        // Try removing every point
        for (int i = 0; i < n; i++) {

            int sum = points[i][0] + points[i][1];
            int diff = points[i][0] - points[i][1];

            int newMaxSum;
            int newMinSum;
            int newMaxDiff;
            int newMinDiff;

            // Remove maximum sum
            if (sum == maxSum) {
                newMaxSum = secondMaxSum;
            }
            else {
                newMaxSum = maxSum;
            }

            // Remove minimum sum
            if (sum == minSum) {
                newMinSum = secondMinSum;
            }
            else {
                newMinSum = minSum;
            }

            // Remove maximum difference
            if (diff == maxDiff) {
                newMaxDiff = secondMaxDiff;
            }
            else {
                newMaxDiff = maxDiff;
            }

            // Remove minimum difference
            if (diff == minDiff) {
                newMinDiff = secondMinDiff;
            }
            else {
                newMinDiff = minDiff;
            }

            int distance1 = newMaxSum - newMinSum;
            int distance2 = newMaxDiff - newMinDiff;

            int maximumDistance = Math.max(distance1, distance2);

            answer = Math.min(answer, maximumDistance);
        }

        return answer;
    }
}