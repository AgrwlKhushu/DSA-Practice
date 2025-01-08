class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;

        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(isPrefixSuffix(words[i], words[j])){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public boolean isPrefixSuffix(String s1, String s2){
        return s2.startsWith(s1) && s2.endsWith(s1);
    }
}