package leetcode.mrw;

public class RemoveElement {
    public static int remove(int[] nums, int val) {
        int r = 0, w = 0, c = 0;
        while (r < nums.length) {
            while (r < nums.length && nums[r] == val) {
                r++;
                c++;
            }
            while (r < nums.length && nums[r] != val) {
                nums[w++] = nums[r++];
            }
        }
        return nums.length - c;
    }
}
