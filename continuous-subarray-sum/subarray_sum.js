/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var checkSubarraySum = function(nums, k) {
    let prefixSum = [];
    prefixSum[0] = 0;
    for(let i = 0; i < nums.length; i++) {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    for(let i = 0; i < nums.length - 1; i++) {
        for(let j = i + 2; j <= nums.length; j++) {
            // need to optimize using remainder hash map
            if((prefixSum[j] - prefixSum[i]) % k == 0) {
                return true;
            }
        }
    }
    return false;
};
