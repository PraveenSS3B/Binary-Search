public static int maximumOnesRow_BruteForce(List<List<Integer>> matrix, int n, int m)
    {
        int ans = -1, currMax = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.size(); i++)
        {
            int c = 0;
            for(int j = 0; j < matrix.get(i).size();j++)
            {
                if(matrix.get(i).get(j) == 1)
                {
                    c++;
                }
            }
            if(c > currMax)
            {
                currMax = c;
                c = 0;
                ans = i;
            }
        }
        return ans;
    }
