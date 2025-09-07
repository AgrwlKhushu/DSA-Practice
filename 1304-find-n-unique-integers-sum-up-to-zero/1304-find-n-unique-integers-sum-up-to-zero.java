class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int current_index = 0;

        for (int i = 1; i <= n / 2; i++) {
            arr[current_index++] = -i;
        }

        if (n % 2 != 0) {
            arr[current_index++] = 0;
        }

        for (int i = 1; i <= n / 2; i++) {
            arr[current_index++] = i;
        }

        return arr;
    }
}