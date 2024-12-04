/**
 * @param {string} str1
 * @param {string} str2
 * @return {boolean}
 */
var canMakeSubsequence = function(str1, str2) {
    let [i, j] = [0, 0]; // str trackers
    while(i < str1.length) { // O(n)
        if(j >= str2.length) { // did we already complete subseq
            return true;
        }
        if(str1[i] == str2[j] || (str1[i] == 'z' && str2[j] == 'a') ||
          (str2[j].charCodeAt(0) - str1[i].charCodeAt(0) == 1)) {
            // same char
            // cycle from z to a
            // one char diff
            j++;
          }
        i++;
    }
    return (j >= str2.length) ? true : false; // last check in case fulfilled at end
};

function main() {
    console.log(canMakeSubsequence('abc', 'ad'));
}

main(); // test