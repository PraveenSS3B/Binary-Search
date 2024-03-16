
public final class MedianInRowWiseSortedMatrix {
    public static int upperBound(int row[], int x, int n) {
        int low = 0, high = n - 1, ans = high;

        while(low <= high)
        {
            int mid = low +(high - low) / 2;

            if(row[mid] > x)
            {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return ans;
    }
    public static int countSmallEqual(int matrix[][], int mid, int m, int n) {
        int c = 0;

        for(int i = 0; i < m; i++)
        {
             c += upperBound(matrix[i], mid, n);
        }

        return c;
    }


    public static int findMedian(int matrix[][], int m, int n) {

        int reqCount = (m * n) / 2;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        m = matrix.length;
        n = matrix[0].length;

        for(int i = 0; i < m; i++)
        {
            low = Math.min(matrix[i][0], low);
            high = Math.max(matrix[i][n - 1], high);
        }

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            int smallerEqual = countSmallEqual(matrix, mid, m, n);

            if(smallerEqual <= reqCount) low = mid + 1;
            else high = mid - 1;
        }

        return low;

    }
}
