class Solution {
    class Fraction {
        public boolean isNegative;
        public int numerator;
        public int denominator;

        public void placeNumerator(char n) {
            if(numerator > 0) {
                numerator *= 10;
            }
            numerator += Character.getNumericValue(n);
        }
        public void placeDenominator(char n) {
            if(denominator > 0) {
                denominator *= 10;
            }
            denominator += Character.getNumericValue(n);
        }
        public int getSignedNumerator() {
            return isNegative ? -numerator : numerator;
        }
        public void add(Fraction other) {
            int finalResult = this.getSignedNumerator() +
                other.getSignedNumerator();

            this.isNegative = (finalResult < 0);
            this.numerator = Math.abs(finalResult);

            if(finalResult == 0) {
                this.denominator = 1;
            }
        }
        public void reduce() {
            if(denominator == 1) {
                return;
            }
            if(denominator % numerator == 0) {
                denominator = denominator / numerator;
                numerator = 1;
                return;
            }
            if(numerator % denominator == 0) {
                numerator = numerator / denominator;
                denominator = 1;
                return;
            }
            int multipleCap = Math.min(numerator, denominator) / 2;

            for(int i = 2; i <= multipleCap; i++) {
                // If not evenly divisible, continue.
                if(numerator % i != 0 || denominator % i != 0) {
                    continue;
                }
                numerator = numerator / i;
                denominator = denominator / i;
                multipleCap = Math.min(numerator, denominator) / 2;
                i = 1;
            }
        }
        public String toString() {
            StringBuilder str = new StringBuilder();
            if(isNegative) {
                str.append('-');
            }
            str.append(numerator);
            str.append('/');
            str.append(denominator);
            return str.toString();
        }
    }
    public String fractionAddition(String expression) {

        ArrayList<Fraction> allFractions = parseFractions(expression);
        Fraction baseFraction = allFractions.get(0);

        for(int i = 1; i < allFractions.size(); i++) {
            Fraction actedUponFraction = allFractions.get(i);

            int baseDenominator = baseFraction.denominator;
            baseFraction.numerator *= actedUponFraction.denominator;
            baseFraction.denominator *= actedUponFraction.denominator;
            actedUponFraction.numerator *= baseDenominator;
            actedUponFraction.denominator *= baseDenominator;

            baseFraction.add(actedUponFraction);
            baseFraction.reduce();
        }
        return baseFraction.toString();
    }
    public ArrayList<Fraction> parseFractions(String expression) {
        ArrayList<Fraction> allFractions = new ArrayList<>();
        int i = 0;
        do {
            Fraction fraction = new Fraction();
            char currentChar = expression.charAt(i);

            if(currentChar == '-') {
                fraction.isNegative = true;
                i = i + 1;
            }
            if(currentChar == '+') {
                i = i + 1;
            }
            currentChar = expression.charAt(i);
            do {
                fraction.placeNumerator(currentChar);
                i = i + 1;
                currentChar = expression.charAt(i);
            } while(currentChar != '/');
            i = i + 1;

            currentChar = expression.charAt(i);
            do {
                fraction.placeDenominator(currentChar);
                i = i + 1;

                if(i >= expression.length()) {
                    break;
                }
                currentChar = expression.charAt(i);

            } while(i < expression.length() && 
                currentChar != '+' &&
                currentChar != '-');

            allFractions.add(fraction);

        } while(i < expression.length());

        return allFractions;
    }
}