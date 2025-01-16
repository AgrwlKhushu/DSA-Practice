class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int x1 = 0, x2 = 0;

        if(n % 2 != 0){
            for(int num : nums2){
                x2 ^= num;
            }
        }

        if(m % 2 != 0){
            for(int num :  nums1){
                x1 ^= num;
            }
        }

        return x1 ^ x2;
    }
}