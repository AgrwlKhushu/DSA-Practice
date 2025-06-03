class Solution {
    public String reverseWords(String s) {
        String ans = "";
        boolean first = true;

        String[] str = s.trim().split("\\s+");

        for(int i = str.length - 1; i >= 0; i--){
            if(!first){
                ans += " ";
            }
            ans += str[i];
            first = false;
        }

        return ans;
    }
}