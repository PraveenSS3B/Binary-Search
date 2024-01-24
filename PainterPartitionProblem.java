import java.util.*;

public class Solution 
{
    public static boolean solve(ArrayList<Integer> boards, int mid, int painters)
    {
        int boardsPainted = 0, paintersCount = 1;

        for(Integer board : boards)
        {
            if(boardsPainted + board <= mid)
            {
                boardsPainted += board;
            }
            else
            {
                paintersCount++;
                boardsPainted = board;
            }
        }

        if(paintersCount > painters)
        {
            return true;
        }

        return false;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //[2] [1, 5, 6, 2, 3] -> 17
        //[2,1] [5,6,2,3] -> 16
        // [2,1,5] [6,2,3] -> 11
        // [2,1,5,6] [2,3] -> 14
        //[2,1,5,6,2] [3] -> 16

        if(boards.size() < k)
        {
            return -1;
        }

        int low = Collections.max(boards);
        long high = boards.stream().mapToLong(Integer::intValue).sum();

        while(low <= high)
        {
            int mid = (int)(low + (high - low) / 2);

            if(solve(boards, mid, k))
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
