package leetcode.fzakaria;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int num : nums) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }

        int majority = (int) Math.floor(nums.length / 2.0);
        return numToCount.entrySet().stream()
                .filter(entry -> entry.getValue() > majority)
                .findFirst().get().getKey();
    }
}
