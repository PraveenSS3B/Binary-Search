class KokoEatingBanana {
    public int getMax(int[] piles, int n) {
        int max = piles[0];
        for(int pile : piles)
        {
            max = Math.max(pile, max);
        }

        return max;
    }

    public boolean checkTime(int[] piles, int maxPerHr, int h)
    {
        int totalHrs = 0;

        for(int pile : piles)
        {
            // totalHrs += (double)(pile / maxPerHr);
            // if(pile % maxPerHr != 0)
            //     totalHrs++;

            totalHrs += Math.ceil((double)pile / (double)maxPerHr);
        }

        return totalHrs <= h ? true : false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length, low = 1, ans = 0;
        int high = getMax(piles, n);

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(checkTime(piles, mid, h))
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
