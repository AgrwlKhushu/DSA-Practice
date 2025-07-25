class Solution {
    public void merge(int[]arr, int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;
        while(i <= mid && j <= high){
            long n = 10, m = 10;
            while(arr[i] >= n){
                n *= 10;
            }
            while(arr[j] >= m){
                m *= 10;
            }
            long l = arr[i] * m + arr[j];
            long r = arr[j] * n + arr[i];
            if(l > r){
              temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[k++] = arr[i++];

        }
        while(j <= high){
            temp[k++] = arr[j++];
        }
        k = 0;
        int m = low;
        while(m <= high){
            arr[m++] = temp[k++];
        }
    }
    public void mergesort(int[]arr, int low, int high){
        if(low == high){
            return ;
        }
        int mid = low + (high - low) / 2;
        mergesort(arr, low, mid);
        mergesort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
    public String largestNumber(int[] nums) {
       mergesort(nums, 0, nums.length - 1);
       StringBuilder str = new StringBuilder();
       for(int i = 0; i < nums.length; i++){
         str.append(String.valueOf(nums[i]));
       }
       return (str.charAt(0) == '0') ? "0" : str.toString();
    }
}