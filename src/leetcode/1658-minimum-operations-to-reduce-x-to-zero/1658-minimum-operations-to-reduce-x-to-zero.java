class Solution {
    public static int minOperations(int[] nums, int x) {
		return solve1(nums, x);
	}

	private static int solve1(int[] nums, int x) {
		int n = nums.length, left = 0, right = n - 1;
		int[] prefSumLeft = new int[n];
		int[] prefSumRight = new int[n];
		prefSumLeft[0] = nums[0];
		prefSumRight[n - 1] = -nums[n - 1];

		for (int i = 1; i < n; i++) {
			prefSumLeft[i] = prefSumLeft[i - 1] + nums[i];
			prefSumRight[n - i - 1] = -(-prefSumRight[n - i] + nums[n - i - 1]);
		}

		int ans = Integer.MAX_VALUE;

		int l = Arrays.binarySearch(prefSumLeft, x);
		if (l >= 0) ans = Math.min(ans, l + 1);

		int r = Arrays.binarySearch(prefSumRight, -x);
		if (r >= 0) ans = Math.min(ans, n - r);

		for (int i = 0; i < n; i++) {
			int val = x - prefSumLeft[i];
			if (val < 0) break;
			else if (val == 0) {
				ans = Math.min(ans, i + 1);
			} else {
				int ind = Arrays.binarySearch(prefSumRight, -val);
				if (ind > i) {
					ans = Math.min(ans, ((i + 1) + (n - ind)));
				}
			}
		}
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
}