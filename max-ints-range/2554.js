/**
 * @param {number[]} banned
 * @param {number} n
 * @param {number} maxSum
 * @return {number}
 */
var maxCount = function(banned, n, maxSum) {
    let [start, count, cpyBanned, sum] = [1, 0, new Set(banned), 0];
    while(start <= n && sum < maxSum) {
     if(!banned.includes(start)) {
         count++;
         sum += start;
     }
     start++;
    }
    return sum > maxSum ? count - 1 : count; 
 };