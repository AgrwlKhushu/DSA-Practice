class Solution {
    private boolean sol(int[] i, String s) {
        char exp = s.charAt(i[0]); 
        boolean tPresent = false, fPresent = false; // declare two variables for check if true is present and false is present

        i[0] += 2; // it skips '(' and move to expression inside it

        while (s.charAt(i[0] - 1) != ')') { // if we skip closing bracket then it break 
            if (s.charAt(i[0]) == 't') tPresent = true;
            else if (s.charAt(i[0]) == 'f') fPresent = true;
            else { // if any other operator with another brackets is present
                boolean rec = sol(i, s); // do recursive call and calculate the value
                if (rec) tPresent = true;
                else fPresent = true;
            }
            i[0] += 2; // again skip ','
        }
        i[0]--; // go to index after this ')'

        if (exp == '|') return tPresent; // if true present return true
        if (exp == '&') return !fPresent; // if false present return false

        // if '!' is there
        return !tPresent;
    }
    public boolean parseBoolExpr(String expression) {
        int[] i = {0};
        return sol(i, expression);
    }
}