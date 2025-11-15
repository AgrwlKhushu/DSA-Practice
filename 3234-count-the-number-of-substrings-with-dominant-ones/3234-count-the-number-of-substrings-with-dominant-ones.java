class Solution {
    public int numberOfSubstrings(String s) {
        return prefixEnumeration(s);
    }

  private int prefixEnumeration(String s) {
    int n = s.length();

    int[] zerosIdx = new int[n + 1];
    int nextZeroIdx = 1;
    zerosIdx[0] = -1;

    int totalOnes = 0;

    int res = 0;

    for(int right = 0; right < n; right++) {
      if(s.charAt(right) == '0') {
        zerosIdx[nextZeroIdx++] = right;
      } else {
        res += right - zerosIdx[nextZeroIdx - 1];
        totalOnes++;
      }

      for(int zeroPos = nextZeroIdx - 1; zeroPos > 0 && (nextZeroIdx - zeroPos) * (nextZeroIdx - zeroPos) <= totalOnes; zeroPos--) {
        int zerosCount = nextZeroIdx - zeroPos; 

        int onesCount = right - zerosIdx[zeroPos] + 1 - zerosCount;

        int onesDeficit = zerosCount * zerosCount - onesCount;

        int extendable = zerosIdx[zeroPos] - zerosIdx[zeroPos - 1];

        res += Math.max(extendable - Math.max(onesDeficit, 0), 0);
      }
    }

    return res;
  }
}