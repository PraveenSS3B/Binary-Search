class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int n = n1 + n2;

        int index2 = n / 2;
        int index1 = index2 - 1;

        // [1, 3, 4, 7, 10, 12] [2, 3, 6, 15] 
        // [1, 2, 3, 3, 4, 6, 7, 10, 12, 15] -> index1 = 4, index2 = 5

        int i = 0, j = 0;

        int ele1 = -1, ele2 = -1, c = 0;

        while(i < n1 && j < n2)
        {
            if(nums1[i] < nums2[j])
            {
                if(c == index1)
                {
                    ele1 = nums1[i];
                }

                if(c == index2)
                {
                    ele2 = nums1[i];
                }
                i++;
                c++;
            }
            else
            {
                if(c == index2)
                {
                    ele2 = nums2[j];
                }

                if(c == index1)
                {
                    ele1 = nums2[j];
                }
                j++;
                c++;
            }
        }

        while(i < n1)
        {
            if(c == index1)
            {
                ele1 = nums1[i];
            }

            if(c == index2)
            {
                ele2 = nums1[i];
            }
            i++;
            c++;
        }

        while(j < n2)
        {
            if(c == index2)
            {
                ele2 = nums2[j];
            }
            if(c == index1)
            {
                ele1 = nums2[j];
            }
            j++;
            c++;
        }

        if(n % 2 == 0)
        {
            return (double) (ele1 + ele2) / 2;
        }

        else
        {
            return ele2;
        }
        
    }
}
