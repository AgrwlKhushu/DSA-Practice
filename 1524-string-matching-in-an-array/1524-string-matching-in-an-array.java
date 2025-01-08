class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String curr = words[i];
            if(isSubstring(words, curr, i)){
                res.add(curr);
            }
        }
        return res;
    }

    public boolean isSubstring(String[] words, String curr, int i){
        for(int j = 0; j < words.length; j++){
            if(j == i){
                continue;
            }
            String other = words[j];
            if(other.contains(curr)){
                return true;
            }
        }
        return false;
    }
}