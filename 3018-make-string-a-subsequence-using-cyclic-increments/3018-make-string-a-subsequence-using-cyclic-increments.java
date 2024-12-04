class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int targetIdx = 0, str2Len = str2.length();
        
        for (char currChar : str1.toCharArray()) {
            if (targetIdx < str2Len && (str2.charAt(targetIdx) - currChar + 26) % 26 <= 1) {
                targetIdx++;
            }
        }
        return targetIdx == str2Len;
    }
}