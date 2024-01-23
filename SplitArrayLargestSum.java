class Solution {

    public int getSum(int[] nums) {
        int sum = 0;

        for(int num : nums)
            sum += num;

        return sum;
    }

    public boolean solve(int[] nums, int desiredSum, int k)
    {
        // int currSum = nums[0], int subArr = 1;
        int currSum = 0,subArr = 1;
        for(int i = 0; i < nums.length; i++)
        {
            if(currSum + nums[i] <= desiredSum)
            {
                currSum += nums[i];
            }
            else
            {
                subArr++;
                currSum = nums[i];
            }
        }

        if(subArr > k)
        {
            return true;
        }

        return false;
    }

    public int splitArray(int[] nums, int k) {
        // [7] [2,5,10,8] --> 25
        // [7,2] [5,10,8] --> 23
        // [7,2,5] [10,8] --> 18
        // [7,2,5,10] [8] --> 24

        // [1] [4] [4] --> 4

        int low = Arrays.stream(nums).max().orElseThrow();
        int high = getSum(nums);

        if(nums.length == k)
        {
            return low;
        }

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(solve(nums, mid, k))
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return low;
    }
}
