class MinNumDaysMakeBouquets {
    public int[] maxMinDay(int[] bloomDay, int n)
    {
        int max = bloomDay[0], min = bloomDay[0];
        for(int i = 0; i < n; i++)
        {
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }

        return new int[]{min, max};
    }

    public boolean calc(int[] bloomDay, int mid, int m, int k, int n)
    {
        int bouquets = 0, c = 0;

        for(int i = 0; i < n; i++)
        {
            if(bloomDay[i] <= mid)
            {
                c++;
            }
            else
            {
                bouquets += (c / k);
                c = 0;
            }
        }

        bouquets += (c / k);

        if(m <= bouquets)
        {
            return true;
        }

        return false;

    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if(((long)m * (long)k) > n) return -1;
        
        int minMax[] = maxMinDay(bloomDay, n);

        int low = minMax[0], high = minMax[1];

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(calc(bloomDay, mid, m, k, n))
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
