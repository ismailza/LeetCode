class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int i = 0, j = 0;
        int size1 = nums1.size(), size2 = nums2.size();
        vector<int> merged;
        while (i < size1 && j < size2) {
            if (nums1[i] < nums2[j])
                merged.push_back(nums1[i++]);
            else
                merged.push_back(nums2[j++]);
        }
        while (i < size1)
            merged.push_back(nums1[i++]);
        while (j < size2)
            merged.push_back(nums2[j++]);
        
        i = size1 + size2;
        if (i % 2 == 1)
            return merged[i/2];
        return (merged[i/2 - 1] + merged[i/2]) / (double)2;
    }
};