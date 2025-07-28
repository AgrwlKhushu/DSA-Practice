class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        while(r < s.length()){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                maxLen = Math.max(maxLen, r - l + 1);
            }
            else{
                while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }

                set.add(s.charAt(r));
            }

            r++;
        }

        return maxLen;
    }
}