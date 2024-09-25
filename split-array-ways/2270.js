/**
 * @param {number[]} nums
 * @return {number}
 */
var waysToSplitArray = function(nums) {
    let sum = 0;
    let indMap = new Map();
    for(let i = 0; i < nums.length; i++) {
        sum += nums[i];
        indMap.set(i, sum);
    }
    let splitCount = 0;
    for(let i = 0; i < nums.length - 1; i++) {
        if(indMap.get(i) >= (sum - indMap.get(i))) {
            splitCount++;
        }
    }
    return splitCount;
};