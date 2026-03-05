class Solution {
    public static int helper(char ch[]) {
        int ans = 0;
        int n = ch.length;
        for (int i = 1; i < n; i++) {
            if (ch[i] != ch[i - 1])
                continue;
            ch[i] = ch[i - 1] == '0' ? '1' : '0';
            ans++;
        }
        return ans;
    }

    public int minOperations(String s) {
        int n = s.length();
        char ch1[] = s.toCharArray();
        int ans1 = helper(ch1);
        char ch2[] = s.toCharArray();
        ch2[0] = ch2[0] == '0' ? '1' : '0';
        int ans2 = helper(ch2) + 1;
        return Math.min(ans1, ans2);
    }
}