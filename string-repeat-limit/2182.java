class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            charCounts.put(s.charAt(i), charCounts.getOrDefault(s.charAt(i), 0) + 1);
        }
        // System.out.println(charCounts);
        TreeSet<Character> copyOrder = new TreeSet<>(charCounts.keySet());
        ArrayList<Character> flipOrder = new ArrayList<>(copyOrder);
        int i = flipOrder.size() - 1;
        int j = i - 1;
        int currCount = 0;
        String result = "";
        while(i >= 0) {
            if(currCount < repeatLimit) {
                if(charCounts.get(flipOrder.get(i)) > 0) {
                    result += Character.toString(flipOrder.get(i));
                    currCount++;
                    charCounts.put(flipOrder.get(i), charCounts.get(flipOrder.get(i)) - 1);
                    if(charCounts.get(flipOrder.get(i)) == 0) {
                        currCount = 0;
                    }
                }
                else {
                    i--;
                    j = i - 1;
                    currCount = 0;
                }
            }
            else {
                if(j >= 0) {
                    if(charCounts.get(flipOrder.get(j)) > 0) {
                        result += Character.toString(flipOrder.get(j));
                        currCount = 0;
                        charCounts.put(flipOrder.get(j), charCounts.get(flipOrder.get(j)) - 1);
                    }
                    else {
                        j--;
                    }
                }
                else {
                    break;
                }
            }
        }
        return result;
    }
}