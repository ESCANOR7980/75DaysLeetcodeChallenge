class Solution {
    private int solve(int i, int j, int[] nums, Integer[][] dp) {
        if (i == j) {
            return nums[i];
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int takeLeft = nums[i] - solve(i + 1, j, nums, dp);
        int takeRight = nums[j] - solve(i, j - 1, nums, dp);

        return dp[i][j] = Math.max(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        return solve(0, n - 1, nums, dp) >= 0;
    }
}