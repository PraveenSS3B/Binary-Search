import java.util.*;
public class MinimizeMaxDistanceToGasStation {

    static class Pair{
        double first;
        int second;
        Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static double MinimiseMaxDistance(int []arr, int K){
        int n = arr.length;
        int howManyPlaced[] = new int[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.first, a.first));


        for (int i = 1; i < n; i++) {
            pq.add(new Pair(arr[i] - arr[i - 1], i - 1));
        }

        for(int gs = 1; gs <= K; gs++)
        {
            Pair top = pq.poll();
            int secInd = top.second;

            howManyPlaced[secInd]++;

            double diff = arr[secInd + 1] - arr[secInd];
            double secLen = diff / (howManyPlaced[secInd] + 1);

            pq.add(new Pair(secLen, secInd));

        }
        

        return pq.peek().first;
    }
}
