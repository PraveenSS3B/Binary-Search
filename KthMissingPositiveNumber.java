class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length, low = 0, high = n-1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            int missing  = arr[mid] - (mid + 1);

            if(missing < k)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }

        }
        // Formula to finding the kth missing number
        // arr[high] + more -> arr[high] + (k - missing) -> missing = arr[mid] - (mid + 1); but at last we are at high index so mid == high, hence the next step!
        // arr[high] + k - arr[high] + (high + 1);
        return k + high + 1; // or low + k i.e [low = high + 1] at the end.

    }
}
