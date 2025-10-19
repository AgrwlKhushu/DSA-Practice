class Solution {
    public String findLexSmallestString(String S, int a, int b) {
        char[] s = S.toCharArray();
        int n = s.length;
        char[] t = new char[n];
        int step = gcd(b, n);
        int g = gcd(a, 10);
        String ans = null;

        for (int i = 0; i < n; i += step) {
            System.arraycopy(s, i, t, 0, n - i);
            System.arraycopy(s, 0, t, n - i, i);

            modify(t, 1, g);
            if (step % 2 > 0) {
                modify(t, 0, g);
            }

            String str = new String(t);
            if (ans == null || str.compareTo(ans) < 0) {
                ans = str;
            }
        }

        return ans;
    }

    private void modify(char[] t, int start, int g) {
        int ch = t[start] - '0';
        int inc = ch % g - ch + 10;
        for (int j = start; j < t.length; j += 2) {
            t[j] = (char) ('0' + (t[j] - '0' + inc) % 10);
        }
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}