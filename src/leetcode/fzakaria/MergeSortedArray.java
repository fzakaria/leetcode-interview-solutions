package leetcode.fzakaria;

/**
 * @link https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeSortedArray {

    public static void merge(int[] lhs, int m , int[] rhs, int n) {
        assert lhs.length == m + n;
        assert rhs.length == n;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            // if lhs is smaller than rhs do nothing
            if (lhs[i] <= rhs[j]) {
                i++;
            } else {
                // swap it with the start of the rhs
                int temp = lhs[i];
                lhs[i] = rhs[j];
                rhs[j] = temp;
                j++;
            }
        }

        System.arraycopy(rhs, 0, lhs, m, n);
    }

}
