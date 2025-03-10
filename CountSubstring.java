class Solution {
    public long countOfSubstrings(String word, int k) {
        HashMap<Integer, HashMap<Character, Integer>> vowels = new HashMap<>(); 
        // maximum 5 per index

        HashMap<Integer, Integer> consts = new HashMap<>();
        // consonants from beginning to index

        HashSet<Character> checkVowels = new HashSet<>();
        checkVowels.add('a');
        checkVowels.add('e');
        checkVowels.add('i');
        checkVowels.add('o');
        checkVowels.add('u');
        // populate all vowels

        int n = word.length();
        for(int i = 0; i < n; i++) {
            if(i == 0) { // start of string
                vowels.put(i, new HashMap<Character, Integer>());
                consts.put(i, 0);
            } else { // continue processing
                vowels.put(i, new HashMap<Character, Integer>(vowels.get(i - 1)));
                consts.put(i, consts.get(i - 1));
            }
            if(checkVowels.contains(word.charAt(i))) { // char is vowel
                char curr = word.charAt(i);
                int amount = vowels.get(i).getOrDefault(curr, 0);
                vowels.get(i).put(curr, amount + 1);
            } else { // char is consonant
                consts.put(i, consts.get(i) + 1);
            }
        }

        int validStrCount = 0;

        vowels.put(-1, new HashMap<Character, Integer>()); // empty trackers for full string comparison
        consts.put(-1, 0);

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                boolean validSub = true;
                int consCount = consts.get(j - 1) - consts.get(i - 1); // substring consonant count
                if(consCount != k) {
                    validSub = false;
                }
                int vowelCount = 0;
                for(char key: vowels.get(j - 1).keySet()) { // substring unique vowel check -> 5 only
                    int currVowelCount = vowels.get(j - 1).getOrDefault(key, 0) - vowels.get(i - 1).getOrDefault(key, 0);
                    if(currVowelCount <= 0) {
                        validSub = false;
                        break;
                    }
                    vowelCount++;
                }
                // System.out.println(vowels);
                if(vowelCount < 5) {
                    validSub = false;
                }
                if(validSub) {
                    validStrCount++;
                }
            }
        }

        return validStrCount;
    }
}
