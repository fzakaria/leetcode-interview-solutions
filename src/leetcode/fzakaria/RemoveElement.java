package leetcode.fzakaria;

import java.util.Arrays;

/*
 * @see https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        for (int i = nums.length - 1; i >= 0; i --) {

            if (nums[i] == val) {
                continue;
            }

            // otherwise, find the next element that is equal to val
            // swap it
            // if none found we are done
            boolean found = false;
            for (int j = i - 1; j >= 0; j --) {

                if (nums[j] == val) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    found = true;
                    break;
                }
            }

            if (!found) {
                break;
            }
        }


        return (int) Arrays.stream(nums).filter(n -> n != val).count();
    }

}
