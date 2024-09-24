/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number}
 */
var longestCommonPrefix = function(arr1, arr2) {
    let allPrefixes = new Set();
    for(let elem of arr1) {
        let prefixStr = "";
        let copy = String(elem);
        for(let i = 0; i < copy.length; i++) {
            prefixStr += copy.charAt(i);
            if(!allPrefixes.has(prefixStr)) {
                allPrefixes.add(prefixStr);
            }
        }
    }
    let maxPreLen = 0;
    for(let elem of arr2) {
        let compStr = "";
        let copy = String(elem);
        for(let i = 0; i < copy.length; i++) {
            compStr += copy.charAt(i);
            if(allPrefixes.has(compStr)) {
                maxPreLen = Math.max(maxPreLen, compStr.length);
            }
        } 
    }
    return maxPreLen;
};