/**
 * @param {string} s1
 * @param {string} s2
 * @return {string[]}
 */
var uncommonFromSentences = function(s1, s2) {
    let [words1, words2] = [s1.split(' '), s2.split(' ')];
    let [set1, set2] = [new Map(), new Map()];
    for(let i = 0; i < words1.length; i++) {
        if(!set1.has(words1[i])) {
            set1.set(words1[i], 0);
        }
        set1.set(words1[i], set1.get(words1[i]) + 1);
    }
    for(let i = 0; i < words2.length; i++) {
        if(!set2.has(words2[i])) {
            set2.set(words2[i], 0);
        }
        set2.set(words2[i], set2.get(words2[i]) + 1);
    }
    let uncommonWords = [];
    for(let i = 0; i < words1.length; i++) {
        if(!set2.has(words1[i]) && set1.get(words1[i]) == 1) {
            uncommonWords.push(words1[i]);
        }
    }
    for(let i = 0; i < words2.length; i++) {
        if(!set1.has(words2[i]) && set2.get(words2[i]) == 1) {
            uncommonWords.push(words2[i]);
        }
    }
    return uncommonWords;
};