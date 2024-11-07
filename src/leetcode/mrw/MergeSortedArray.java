package leetcode.mrw;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if (i >= m) {
                merged[k++] = nums2[j++];
            } else if (j >= n) {
                merged[k++] = nums2[i++];
            } else if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        k = 0;
        for (int x : merged) {
            nums1[k++] = x;
        }
    }
}
