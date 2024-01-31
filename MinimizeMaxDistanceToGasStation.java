public class MinimizeMaxDistanceToGasStation {
    public static double MinimiseMaxDistance(int []arr, int K){
        int n = arr.length;
        int howManyPlaced[] = new int[n];

        for(int gs = 1; gs <= K; gs++)
        {
            double maxSecLen = -1; int maxSecIndex = -1;
            for(int i = 0; i < n - 1; i++)
            {
                double diff = arr[i + 1] - arr[i];
                double sectionLen = (diff / (howManyPlaced[i] + 1));

                if(sectionLen > maxSecLen)
                {
                    maxSecLen = sectionLen;
                    maxSecIndex = i;
                }
            }
            howManyPlaced[maxSecIndex]++;
        }

        double maxAns = -1;

        for(int i = 0; i < n - 1; i++)
        {
            double diff = arr[i + 1] - arr[i];
            double sectionLen = (diff / (howManyPlaced[i] + 1));
            maxAns = Math.max(maxAns, sectionLen);
        }

        return maxAns;
    }
}
