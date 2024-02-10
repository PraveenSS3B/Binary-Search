public static int getOnesCount(ArrayList<Integer> list) {

        if (list.get(0) == 1) {
            list.size();
        }

        else if (list.get(list.size() - 1) == 0) {
            return 0;
        }

        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == 1) {
                if (mid != 0 && list.get(mid - 1) == 1) {
                    high = mid - 1;
                    continue;
                }
                return list.size() - mid;
            }

            else if (list.get(mid) < 1) {
                if (mid != list.size() - 1 && list.get(mid + 1) == 1) {
                    low = mid + 1;
                    continue;
                }
                low = mid + 1;
            }
        }

        return 0;
    }

    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int ans = -1, currMax = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.size(); i++) {
            int onesCount = getOnesCount(matrix.get(i));
            if(onesCount > currMax)
            {
              currMax = onesCount;
              ans = i; 
            }
        }
        return ans;
    }
