package dsa.assignment;

import java.util.Arrays;

public class FindNonRepeatingElements {

    public static void findNonRepeating(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int rightmostSetBit = xor & -xor;
        int result1 = 0;
        int result2 = 0;

        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) {
                result1 ^= num;
            } else {
                result2 ^= num;
            }
        }

        System.out.println("Non-repeating elements are: " + result1 + " and " + result2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1, 4};
        findNonRepeating(nums);
    }
}