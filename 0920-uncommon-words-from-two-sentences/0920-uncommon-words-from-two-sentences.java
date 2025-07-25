class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> hm = new HashMap<>();
        String[] Array1 = s1.split(" ");
        String[] Array2 = s2.split(" ");

        for (int i = 0; i < Array1.length; i++) {
            if (!hm.containsKey(Array1[i])) hm.put(Array1[i], 1);
            else hm.put(Array1[i], hm.get(Array1[i]) + 1); 
        }
        for (int i = 0; i < Array2.length; i++) {
            if (!hm.containsKey(Array2[i])) hm.put(Array2[i], 1);
            else hm.put(Array2[i], hm.get(Array2[i]) + 1); 
        }

        ArrayList<String> ansList = new ArrayList<>();
        for (Map.Entry<String,Integer> x : hm.entrySet()) {
            if (x.getValue()<= 1) {
                ansList.add(x.getKey());
            }
        }

        String[] stringArray = ansList.toArray(new String[0]);
        return stringArray;
    }
}