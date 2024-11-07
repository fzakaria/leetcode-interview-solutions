package leetcode.fzakaria;

import java.util.Arrays;

/**
 * @link https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeSortedArray {


    public static void merge(int[] lhs, int m , int[] rhs, int n) {
        assert lhs.length == m + n;
        assert rhs.length == n;

        int N = m + n;
        int[] results = new int[N];

        int l = 0;
        int r = 0;

        for (int i = 0; i < N; i++) {

            if (l >= m) {
                results[i] = rhs[r++];
            } else if (r >= n) {
                results[i] = lhs[l++];
            } else {
                if (lhs[l] < rhs[r]) {
                    results[i] = lhs[l++];
                } else {
                    results[i] = rhs[r++];
                }
            }

        }

        System.arraycopy(results, 0, lhs, 0, N);
    }

}
