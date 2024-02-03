import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        if(n > m) return kthElement(arr2, arr1, m, n, k);
        
        // when k is large then we can't take enough elements from arr1,
        // so making sure we need to pick utmost k - m elements from arr1 before picking rest from arr2
        int low = Math.max(0, k - m); 

        int high = Math.min(k, n);

        int symmetry = k;

        int tl = n + m;


        while(low <= high)
        {
            int mid1 = low + (high - low) / 2;
            int mid2 = symmetry - mid1;

            int l1 = Integer.MIN_VALUE, l2 = l1, r1 = Integer.MAX_VALUE, r2 = r1;

            if(mid1 > 0) l1 = arr1.get(mid1 - 1);
            if(mid2 > 0) l2 = arr2.get(mid2 - 1);

            if(n > mid1) r1 = arr1.get(mid1);
            if(m > mid2) r2 = arr2.get(mid2);

            if(l1 <= r2 && l2 <= r1)
            {
                // [2,3,45] [4,6,7,8] -> (3 + 4) + 1 = 8 / 2 -> 4 (this means left side must have 4 elements and the rest at right side)
                // [2,3,  45]
                //  4,6] [7,8, -> suppose if we select 2 elements from left array

                // [1, 4, 8, 10] [2, 3, 6, 7, 9] -> (4 + 5 + 1) / 2 -> 5

                // [1, 4, 2, 3, 6] [8,10,7,9] -> [1,2,3,4,6] [7,8,9,10]

                return Math.max(l1,l2);

            }
            else if(l1 > r2)
            {
                high = mid1 - 1;
            }

            else
            {
                low = mid1 + 1;
            }

        }

        return 0;
    }
}
