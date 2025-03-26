class Solution {
    public boolean isDecomposable(String s) {
        int n = s.length();
        List<Integer> duoValEquals = new ArrayList<>();
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                duoValEquals.add(i);
            }
        }
        boolean decomposable = true;
        for(int ind: duoValEquals) {
            String trio = "";
            for(int i = 0; i < n; i++) {
                if(trio.isEmpty() && i != ind && i != ind + 1) {
                    trio += Character.toString(s.charAt(i));
                } else if(i != ind && i != ind + 1) {
                    if(trio.charAt(0) != s.charAt(i)) {
                        decomposable = false;
                        break;
                    }
                    trio += Character.toString(s.charAt(i));
                }
                if(trio.length() == 3) {
                    trio = "";
                }
            }
            if(decomposable && trio.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
