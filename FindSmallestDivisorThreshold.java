class FindSmallestDivisorThreshold {
    public int maxDiv(int[] nums, int n) {
        int max = nums[0];
        for(int i = 0; i < n; i++)
        {
            max = Math.max(nums[i], max);
        }

        return max;
    }

    public boolean find(int[] nums, int mid, int threshold)
    {
        int sum = 0;

        for(int num : nums)
        {
            sum += Math.ceil((double) num/mid);
        }

        if(sum <= threshold)
        {
            return true;
        }
        return false;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length, low = 1;

        int high = maxDiv(nums, n);

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(find(nums, mid, threshold))
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }

        }

        return low;
    }
}
