import java.util.*;
public class MinimizeMaxDistanceToGasStation {

     public static int find(int []arr, double dist, int k){
         int c = 0;

         for(int i = 1; i < arr.length; i++)
         {
             int noOfGsPossibleInBetween = (int)((arr[i] - arr[i - 1]) / dist);
             if(noOfGsPossibleInBetween * dist == arr[i] - arr[i - 1])
             {
                 noOfGsPossibleInBetween--;
             }
             c += noOfGsPossibleInBetween;

             if(c > k)
             {
                 return c;
             }
         }

         return c;
     }


    public static double MinimiseMaxDistance(int []arr, int K){
        int n = arr.length;
        double high = Integer.MIN_VALUE, low = 0;

        for(int i = 0; i < n - 1; i++)
        {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        double diff = 1e-6 ;

        while((high - low) > diff)
        {
            double mid = (double)(low + (high - low) / 2);

            int gasStationsCount = find(arr, mid, K);

            if(gasStationsCount > K)
            {
                low = mid;
            }

            else
            {
                high = mid;
            }
        }

        return high;
        
    }
}
