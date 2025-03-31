class Solution {
    public int maxScore(String s) {
        int n = s.length();
        HashMap<Integer, Integer> zeros = new HashMap<>(); 
        HashMap<Integer, Integer> ones = new HashMap<>(); 
        for(int i = 0; i < n - 1; i++) {
            int currZeros = zeros.getOrDefault(i, 0);
            if(s.charAt(i) == '0') {
                currZeros++;
            }
            zeros.put(i + 1, currZeros);
        }
        for(int i = n - 1; i > 0; i--) {
            int currOnes = ones.getOrDefault(i, 0);
            if(s.charAt(i) == '0') {
                currOnes++;
            }
            ones.put(i - 1, currOnes);
        }
        int maxScore = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++) {
            maxScore = (int) Math.max(maxScore, zeros.get(i) + ones.get(i));
        }
        return maxScore;
    }

    // Line 22 throwing return null -> issue with ones map
}
