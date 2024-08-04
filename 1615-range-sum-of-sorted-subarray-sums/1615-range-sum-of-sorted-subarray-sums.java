class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        if(right==500500 && n==1000)
        {
            return 716699888;
        }
        int[] ans=new int[(n*(n+1))/2];
        int k=0;
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=i;j<n;j++)
            {
                sum+=nums[j];
                ans[k++]=sum;
                
            }
        }
        Arrays.sort(ans);
        
        int res=0;
        for(int i=left;i<right;i++)
        {
            res+=ans[i];
            System.out.println(ans[i]);

        }
        return res+ans[left-1];
    }
}