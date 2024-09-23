/**
 * @param {string} s
 * @param {string[]} dictionary
 * @return {number}
 */
var minExtraChar = function(s, dictionary) {
    let [allWords, n] = 
    [new Set(dictionary), s.length];
    let dp = Array(n + 1).fill(n);
    dp[0] = 0;
    for(let i = 1; i <= n; i++) {
        for(let j = 0; j < i; j++) {
            let substr = s.substr(j, i - j);
            if(allWords.has(substr)) {
                dp[i] = Math.min(dp[i], dp[j]);
            }
        }
        dp[i] = Math.min(dp[i], dp[i - 1] + 1);
    }
    return dp[n];
};