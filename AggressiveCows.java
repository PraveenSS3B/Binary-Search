import java.util.Arrays;

public class AggressiveCows {

    public static boolean canWePlace(int []stalls,int mid, int n, int cows)
    {
         int lastCow = stalls[0], noOfCowsPlaced = 1;

         for(int i = 1; i < n; i++)
         {
             if(stalls[i] - lastCow >= mid)
             {
                 noOfCowsPlaced++;
                 lastCow = stalls[i];
             }

             if(noOfCowsPlaced >= cows)
             {
                 return true;
             }
             
         }       



        return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 1, high = stalls[n - 1] - stalls[0];

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(canWePlace(stalls,mid, n, k))
            {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return low - 1;
        
    }
}
