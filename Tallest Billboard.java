class Solution {
  public int tallestBillboard(int[] rods) {
    final int sum = Arrays.stream(rods).sum();
    int[] dp = new int[sum + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (final int h : rods) {
      int[] prev = dp.clone();
      for (int i = 0; i <= sum - h; ++i) {
        if (prev[i] < 0)
          continue;
        dp[i] = Math.max(dp[i], prev[i]);
        dp[i + h] = Math.max(dp[i + h], prev[i]);
        dp[Math.abs(i - h)] = Math.max(dp[Math.abs(i - h)], prev[i] + Math.min(i, h));
      }
    }
    return dp[0];
  }
}
