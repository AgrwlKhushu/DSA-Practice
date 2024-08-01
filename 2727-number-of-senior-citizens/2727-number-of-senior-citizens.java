class Solution {
    public int countSeniors(String[] details) {
        int seniorCount = 0;

        for (String passengerInfo : details) {
            int ageTens = passengerInfo.charAt(11) - '0';
            int ageOnes = passengerInfo.charAt(12) - '0';

            int age = ageTens * 10 + ageOnes;

            if (age > 60) {
                seniorCount++;
            }
        }

        return seniorCount;
    }
}