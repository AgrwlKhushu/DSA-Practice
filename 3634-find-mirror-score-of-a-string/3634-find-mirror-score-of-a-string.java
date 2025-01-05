import java.util.*;

class Solution {
    public long calculateScore(String s) {
        int n = s.length();
        long score = 0;

        // Map to store mirror characters
        Map<Character, Character> mirrorMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            mirrorMap.put(c, (char) ('z' - (c - 'a')));
        }

        // Stack to keep track of unmarked indices for each character
        Stack<Integer>[] charStacks = new Stack[26];
        for (int i = 0; i < 26; i++) {
            charStacks[i] = new Stack<>();
        }

        // Traverse the string
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            char mirrorChar = mirrorMap.get(currentChar);

            // Check if there is a matching unmarked index for the current character
            int mirrorIndex = mirrorChar - 'a';
            if (!charStacks[mirrorIndex].isEmpty()) {
                // Get the closest unmarked index
                int closestIndex = charStacks[mirrorIndex].pop();
                score += (i - closestIndex);
            } else {
                // Push the current index to the stack of the current character
                charStacks[currentChar - 'a'].push(i);
            }
        }

        return score;
    }
}
