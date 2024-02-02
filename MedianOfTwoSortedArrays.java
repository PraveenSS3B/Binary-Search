class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int tmp[] = new int[m+n];

        int i = 0, j = 0, k = 0;

        while(i < m && j < n)
        {
            if(nums1[i] <= nums2[j])
            {
                tmp[k++] = nums1[i++];
            }

            else
            {
                tmp[k++] = nums2[j++];
            }
        }

        while(i < m)
        {
            tmp[k++] = nums1[i++];
        }
        while(j < n)
        {
            tmp[k++] = nums2[j++];
        }

        if((m+n) % 2 != 0)
        {
            return tmp[(m+n)/2];
        }
        else
        {
            int index = (m+n) / 2;
            double ans = (double)(tmp[index] + tmp[index - 1]) / 2;
            return ans;
        }
    }
}
