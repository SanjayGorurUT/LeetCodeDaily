/**
 * @param {number[]} arr
 * @param {number} k
 * @return {boolean}
 */
var canArrange = function(arr, k) {
    let rems = [];
    for(let i = 0; i < k; i++) {
        rems.push(0);
    }
    for(let i = 0; i < arr.length; i++) {
        let rem = ((arr[i] % k) + k) % k;
        rems[rem]++;
    }
    if(rems[0] % 2 != 0) return false;
    for(let i = 1; i <= k/2; i++) {
        if(rems[i] != rems[k - i]) return false;
    }
    return true;
};