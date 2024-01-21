class Capacity_To_Ship_Packages_Within_D_Days {
    public int[] getSumMax(int[] weights, int n)
    {
        int sum = 0, max = weights[0];

        for(int i = 0; i < n; i++)
        {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        return new int[]{sum, max};
    }
    public boolean checkCapacity(int[] weights, int mid, int n, int days) {
        int c = 0, tmp = 0;

        for(int i = 0; i < n; i++)
        {
            tmp += weights[i];
            if(tmp == mid)
            {
                c++;
                tmp = 0;
            }
            else if(tmp > mid){
                c++;
                tmp = weights[i];
            }
        }

        c += Math.ceil((double)tmp/mid);


        return c <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int[] arr = getSumMax(weights, n);

        int low = arr[1], high = arr[0];

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(checkCapacity(weights, mid, n, days))
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
