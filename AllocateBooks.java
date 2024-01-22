import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public static boolean canWeAssignPages(ArrayList<Integer> arr,int mid, int n, int students) {
        int noOfStudentsAssigned = 1;
        long pages = 0;

        for(Integer page:arr)
        {
            if(page + pages <= mid)
            {
                pages += page;
            }
            else
            {
                noOfStudentsAssigned++;
                pages = page;
            }
        }

        return noOfStudentsAssigned > students;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        
        long high = arr.stream().mapToLong(Integer::intValue).sum();

        while(low <= high)
        {
            int mid = (int)(low + (high - low) / 2);

            if(canWeAssignPages(arr, mid, n, m))
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
