class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));

        Map<String, String> lowerMap = new HashMap<>();

        Map<String, String> vowelMap = new HashMap<>();

        for (String word : wordlist) {
            String lower = word.toLowerCase();
            String devowel = devowel(lower);

            lowerMap.putIfAbsent(lower, word);
            vowelMap.putIfAbsent(devowel, word);
        }

        String[] res = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (words.contains(q)) {
                res[i] = q;
                continue;
            }

            String lowerQ = q.toLowerCase();
            if (lowerMap.containsKey(lowerQ)) {
                res[i] = lowerMap.get(lowerQ);
                continue;
            }

            String devowelQ = devowel(lowerQ);
            if (vowelMap.containsKey(devowelQ)) {
                res[i] = vowelMap.get(devowelQ);
                continue;
            }

            res[i] = "";
        }

        return res;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                sb.append("*");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}