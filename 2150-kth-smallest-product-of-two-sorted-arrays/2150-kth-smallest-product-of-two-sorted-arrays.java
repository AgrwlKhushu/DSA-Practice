class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        if (nums1.length > nums2.length) {
            return kthSmallestProduct(nums2, nums1, k);
        }

        long lo = -1_0000_0000_00L;
        long hi = 1_0000_0000_00L;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long cnt = countLE(mid, nums1, nums2);

            if (cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    public long countLE(long x, int[] A, int[] B) {
        long count = 0;
        int n = B.length;

        if (x >= 0) {
            int jPos = n - 1;
            int jNeg = n - 1;

            for (int a : A) {
                if (a > 0) {
                    while (jPos >= 0 && a * 1L * B[jPos] > x) {
                        jPos--;
                    }

                    count += jPos + 1;
                } else if (a == 0) {
                    count += n;
                } else {
                    while (jNeg >= 0 && a * 1L * B[jNeg] <= x) {
                        jNeg--;
                    }

                    count += n - 1 - jNeg;
                }
            }
        } else {
            int jPos = 0;
            int jNeg = 0;

            for (int a : A) {
                if (a > 0) {
                    while (jPos < n && a * 1L * B[jPos] <= x) {
                        jPos++;
                    }

                    count += jPos;
                } else if (a == 0) {
                } else {
                    while (jNeg < n && a * 1L * B[jNeg] > x) {
                        jNeg++;
                    }

                    count += n - jNeg;
                }
            }
        }

        return count;
    }
}