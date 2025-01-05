import java.util.*;

class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            long product = 1;   // To track product of the current subarray
            long gcd = 0;       // To track GCD of the current subarray
            long lcm = 1;       // To track LCM of the current subarray

            for (int j = i; j < n; j++) {
                if (product > Long.MAX_VALUE / nums[j]) {
                    break; // Stop loop if the product will overflow
                }

                product *= nums[j]; // Update the product
                gcd = gcd(gcd, nums[j]); // Update the GCD
                lcm = lcm(lcm, nums[j]); // Update the LCM
                
                // Check if product is valid for current GCD and LCM
                if (product == gcd * lcm) {
                    maxLength = Math.max(maxLength, j - i + 1); // Update max length
                }
            }
        }

        return maxLength;
    }

    // Helper method to compute GCD using the Euclidean algorithm
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Helper method to compute LCM safely
    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0; // Handle edge case
        return (a / gcd(a, b)) * b; // LCM formula
    }
}
