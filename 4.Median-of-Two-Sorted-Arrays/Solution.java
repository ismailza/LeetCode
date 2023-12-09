class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int merged[] = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length)
        {
            if (nums1[i] < nums2[j])
                merged[i + j] = nums1[i++];
            else
                merged[i + j] = nums2[j++];
        }
        while (i < nums1.length)
            merged[i + j] = nums1[i++];
        while (j < nums2.length)
            merged[i + j] = nums2[j++];
        
        i = nums1.length + nums2.length;
        if (i % 2 == 1)
            return merged[i/2];
        return (merged[i/2 - 1] + merged[i/2]) / (double)2;
    }
}